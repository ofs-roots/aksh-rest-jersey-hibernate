package com.ofs.Model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class HostGroupJerseyModel   {
	
	 private int id;
	 private int parentid;
	 private String name;
	 private boolean hostBaseline;
	 private boolean suppressExcludedService;
	 private boolean inverseSuppression;
	 private boolean hostTrap;
	 private boolean sendToCta;
	 private String description;
	 private List<HostGroupJerseyModel> children;
	 private List<IpAddressModel> ipAddress;
	 private Set<String> hostGroupUser;
	 public Set<String> getHostGroupUser() {
		return hostGroupUser;
	}

	public void setHostGroupUser(Set<String> hostGroupUser) {
		this.hostGroupUser = hostGroupUser;
	}

	public List<IpAddressModel> getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(List<IpAddressModel> ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	public HostGroupJerseyModel() {}
	 
	public HostGroupJerseyModel(int parentid, String name, boolean hostBaseline, boolean suppressExcludedService, boolean inverseSuppression,boolean hostTrap,boolean sendToCta, String description) {
		
		 this.parentid=parentid;
		 this.name=name;
		 this.hostBaseline=hostBaseline;
		 this.suppressExcludedService = suppressExcludedService;
		 this.inverseSuppression = inverseSuppression;
		 this.hostTrap = hostTrap;
		 this.sendToCta = sendToCta;
		 this.description = description;
	}
	 public HostGroupJerseyModel(int id,int parentid, String name, boolean hostBaseline, boolean suppressExcludedService, boolean inverseSuppression,boolean hostTrap,boolean sendToCta, String description) {
		 this.id = id;
		 this.parentid=parentid;
		 this.name=name;
		 this.hostBaseline=hostBaseline;
		 this.suppressExcludedService = suppressExcludedService;
		 this.inverseSuppression = inverseSuppression;
		 this.hostTrap = hostTrap;
		 this.sendToCta = sendToCta;
		 this.description = description;
	}
	
	public List<HostGroupJerseyModel> getChildren() {
		return children;
	}
	public void setChildren(List<HostGroupJerseyModel> children) {
		this.children = children;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isHostBaseline() {
		return hostBaseline;
	}
	public void setHostBaseline(boolean hostBaseline) {
		this.hostBaseline = hostBaseline;
	}
	public boolean isSuppressExcludedService() {
		return suppressExcludedService;
	}
	public void setSuppressExcludedService(boolean suppressExcludedService) {
		this.suppressExcludedService = suppressExcludedService;
	}
	public boolean isInverseSuppression() {
		return inverseSuppression;
	}
	public void setInverseSuppression(boolean inverseSuppression) {
		this.inverseSuppression = inverseSuppression;
	}
	public boolean isHostTrap() {
		return hostTrap;
	}
	public void setHostTrap(boolean hostTrap) {
		this.hostTrap = hostTrap;
	}
	public boolean isSendToCta() {
		return sendToCta;
	}
	public void setSendToCta(boolean sendToCta) {
		this.sendToCta = sendToCta;
	}
	public String getDescription() {
			return description;
		}
	public void setDescription(String description) {
			this.description = description;
		}
}
