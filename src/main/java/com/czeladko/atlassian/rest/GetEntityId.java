package com.czeladko.atlassian.rest;

import com.atlassian.annotations.PublicApi;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugins.rest.common.security.AnonymousAllowed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A resource of entityid.
 */
@XmlRootElement(name="entityid")
@Scanned
@AnonymousAllowed
@PublicApi
@Path("/entityid")
public class GetEntityId {

	/**
	 * podaj klucz z url , nie wazne czy to dla projektu np PRO
	 * czy dla planu np PRO-PLAN
	 * czy dla joba np PRO-PLAN-JOB
	 * 
	 * @param key the KEY if Build Project,Build Plan or Build Job 
     * @return entityId in database
	 */
    @GET
    @Path("/{key}")
    @AnonymousAllowed
    @PublicApi
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getEntityIdinDB(@PathParam("key") String key)
    {
    	GetEntityIdModel geid = new GetEntityIdModel(key);
    	geid.findEntityId();
    	return Response.ok(geid).build();
    }
    
    
}