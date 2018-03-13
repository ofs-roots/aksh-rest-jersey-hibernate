package com.ofs.controller;



import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ofs.Model.HostGroupJerseyModel;
import com.ofs.service.HostGroupJerseyService;
import com.ofs.service.HostGroupJerseyServiceImpl;;
@Path("/hostgroup")
public class HostGroupJerseyController {
	HostGroupJerseyModel  hostgroup = new HostGroupJerseyModel();
	 HostGroupJerseyService hostservice = new HostGroupJerseyServiceImpl();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public int getHostGroup(HostGroupJerseyModel hostmodel ) {
		System.out.println("******Host Group Id: " + hostmodel.getId());
		System.out.println("******Host Group Name: " + hostmodel.getName());
		return hostservice.getHost(hostmodel);
		
		
	}
	
	@GET
	@Path("/flatten")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HostGroupJerseyModel> getRecord(){
		return hostservice.getHostGroupRecords();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<HostGroupJerseyModel> getTreeStructure(){
		return hostservice.getHostGroupTree();
	}
	
	@PUT
	@Path("/{id}")
	public HostGroupJerseyModel update(@PathParam("id") int id, HostGroupJerseyModel hostmodel) {
		return hostservice.updateHostGroup(id,hostmodel);
	}
	
	@DELETE
	@Path("/delete/{id}")
	public String delete(@PathParam("id") int id) {
		return hostservice.deleteHostGroup(id);
	}

	
	@GET
	@Path("/getprint")
	
	public String getPrintStatement() {
		
		return "Welcome to Jersey";
	}
}
