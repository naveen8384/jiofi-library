package org.naveenkumar.jiofiinfo.bean;

import java.io.Serializable;

public class LanDetails implements Serializable{
	private static final long serialVersionUID = 1L;
	
	String ssid = "";
    String lanOperatingMode = "";
    String macAddress = "";
    String subnetMask = "";
    String gatewayIp = "";
    String noOfUsers = "";
    String wifiChannel = "";
    String lanBandwidth = "";
    String wirelessSecurityMode = "";
    String wirelessEncType = "";
    String channelSelection = "";
    String wifiStatus = "";
    
    
	public String getSsid() {
		return ssid;
	}
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	public String getLanOperatingMode() {
		return lanOperatingMode;
	}
	public void setLanOperatingMode(String lanOperatingMode) {
		this.lanOperatingMode = lanOperatingMode;
	}
	public String getSubnetMask() {
		return subnetMask;
	}
	public void setSubnetMask(String subnetMask) {
		this.subnetMask = subnetMask;
	}
	public String getGatewayIp() {
		return gatewayIp;
	}
	public void setGatewayIp(String gatewayIp) {
		this.gatewayIp = gatewayIp;
	}
	public String getNoOfUsers() {
		return noOfUsers;
	}
	public void setNoOfUsers(String noOfUsers) {
		this.noOfUsers = noOfUsers;
	}
	public String getWifiChannel() {
		return wifiChannel;
	}
	public void setWifiChannel(String wifiChannel) {
		this.wifiChannel = wifiChannel;
	}
	public String getLanBandwidth() {
		return lanBandwidth;
	}
	public void setLanBandwidth(String lanBandwidth) {
		this.lanBandwidth = lanBandwidth;
	}
	public String getWirelessSecurityMode() {
		return wirelessSecurityMode;
	}
	public void setWirelessSecurityMode(String wirelessSecurityMode) {
		this.wirelessSecurityMode = wirelessSecurityMode;
	}
	public String getWirelessEncType() {
		return wirelessEncType;
	}
	public void setWirelessEncType(String wirelessEncType) {
		this.wirelessEncType = wirelessEncType;
	}
	public String getChannelSelection() {
		return channelSelection;
	}
	public void setChannelSelection(String channelSelection) {
		this.channelSelection = channelSelection;
	}
	public String getWifiStatus() {
		return wifiStatus;
	}
	public void setWifiStatus(String wifiStatus) {
		this.wifiStatus = wifiStatus;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
    
    

}
