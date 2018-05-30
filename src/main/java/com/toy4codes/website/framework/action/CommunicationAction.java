package com.toy4codes.website.framework.action;

import java.util.Random;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.toy4codes.website.framework.beans.PollingDataWrapper;

public class CommunicationAction extends ActionSupport {

	private static final long serialVersionUID = 5367652264336071757L;

	private static final Logger log = Logger.getLogger(CommunicationAction.class);

	private String requestTime;

	private PollingDataWrapper pollingDataWrapper;

	public String ajaxPolling() {

		// bussiness dealing ...
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			log.warn(e.getMessage());
		}

		if (isDataChange()) {
			String bussinessData = "bussiness data change";
			pollingDataWrapper = new PollingDataWrapper(Long.parseLong(requestTime), System.currentTimeMillis(),
					bussinessData);
		} else {
			pollingDataWrapper = new PollingDataWrapper();
		}

		return SUCCESS;
	}

	public String ajaxLongPolling() {

		while (true) {

			// bussiness dealing ...
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				log.warn(e.getMessage());
				break;
			}

			if (isDataChange()) {
				log.info(requestTime + " : bussiness data changed");
				String bussinessData = "bussiness data change";
				long responseTime = System.currentTimeMillis();
				pollingDataWrapper = new PollingDataWrapper(Long.parseLong(requestTime), responseTime, bussinessData);
				break;
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					log.warn(e.getMessage());
					break;
				}
			}

		}

		return SUCCESS;
	}

	private boolean isDataChange() {
		Random rand = new Random();
		int i = rand.nextInt(10000);
		if (i <= 100) {
			return true;
		} else {
			return false;
		}
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public PollingDataWrapper getPollingDataWrapper() {
		return pollingDataWrapper;
	}

	public void setPollingDataWrapper(PollingDataWrapper pollingDataWrapper) {
		this.pollingDataWrapper = pollingDataWrapper;
	}

}
