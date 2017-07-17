package com.toy4codes.website.framework.beans;

public class SystemInfo {

	private String name;

	private String version;

	private static SystemInfo instance;
	
	private static final Object lock = new Object();
	
	private SystemInfo() {
		this.name = "website.framework";
		this.version = "version 1.0.0";
	}

	public static SystemInfo getInstance() {
		if (null == instance) {
			synchronized (lock) {
				if (null == instance) {
					instance = new SystemInfo();
				}
			}
		}
		return instance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
