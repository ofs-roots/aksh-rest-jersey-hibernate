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
import javax.ws.rs.core.Response;

import com.ofs.Model.DuplicateNameException;
import com.ofs.Model.HostGroupJerseyModel;
import com.ofs.service.HostGroupJerseyService;
import com.ofs.service.HostGroupJerseyServiceImpl;

@Path("/hostgroup")
public class HostGroupJerseyController {
	HostGroupJerseyModel  hostgroup = new HostGroupJerseyModel();
	HostGroupJerseyService hostservice = new HostGroupJerseyServiceImpl();
	 
	 @POST
	 @Path("/addMultiple")
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<HostGroupJerseyModel> addHostGroups(List<HostGroupJerseyModel> host){
		 return hostservice.addMultipleHost(host);
	 }
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public int addHostGroup(HostGroupJerseyModel hostmodel) throws DuplicateNameException {
		return hostservice.addHost(hostmodel);	
	}
	
	@GET
	@Path("/getById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public HostGroupJerseyModel getRecordById(@PathParam("id") int id) {
		return hostservice.getRecordById(id);
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
	public Response update(HostGroupJerseyModel hostmodel) {
		return hostservice.updateHostGroup(hostmodel);
	}
	
	@PUT
	@Path("/editMultipleHost")
	public Response updateMultipleHost(List<HostGroupJerseyModel> host) {
		return hostservice.updateMultiHost(host);
	}
	
	@DELETE
	@Path("/delete/{id}")
	public Response delete(@PathParam("id") int id) {
		return hostservice.deleteHostGroup(id);
	}
	
	@GET
	@Path("/export")
	public void export() {
		hostservice.exportHostGroup();
	}

}
