package com.toy4codes.website.framework.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

public class FTPUtil {

	private static final Logger log = Logger.getLogger(FTPUtil.class);

	// set timeout to 5 minutes
	private static final int CONTROL_KEEPALIVE_TIMEOUT = 300;

	/**
	 * ftp client connection and login
	 */
	public static FTPClient getClient(String hostname, int port, String username, String password) {

		FTPClient ftpClient = new FTPClient();

		// change required options
		FTPClientConfig config = new FTPClientConfig();
		ftpClient.configure(config);
		ftpClient.setControlKeepAliveTimeout(CONTROL_KEEPALIVE_TIMEOUT);

		try {

			ftpClient.connect(hostname, port);
			log.debug("connected to " + hostname + " on " + port);

			// After connection attempt, you should check the reply code to verify
			// success.
			int reply = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				log.error("FTP server refused connection.");
			}

			ftpClient.login(username, password);

		} catch (IOException e) {

			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException ioe) {
					// do nothing
				}
			}

			log.error("Could not connect to server.", e);
		}

		return ftpClient;
	}

	/**
	 * Download a whole directory from a FTP server.
	 */
	public static void downloadDirectory(FTPClient ftpClient, String remoteDir, String saveDir) throws IOException {

		FTPFile[] ftpSubFiles = ftpClient.listFiles(remoteDir);

		if (null != ftpSubFiles && ftpSubFiles.length > 0) {

			for (FTPFile ftpFile : ftpSubFiles) {

				String ftpFileName = ftpFile.getName();

				if (ftpFileName.equals(".") || ftpFileName.equals("..")) {
					// skip parent directory and the directory itself
					continue;
				}

				String ftpFilePath = remoteDir + "/" + ftpFileName;
				if (remoteDir.endsWith("/")) {
					ftpFilePath = remoteDir + ftpFileName;
				}

				// tranform ftp-default-file-separator to windows-file-separator
				String windowsFtpFilePath = StringUtils.EMPTY;
				if (ftpFilePath.contains("/")) {
					windowsFtpFilePath = ftpFilePath.replaceAll("/", "\\\\");
				}

				String localDirPath = saveDir + windowsFtpFilePath;

				if (ftpFile.isDirectory()) {
					// create the directory in saveDir
					File localDir = new File(localDirPath);
					boolean created = localDir.mkdirs();
					if (created) {
						log.debug("created local directory: " + localDirPath);
					} else {
						log.error("could not create local directory: " + localDirPath);
					}
					// download the sub directory
					downloadDirectory(ftpClient, ftpFilePath, saveDir);
				} else {
					// download the file
					boolean success = downloadSingleFile(ftpClient, ftpFilePath, localDirPath);
					if (success) {
						log.debug("downloaded ftp file : " + ftpFilePath);
					} else {
						log.error("could not download ftp file : " + ftpFilePath);
					}
				}

			}
		}
	}

	public static boolean downloadSingleFile(FTPClient ftpClient, String remoteFilePath, String savePath)
			throws IOException {

		File downloadFile = new File(savePath);
		File parentDir = downloadFile.getParentFile();

		if (!parentDir.exists()) {
			parentDir.mkdir();
		}

		OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(downloadFile));

		try {
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			return ftpClient.retrieveFile(remoteFilePath, outputStream);
		} catch (IOException e) {
			log.error("download " + remoteFilePath + " exception.");
			throw e;
		} finally {
			if (null != outputStream) {
				outputStream.close();
			}
		}

	}

	/**
	 * log out and disconnect from the server
	 */
	public static void releaseClient(FTPClient ftpClient) {

		try {
			ftpClient.logout();
		} catch (IOException e) {
			log.error("ftp client logout exception.", e);
		}

		try {
			ftpClient.disconnect();
		} catch (IOException e) {
			log.error("ftp client disconnect exception.", e);
		}

		log.debug("ftp client connection released.");

	}

}
