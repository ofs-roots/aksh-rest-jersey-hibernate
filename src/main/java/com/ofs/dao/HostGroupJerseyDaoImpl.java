package com.ofs.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.ofs.Model.HostGroupJerseyModel;
import com.ofs.util.HibernateUtil;

public class HostGroupJerseyDaoImpl implements HostGroupJerseyDao {
	

	public int getHost(HostGroupJerseyModel hostmodel) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		 int hostid = (Integer)session.save(hostmodel);
		 session.beginTransaction().commit();
		HibernateUtil.getSessionFactory().close();
		
		return hostid;
	}
	
	public List<HostGroupJerseyModel> getHostGroupRecords(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<HostGroupJerseyModel> hostlist = (List<HostGroupJerseyModel>)session.createQuery("from HostGroupJerseyModel").list();
		session.beginTransaction().commit();
		HibernateUtil.getSessionFactory().close();
		return hostlist;
		
	}
	
	public List<HostGroupJerseyModel> getHostGroupTree(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<HostGroupJerseyModel> hostlist = (List<HostGroupJerseyModel>)session.createQuery("from HostGroupJerseyModel").list();
		session.beginTransaction().commit();
		HibernateUtil.getSessionFactory().close();
		List<HostGroupJerseyModel> treelist = getJsonTree(hostlist);
		return treelist;
		
	}
	
	public boolean updateHostGroup(int id, HostGroupJerseyModel hostmodel) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query qry=session.createQuery("update HostGroupJerseyModel hostmodel set hostmodel.name='"+hostmodel.getName()+"',hostmodel.description='"+hostmodel.getDescription()+"',hostmodel.parentid='"+hostmodel.getParentid()+"',hostmodel.hostbaseline='"+hostmodel.isHostbaseline()+"',hostmodel.suppress_excluded_service='"+hostmodel.isSuppress_excluded_service()+"',hostmodel.host_trap='"+hostmodel.isHost_trap()+"',hostmodel.send_to_cta='"+hostmodel.isSend_to_cta()+"',hostmodel.inverse_suppression='"+hostmodel.isInverse_suppression()+"' where hostmodel.id="+id);
		int updated = qry.executeUpdate();
				
		session.beginTransaction().commit();
		HibernateUtil.getSessionFactory().close();
		return true;
		
	}
	
	public boolean deleteHostGroup(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.createQuery("delete from HostGroupJerseyModel hostmodel where hostmodel.id="+id).executeUpdate();
		session.beginTransaction().commit();
		HibernateUtil.getSessionFactory().close();
		return true;
		
	}
	
	@Override
	public List<HostGroupJerseyModel> addMultipleHost(List<HostGroupJerseyModel> host) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		for(HostGroupJerseyModel hostmodel: host) {
			 int hostid = (Integer)session.save(hostmodel);
			 session.beginTransaction().commit();
		}
		HibernateUtil.getSessionFactory().close();
		
		return host;
	}
	
	@Override
	public boolean updateMultiHost(List<HostGroupJerseyModel> host) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		for(HostGroupJerseyModel hostmodel: host) {

		Query qry=session.createQuery("update HostGroupJerseyModel hostmodel set hostmodel.name='"+hostmodel.getName()+"',hostmodel.description='"+hostmodel.getDescription()+"',hostmodel.parentid='"+hostmodel.getParentid()+"',hostmodel.hostbaseline='"+hostmodel.isHostbaseline()+"',hostmodel.suppress_excluded_service='"+hostmodel.isSuppress_excluded_service()+"',hostmodel.host_trap='"+hostmodel.isHost_trap()+"',hostmodel.send_to_cta='"+hostmodel.isSend_to_cta()+"',hostmodel.inverse_suppression='"+hostmodel.isInverse_suppression()+"' where hostmodel.id="+hostmodel.getId());
		int updated = qry.executeUpdate();
		session.beginTransaction().commit();
		}	
		
		HibernateUtil.getSessionFactory().close();
		return true;
		
	}
	
	
	
	public static List<HostGroupJerseyModel> getJsonTree(List<HostGroupJerseyModel> hostlist) {
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
//				for (Map.Entry<Integer,List<HostParent>> entry : map.entrySet()){
//					if(entry.getKey()==b.id){
//						b.setChildren(entry.getValue());
				b.setChildren(map.get(b.getId()));
				map.remove(b.getId());

				constructTree(b.getChildren(),map);
					    }
				}
		return parent;
			
				}

	

	
	
}
	
	


