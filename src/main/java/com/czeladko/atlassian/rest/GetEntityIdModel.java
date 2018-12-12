package com.czeladko.atlassian.rest;

import java.lang.reflect.Array;

import javax.xml.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atlassian.annotations.PublicApi;
import com.atlassian.bamboo.plan.Plan;
import com.atlassian.bamboo.plan.PlanManager;
import com.atlassian.bamboo.project.Project;
import com.atlassian.bamboo.project.ProjectManager;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;

@XmlRootElement(name = "getid")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
@Scanned
@PublicApi
public class GetEntityIdModel {
	
	@Autowired
	private static ProjectManager projectManager;
	
	@Autowired
	private static PlanManager planManager; 

	@XmlElement(name = "key")
	private String klucz;
	
	@XmlElement(name = "entityid")
	private Long entityId;

	@Autowired
	public GetEntityIdModel(@ComponentImport ProjectManager prom,@ComponentImport PlanManager planm) {
		this.projectManager=prom;
		this.planManager=planm;
	}
	
    public GetEntityIdModel(String key) {
    	this.klucz=key;
	}

	public GetEntityIdModel() {
	}

	public Long getEntityId() {
		return entityId;
	}
   
    public String getKlucz() {
		return klucz;
	}

	public void setKlucz(String klucz) {
		this.klucz = klucz;
	}
 
	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public void findEntityId() {
		String[] klucze=klucz.split("-");
		int dlugosc = Array.getLength(klucze);
		switch (dlugosc) {
			case 1: 
				Project proj = projectManager.getProjectByKey(this.klucz);
		    	if(proj==null)
		    		this.setEntityId(-1L);
		    	else
		    		this.setEntityId(proj.getId()) ;   
				break;
			case 2: case 3: 
				Plan pm = planManager.getPlanByKey(klucz);
				if(pm==null) 
					this.setEntityId(-1L);
		    	else
		    		this.setEntityId(pm.getId());
				break;
			default : 
				this.setEntityId(-1L);
				break;
		}	
	}

}