package com.toy4codes.website.framework.beans;

public class PM25 {

	public int id;

	private int year;

	private int month;

	private int day;

	private int hour;

	private int pm25;

	private int dewPoint;

	private int temperature;

	private int pressure;

	private String combinedWindDirection;

	private float cumulatedWindSpeed;

	private int cumnlatedHoursOfSnow;

	private int cumulatedHoursOfRain;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getPm25() {
		return pm25;
	}

	public void setPm25(int pm25) {
		this.pm25 = pm25;
	}

	public int getDewPoint() {
		return dewPoint;
	}

	public void setDewPoint(int dewPoint) {
		this.dewPoint = dewPoint;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public String getCombinedWindDirection() {
		return combinedWindDirection;
	}

	public void setCombinedWindDirection(String combinedWindDirection) {
		this.combinedWindDirection = combinedWindDirection;
	}

	public float getCumulatedWindSpeed() {
		return cumulatedWindSpeed;
	}

	public void setCumulatedWindSpeed(float cumulatedWindSpeed) {
		this.cumulatedWindSpeed = cumulatedWindSpeed;
	}

	public int getCumnlatedHoursOfSnow() {
		return cumnlatedHoursOfSnow;
	}

	public void setCumnlatedHoursOfSnow(int cumnlatedHoursOfSnow) {
		this.cumnlatedHoursOfSnow = cumnlatedHoursOfSnow;
	}

	public int getCumulatedHoursOfRain() {
		return cumulatedHoursOfRain;
	}

	public void setCumulatedHoursOfRain(int cumulatedHoursOfRain) {
		this.cumulatedHoursOfRain = cumulatedHoursOfRain;
	}

}
