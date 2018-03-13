package com.ofs.service;

import java.util.List;

import com.ofs.Model.HostGroupJerseyModel;
import com.ofs.dao.HostGroupJerseyDao;
import com.ofs.dao.HostGroupJerseyDaoImpl;

public class HostGroupJerseyServiceImpl implements HostGroupJerseyService {
	
	HostGroupJerseyDao hostdao = new HostGroupJerseyDaoImpl();

	public int getHost(HostGroupJerseyModel hostmodel) {
		
		// TODO Auto-generated method stub
		return hostdao.getHost(hostmodel);
	}

	public List<HostGroupJerseyModel> getHostGroupRecords() {
		return hostdao.getHostGroupRecords();
	}

	public List<HostGroupJerseyModel> getHostGroupTree() {
		// TODO Auto-generated method stub
		return hostdao.getHostGroupTree();
	}

	public HostGroupJerseyModel updateHostGroup(int id, HostGroupJerseyModel hostmodel) {
		
		return hostdao.updateHostGroup(id,hostmodel);
	}
	
	public String deleteHostGroup(int id) {
		
		return hostdao.deleteHostGroup(id);
	}
	

	

}
