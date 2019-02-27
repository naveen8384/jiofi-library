package org.naveenkumar.jiofiinfo;

import org.naveenkumar.jiofiinfo.bean.DeviceDetails;
import org.naveenkumar.jiofiinfo.bean.LanDetails;
import org.naveenkumar.jiofiinfo.bean.LteDetails;
import org.naveenkumar.jiofiinfo.bean.WanDetails;

public interface Jiofi {
	public LanDetails getLanDetails();
	public LteDetails getLteDetails();
	public WanDetails getWanDetails();
	public DeviceDetails getDeviceDetails();
	
	
}
