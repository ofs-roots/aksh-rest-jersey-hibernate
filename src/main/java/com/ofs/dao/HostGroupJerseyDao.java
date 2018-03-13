package com.ofs.dao;

import java.util.List;

import com.ofs.Model.HostGroupJerseyModel;

public interface HostGroupJerseyDao {
	
	public int getHost(HostGroupJerseyModel hostmodel);
	public List<HostGroupJerseyModel> getHostGroupRecords();
	public List<HostGroupJerseyModel> getHostGroupTree();
	public HostGroupJerseyModel updateHostGroup(int id, HostGroupJerseyModel hostmodel);
	public String deleteHostGroup(int id);

}
