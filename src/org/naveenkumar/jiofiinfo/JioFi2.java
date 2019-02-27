package org.naveenkumar.jiofiinfo;

import java.util.regex.Pattern;

import org.naveenkumar.jiofiinfo.bean.DeviceDetails;
import org.naveenkumar.jiofiinfo.bean.LanDetails;
import org.naveenkumar.jiofiinfo.bean.LteDetails;
import org.naveenkumar.jiofiinfo.bean.WanDetails;
import org.naveenkumar.jiofiinfo.util.NetworkUtil;
import org.w3c.dom.Document;

public class JioFi2 implements Jiofi {

	@Override
	public LanDetails getLanDetails() {
		LanDetails lan = new LanDetails();
		   try {
			    String[] wirelessSecMode = { "Disabled", "WEP", "WPA-PSK", "WPA2-PSK", "WPA-PSK/WPA2-PSK" };
			    String[] wpaEnc = { "", "TKIP", "AES", "AES+TKIP" };
	            Document lanDoc = NetworkUtil.getDocumentFromUrl("http://jiofi.local.html/st_lan.w.xml");
	            lanDoc.getDocumentElement().normalize();
	            lan.setSsid(lanDoc.getElementsByTagName("ssid").item(0).getTextContent());
	            if (1 == Integer.parseInt(lanDoc.getElementsByTagName("dhcp").item(0).getTextContent())) {
	            	lan.setLanOperatingMode("DHCP");
	            }else {
	            	lan.setLanOperatingMode("Static");
	            }
	            lan.setSubnetMask(lanDoc.getElementsByTagName("submask").item(0).getTextContent());
	            lan.setGatewayIp(lanDoc.getElementsByTagName("gate").item(0).getTextContent());
	            lan.setMacAddress(lanDoc.getElementsByTagName("macaddr").item(0).getTextContent());
	            lan.setNoOfUsers(lanDoc.getElementsByTagName("user_cnt").item(0).getTextContent());
	            lan.setWifiChannel(lanDoc.getElementsByTagName("channel").item(0).getTextContent());
	            lan.setLanBandwidth(lanDoc.getElementsByTagName("band_width").item(0).getTextContent() + "Hz");
	            String[] encInfo = lanDoc.getElementsByTagName("enc_type").item(0).getTextContent().split(Pattern.quote(","));
	            lan.setWirelessSecurityMode(wirelessSecMode[Integer.parseInt(encInfo[0])]);
	            lan.setWirelessEncType(wpaEnc[Integer.parseInt(encInfo[1])]);

	            if (0 == Integer.parseInt(lanDoc.getElementsByTagName("ch").item(0).getTextContent())) {
	            	lan.setChannelSelection("Auto");
	            }else {
	            	lan.setChannelSelection("Manual");
	            }
	            
	            if (1 == Integer.parseInt(lanDoc.getElementsByTagName("wifi").item(0).getTextContent())) {
	            	lan.setWifiStatus("Enabled");
	            }else {
	            	lan.setWifiStatus("Disabled");
	            }
	            // TODO connected users list
	        } catch (Exception err) {
	            // err.getLineNumber() + ", uri " + err.getSystemId());
	            err.printStackTrace();
	        }
		   return lan;
	}

	@Override
	public LteDetails getLteDetails() {
		LteDetails lte = new LteDetails();
		try {
			String[] connStatus = { "Unknown", "Attached", "Detached", "No SIM", "Invalid SIM", "PIN Lock", "PIN Block",
					"PUK Block" };
			Document lteDoc = NetworkUtil.getDocumentFromUrl("http://jiofi.local.html/st_lte.w.xml");
			lteDoc.getDocumentElement().normalize();
			lte.setCspn(lteDoc.getElementsByTagName("cspn").item(0).getTextContent());
			lte.setPin(lteDoc.getElementsByTagName("pin").item(0).getTextContent());
			lte.setPinCount(lteDoc.getElementsByTagName("pin_cnt").item(0).getTextContent());
			lte.setPuk(lteDoc.getElementsByTagName("puk").item(0).getTextContent());
			lte.setStatus(connStatus[Integer.parseInt(lteDoc.getElementsByTagName("attach").item(0).getTextContent())]);
			// obj.put("hplmn",doc.getElementsByTagName("hplmn").item(0).getTextContent());
			// obj.put("update",doc.getElementsByTagName("update").item(0).getTextContent());
			lte.setConnectionTime(lteDoc.getElementsByTagName("time").item(0).getTextContent());
			lte.setApn(lteDoc.getElementsByTagName("apn").item(0).getTextContent());
			String[] freq_info = lteDoc.getElementsByTagName("freq_info").item(0).getTextContent()
					.split(Pattern.quote(","));
			lte.setOperatingMode(freq_info[7]);
			lte.setOperationBand("Band" + freq_info[6]);
			lte.setLteBandwidth(freq_info[4]);
			lte.setEarfcn(freq_info[5]);
			String[] cell_info = lteDoc.getElementsByTagName("cell_info").item(0).getTextContent()
					.split(Pattern.quote(","));
			lte.setActiveCellId(cell_info[2]);
			lte.setPlmn(cell_info[0]);
			lte.setGlobalPhysicalCellId(cell_info[1]);
			lte.setEcgi(cell_info[3]);
			String[] rssi_info = lteDoc.getElementsByTagName("rssi_info").item(0).getTextContent()
					.split(Pattern.quote(","));
			lte.setRsrp(rssi_info[0]);
			lte.setRsrq(rssi_info[1]);
			lte.setSinr(rssi_info[2]);
		} catch (Exception err) {
			err.printStackTrace();
		}
		return lte;
	}

	@Override
	public WanDetails getWanDetails() {
		WanDetails wan = new WanDetails();
		 try {
	            Document wanDoc = NetworkUtil.getDocumentFromUrl("http://jiofi.local.html/st_wan.w.xml");
	            wanDoc.getDocumentElement().normalize();
	            wan.setTotalDownloaded(wanDoc.getElementsByTagName("t_rx").item(0).getTextContent());
	            wan.setTotalUploaded(wanDoc.getElementsByTagName("t_tx").item(0).getTextContent());
	            wan.setHost(wanDoc.getElementsByTagName("host").item(0).getTextContent());
	            wan.setWanIpv4( wanDoc.getElementsByTagName("wan_ip").item(0).getTextContent());
	            wan.setWanIpv6(wanDoc.getElementsByTagName("wan_ipv6").item(0).getTextContent());
	            wan.setWanPrimaryDnsv4(wanDoc.getElementsByTagName("pri_dns").item(0).getTextContent());
	            wan.setWanPrimaryDnsv6(wanDoc.getElementsByTagName("ipv6_pri_dns").item(0).getTextContent());
	            wan.setWanOpMode(wanDoc.getElementsByTagName("wan_op_mode").item(0).getTextContent());
	            wan.setWanConnMode(wanDoc.getElementsByTagName("wan_conn_mode").item(0).getTextContent());

	        } catch (Exception err) {
	            err.printStackTrace();
	        }
		 return wan;
	}

	@Override
	public DeviceDetails getDeviceDetails() {
		DeviceDetails deviceDetails = new DeviceDetails();
		 try {
	            Document deviceDoc =  NetworkUtil.getDocumentFromUrl("http://jiofi.local.html/st_dev.w.xml");
	            deviceDoc.getDocumentElement().normalize();
	            deviceDetails.setTime(deviceDoc.getElementsByTagName("time").item(0).getTextContent());
	            deviceDetails.setSerialNumber(deviceDoc.getElementsByTagName("serial").item(0).getTextContent());
	            deviceDetails.setImei(deviceDoc.getElementsByTagName("imei").item(0).getTextContent());
	            deviceDetails.setImsi(deviceDoc.getElementsByTagName("imsi").item(0).getTextContent());
	            deviceDetails.setMacAddress(deviceDoc.getElementsByTagName("macaddr").item(0).getTextContent());
	            deviceDetails.setBatteryPercentage(deviceDoc.getElementsByTagName("batt_per").item(0).getTextContent()+"%");
	            int hi=Integer.parseInt(deviceDoc.getElementsByTagName("batt_st").item(0).getTextContent())>>>8;
	            if(hi < 4) {
	            	deviceDetails.setBatteryStatus("Discharging");
	            } else if(hi == 4) {
	            	deviceDetails.setBatteryStatus("Charging");
	            } else if (hi == 5) {
	            	deviceDetails.setBatteryStatus("Full Charged");
	            }
	            //odm,model,oui
	            
	            Document sysDoc = NetworkUtil.getDocumentFromUrl("http://jiofi.local.html/st_per.w.xml");
	            sysDoc.getDocumentElement().normalize();
	            deviceDetails.setCurrentUploadSpeed(sysDoc.getElementsByTagName("curr_tx").item(0).getTextContent());
	            deviceDetails.setCurrentDownloadSpeed(sysDoc.getElementsByTagName("curr_rx").item(0).getTextContent());
	            deviceDetails.setMaxUploadSpeed(sysDoc.getElementsByTagName("max_tx").item(0).getTextContent());
	            deviceDetails.setMaxDownloadSpeed(sysDoc.getElementsByTagName("max_tx").item(0).getTextContent());
	        }catch (Exception err) {
	           err.printStackTrace();
	        }
		 return deviceDetails;
	}

}
