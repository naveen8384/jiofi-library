package org.naveenkumar.jiofiinfo.bean;

import java.io.Serializable;

public class WanDetails implements Serializable{
	private static final long serialVersionUID = 1L;
	String totalDownloaded = "";
    String totalUploaded = "";
    String host = "";
    String wanIpv4 = "";
    String wanIpv6 = "";
    String wanPrimaryDnsv4 = "";
    String wanPrimaryDnsv6 = "";
    String wanOpMode = "";
    String wanConnMode = "";
	public String getTotalDownloaded() {
		return totalDownloaded;
	}
	public void setTotalDownloaded(String totalDownloaded) {
		this.totalDownloaded = totalDownloaded;
	}
	public String getTotalUploaded() {
		return totalUploaded;
	}
	public void setTotalUploaded(String totalUploaded) {
		this.totalUploaded = totalUploaded;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getWanIpv4() {
		return wanIpv4;
	}
	public void setWanIpv4(String wanIpv4) {
		this.wanIpv4 = wanIpv4;
	}
	public String getWanIpv6() {
		return wanIpv6;
	}
	public void setWanIpv6(String wanIpv6) {
		this.wanIpv6 = wanIpv6;
	}
	public String getWanPrimaryDnsv4() {
		return wanPrimaryDnsv4;
	}
	public void setWanPrimaryDnsv4(String wanPrimaryDnsv4) {
		this.wanPrimaryDnsv4 = wanPrimaryDnsv4;
	}
	public String getWanPrimaryDnsv6() {
		return wanPrimaryDnsv6;
	}
	public void setWanPrimaryDnsv6(String wanPrimaryDnsv6) {
		this.wanPrimaryDnsv6 = wanPrimaryDnsv6;
	}
	public String getWanOpMode() {
		return wanOpMode;
	}
	public void setWanOpMode(String wanOpMode) {
		this.wanOpMode = wanOpMode;
	}
	public String getWanConnMode() {
		return wanConnMode;
	}
	public void setWanConnMode(String wanConnMode) {
		this.wanConnMode = wanConnMode;
	}
    
    

}
