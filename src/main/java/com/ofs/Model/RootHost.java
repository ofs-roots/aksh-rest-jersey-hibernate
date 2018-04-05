package com.ofs.Model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;


@XmlRootElement(name = "root")
@XmlAccessorType (XmlAccessType.FIELD)
public class RootHost {
	@XmlElement(name="hostgroup")
	private List<HostGroupJerseyModel> treelist = new ArrayList<HostGroupJerseyModel>();
	
	public RootHost() {}
	
	public RootHost(List<HostGroupJerseyModel> treelist) {
		this.treelist = treelist;
	}

	public List<HostGroupJerseyModel> getTreelist() {
		return treelist;
	}

	public void setTreelist(List<HostGroupJerseyModel> treelist) {
		this.treelist = treelist;
	}

}
