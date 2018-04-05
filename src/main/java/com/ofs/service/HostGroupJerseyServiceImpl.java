package com.ofs.service;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.ofs.Model.DuplicateNameException;
import com.ofs.Model.HostGroupJerseyModel;
import com.ofs.Model.RootHost;
import com.ofs.dao.HostGroupJerseyDao;
import com.ofs.dao.HostGroupJerseyDaoImpl;

public class HostGroupJerseyServiceImpl implements HostGroupJerseyService {
	
	HostGroupJerseyDao hostdao = new HostGroupJerseyDaoImpl();

	public int addHost(HostGroupJerseyModel hostmodel) throws DuplicateNameException {
		HostGroupJerseyModel result = hostdao.getDuplicateRecord(hostmodel.getName());
		int id;

		if(result==null) {
			id = hostdao.addHost(hostmodel);
			}
		else 
			throw new DuplicateNameException("HostGroup Name already exixts");
		
		return id;
		}
	
	public HostGroupJerseyModel getRecordById(int id) {
		return hostdao.getRecordById(id);
	}

	public List<HostGroupJerseyModel> getHostGroupRecords() {
		return hostdao.getHostGroupRecords();
	}

	public List<HostGroupJerseyModel> getHostGroupTree() {
		List<HostGroupJerseyModel> hostlist = hostdao.getHostGroupRecords();
		List<HostGroupJerseyModel> treelist = getJsonTree(hostlist);
		return treelist;
	}

	public Response updateHostGroup(HostGroupJerseyModel hostmodel) {
		return hostdao.updateHostGroup(hostmodel);
	}
	
	public Response deleteHostGroup(int id) {
		return hostdao.deleteHostGroup(id);
	}

	public List<HostGroupJerseyModel> addMultipleHost(List<HostGroupJerseyModel> host) {
		return hostdao.addMultipleHost(host);
	}

	public Response updateMultiHost(List<HostGroupJerseyModel> host) {
		return hostdao.updateMultiHost(host);
	}
	
	@Override
	public void exportHostGroup() {
		List<HostGroupJerseyModel> hostlist = hostdao.getHostGroupRecords();
		List<HostGroupJerseyModel> treelist = getJsonTree(hostlist);
		DateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		  String timeStamp = format.format(new Date());
		String filename = "host_" + timeStamp + ".xml";
		File file = new File( "C:\\Users\\akshara.g\\Desktop\\xml file\\" +filename);
		try {
			JAXBContext jaxbcontext = JAXBContext.newInstance(RootHost.class);
			Marshaller marshelling = jaxbcontext.createMarshaller();
			marshelling.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshelling.marshal(new RootHost(treelist),file);
			marshelling.marshal(treelist,System.out);
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static List<HostGroupJerseyModel> getJsonTree(List<HostGroupJerseyModel> hostlist) {
		List<HostGroupJerseyModel> parent = new ArrayList();
		Map<Integer,List<HostGroupJerseyModel>> map = new HashMap<Integer,List<HostGroupJerseyModel>>();
		HostGroupJerseyModel hostparent = new HostGroupJerseyModel();
		List<HostGroupJerseyModel> child =  new ArrayList();
		for(HostGroupJerseyModel a : hostlist) {
			if(a.getParentid() ==0) {
				parent.add(a);
			} else {
				if(map.get(a.getParentid())==null) {
					List<HostGroupJerseyModel> children = new ArrayList();
					children.add(a);
					map.put(a.getParentid(), children);
				} else {
					map.get(a.getParentid()).add(a);
				}
			}
		}
		List<HostGroupJerseyModel> result =constructTree(parent,map);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.valueToTree(result);
		String str = null;
			try {
				str =mapper.writeValueAsString(root);
				System.out.println(str);
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return result;
	}
	
	private static List<HostGroupJerseyModel> constructTree(List<HostGroupJerseyModel> parent, Map<Integer, List<HostGroupJerseyModel>> map) {
		if (map!=null&&parent!=null) {
			for(HostGroupJerseyModel b : parent) {
				b.setChildren(map.get(b.getId()));
				map.remove(b.getId());
				constructTree(b.getChildren(),map);
					    }
				}
		return parent;
			}

	

}
