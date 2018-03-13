package com.ofs.Model;

import java.io.Serializable;
import java.util.List;

public class HostGroupJerseyModel   {
	
	
	 /**
	 * 
	 */
//	 private static final long serialVersionUID = 1L;
	 int id;
	 int parentid;
	 String name;
	 boolean hostbaseline;
	 boolean suppress_excluded_service;
	 boolean inverse_suppression;
	 boolean host_trap;
	 boolean send_to_cta;
	 String description;
	 List<HostGroupJerseyModel> children;
	
	public List<HostGroupJerseyModel> getChildren() {
		return children;
	}
	public void setChildren(List<HostGroupJerseyModel> children) {
		this.children = children;
	}
	/*String[] ip_address_range;*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isHostbaseline() {
		return hostbaseline;
	}
	public void setHostbaseline(boolean host_baseline) {
		this.hostbaseline = host_baseline;
	}
	public boolean isSuppress_excluded_service() {
		return suppress_excluded_service;
	}
	public void setSuppress_excluded_service(boolean suppress_excluded_service) {
		this.suppress_excluded_service = suppress_excluded_service;
	}
	public boolean isInverse_suppression() {
		return inverse_suppression;
	}
	public void setInverse_suppression(boolean inverse_suppression) {
		this.inverse_suppression = inverse_suppression;
	}
	public boolean isHost_trap() {
		return host_trap;
	}
	public void setHost_trap(boolean host_trap) {
		this.host_trap = host_trap;
	}
	public boolean isSend_to_cta() {
		return send_to_cta;
	}
	public void setSend_to_cta(boolean send_to_cta) {
		this.send_to_cta = send_to_cta;
	}
	 public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		/*public String[] getIp_address_range() {
			return ip_address_range;
		}
		public void setIp_address_range(String[] ip_address_range) {
			this.ip_address_range = ip_address_range;
		}
*/
}
