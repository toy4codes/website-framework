package com.toy4codes.website.framework.beans;

public class PollingDataWrapper {

	private long startTime;

	private long endTime;

	private long timeInterval;
	
	private String bussinessData;

	public PollingDataWrapper() {
		super();
	}
	
	public PollingDataWrapper(long startTime, long endTime, String bussinessData) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.timeInterval = endTime - startTime;
		this.bussinessData = bussinessData;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public long getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(long timeInterval) {
		this.timeInterval = timeInterval;
	}

	public String getBussinessData() {
		return bussinessData;
	}

	public void setBussinessData(String bussinessData) {
		this.bussinessData = bussinessData;
	}
	
}
