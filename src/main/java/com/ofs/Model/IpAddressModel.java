package com.ofs.Model;

import java.io.Serializable;


public class IpAddressModel implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int ipId;
	String ipAddresses;
	String ipLocation;
	String ipDescription;
	public String getIpLocation() {
		return ipLocation;
	}

	public void setIpLocation(String ipLocation) {
		this.ipLocation = ipLocation;
	}

	public String getIpDescription() {
		return ipDescription;
	}

	public void setIpDescription(String ipDescription) {
		this.ipDescription = ipDescription;
	}

	//	HostGroupJerseyModel hostgroup;
	IpAddressModel(){}
	
	IpAddressModel(String stringJSON){
		
	}
	
	public String getIpAddresses() {
		return ipAddresses;
	}
	public void setIpAddresses(String ipAddresses) {
		this.ipAddresses = ipAddresses;
	}
	public int getIpId() {
		return ipId;
	}
	public void setIpId(int ipId) {
		this.ipId = ipId;
	}
	
	

}
