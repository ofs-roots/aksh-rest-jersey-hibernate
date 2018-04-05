package com.ofs.service;

import java.util.List;

import javax.ws.rs.core.Response;

import com.ofs.Model.DuplicateNameException;
import com.ofs.Model.HostGroupJerseyModel;



public interface HostGroupJerseyService {
	
	int addHost(HostGroupJerseyModel hostmodel) throws DuplicateNameException;
	List<HostGroupJerseyModel> getHostGroupRecords();
	List<HostGroupJerseyModel> getHostGroupTree();
	Response updateHostGroup(HostGroupJerseyModel hostmodel);
	Response deleteHostGroup(int id);
	List<HostGroupJerseyModel> addMultipleHost(List<HostGroupJerseyModel> host);
	Response updateMultiHost(List<HostGroupJerseyModel> host);
	HostGroupJerseyModel getRecordById(int id);
	void exportHostGroup();

}
