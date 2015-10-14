package com.capstone.project.webservice.rest;

import com.capstone.project.service.FamilyService;
import com.capstone.project.dto.FamilyDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Web service for retrieving, adding, and changing family data.
 */
@Path("/familydonations/familyservice")
public class FamilyWebservice {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FamilyWebservice.class);
	
	@Resource
	private FamilyService familyService;

	public void setFamilyService(FamilyService familyService) {
		familyService = familyService;
	}

	@GET
	@Path("/getfamilies")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FamilyDTO> getFamiliesList() {
	
		List<FamilyDTO> familyDtoList = new ArrayList<>();	
		try {
			familyDtoList = familyService.getFamiliesList();
			if (Objects.isNull(familyDtoList)) {
				LOGGER.error("[FamilyWebservice.getFamiliesList] familyService.getFamiliesList() "
						+"returned null. Returning an empty FamilyDTO list.");
				return familyDtoList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}				
		return familyDtoList;
	}	

}
