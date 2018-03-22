package com.ofs.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ofs.Model.HostGroupJerseyModel;
import com.ofs.util.HibernateUtil;

public class HostGroupJerseyDaoImpl implements HostGroupJerseyDao {
	

	public int addHost(HostGroupJerseyModel hostmodel) {
		
		int hostid = 0;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			 hostid = (Integer)session.save(hostmodel);
			transaction.commit();
			HibernateUtil.getSessionFactory().close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hostid;
	}
	
	public List<HostGroupJerseyModel> getHostGroupRecords(){
		
		List<HostGroupJerseyModel> hostlist = new ArrayList();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			Criteria cr = session.createCriteria(HostGroupJerseyModel.class);
			hostlist = cr.list();
			transaction.commit();
			HibernateUtil.getSessionFactory().close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hostlist;
		
	}
	
	
	public Response updateHostGroup(HostGroupJerseyModel hostmodel) {
		boolean success=false;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			session.update(hostmodel);
			success=true;
			transaction.commit();
			HibernateUtil.getSessionFactory().close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok().entity(String.valueOf(success)).build();
		
	}
	
	public Response deleteHostGroup(int id) {
		boolean success = false;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			HostGroupJerseyModel hostmodel = (HostGroupJerseyModel)session.get(HostGroupJerseyModel.class, id);
			session.delete(hostmodel);
			success = true;
			transaction.commit();
			HibernateUtil.getSessionFactory().close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok().entity(String.valueOf(success)).build();
		
	}
	
	@Override
	public List<HostGroupJerseyModel> addMultipleHost(List<HostGroupJerseyModel> host) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			for(HostGroupJerseyModel hostmodel: host) {
				 int hostid = (Integer)session.save(hostmodel);
				 transaction.commit();
			}
			HibernateUtil.getSessionFactory().close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return host;
	}
	
	@Override
	public Response updateMultiHost(List<HostGroupJerseyModel> host) {
		boolean success = false;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			for(HostGroupJerseyModel hostmodel: host) {
				session.update(hostmodel);
			}	
			success = true;
			transaction.commit();
			
			HibernateUtil.getSessionFactory().close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.ok().entity(String.valueOf(success)).build();
	}

	@Override
	public HostGroupJerseyModel getRecordById(int id) {
		HostGroupJerseyModel hostrecord = new HostGroupJerseyModel();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			Criteria cr = session.createCriteria(HostGroupJerseyModel.class);
			cr.add(Restrictions.eq("id",id));
			hostrecord = (HostGroupJerseyModel)cr.uniqueResult();
			transaction.commit();
			HibernateUtil.getSessionFactory().close();
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return hostrecord;
	}	
	
}
	
	


