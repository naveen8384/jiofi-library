package org.naveenkumar.jiofiinfo.bean;

import java.io.Serializable;

public class DeviceDetails implements Serializable{

	private static final long serialVersionUID = 1L;
	String time = "";
    String serialNumber = "";
    String imei = "";
    String imsi = "";
    String macAddress = "";
    String batteryPercentage = "";
    String batteryStatus = "";
    String currentUploadSpeed = "";
    String currentDownloadSpeed = "";
    String maxUploadSpeed = "";
    String maxDownloadSpeed = "";
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getBatteryPercentage() {
		return batteryPercentage;
	}
	public void setBatteryPercentage(String batteryPercentage) {
		this.batteryPercentage = batteryPercentage;
	}
	public String getBatteryStatus() {
		return batteryStatus;
	}
	public void setBatteryStatus(String batteryStatus) {
		this.batteryStatus = batteryStatus;
	}
	public String getCurrentUploadSpeed() {
		return currentUploadSpeed;
	}
	public void setCurrentUploadSpeed(String currentUploadSpeed) {
		this.currentUploadSpeed = currentUploadSpeed;
	}
	public String getCurrentDownloadSpeed() {
		return currentDownloadSpeed;
	}
	public void setCurrentDownloadSpeed(String currentDownloadSpeed) {
		this.currentDownloadSpeed = currentDownloadSpeed;
	}
	public String getMaxUploadSpeed() {
		return maxUploadSpeed;
	}
	public void setMaxUploadSpeed(String maxUploadSpeed) {
		this.maxUploadSpeed = maxUploadSpeed;
	}
	public String getMaxDownloadSpeed() {
		return maxDownloadSpeed;
	}
	public void setMaxDownloadSpeed(String maxDownloadSpeed) {
		this.maxDownloadSpeed = maxDownloadSpeed;
	}
    
    
}
