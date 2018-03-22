package com.ofs.dao;

import java.util.List;

import javax.ws.rs.core.Response;

import com.ofs.Model.HostGroupJerseyModel;

public interface HostGroupJerseyDao {
	
	int addHost(HostGroupJerseyModel hostmodel);
	List<HostGroupJerseyModel> getHostGroupRecords();

	Response updateHostGroup(HostGroupJerseyModel hostmodel);
	Response deleteHostGroup(int id);
	List<HostGroupJerseyModel> addMultipleHost(List<HostGroupJerseyModel> host);
	Response updateMultiHost(List<HostGroupJerseyModel> host);
	HostGroupJerseyModel getRecordById(int id);

}
