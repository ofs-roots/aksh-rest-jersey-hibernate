package com.ofs.service;

import java.util.List;

import com.ofs.Model.HostGroupJerseyModel;

public interface HostGroupJerseyService {
	
	public int getHost(HostGroupJerseyModel hostmodel);
	public List<HostGroupJerseyModel> getHostGroupRecords();
	public List<HostGroupJerseyModel> getHostGroupTree();
	public HostGroupJerseyModel updateHostGroup(int id, HostGroupJerseyModel hostmodel);
	public String deleteHostGroup(int id);

}
