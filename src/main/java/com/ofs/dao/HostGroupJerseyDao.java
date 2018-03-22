package com.ofs.dao;

import java.util.List;

import com.ofs.Model.HostGroupJerseyModel;

public interface HostGroupJerseyDao {
	
	public int getHost(HostGroupJerseyModel hostmodel);
	public List<HostGroupJerseyModel> getHostGroupRecords();
	public List<HostGroupJerseyModel> getHostGroupTree();
	public boolean updateHostGroup(int id, HostGroupJerseyModel hostmodel);
	public boolean deleteHostGroup(int id);
	public List<HostGroupJerseyModel> addMultipleHost(List<HostGroupJerseyModel> host);
	public boolean updateMultiHost(List<HostGroupJerseyModel> host);

}
