package com.capstone.project.webservice.rest;

import com.capstone.project.dto.UserDTO;
import com.capstone.project.service.UserService;

import java.util.List;

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

/**
 * Web service for retrieving, adding, and changing user data.
 */
@Path("/userservice")
public class UserWebservice {
	
	@Resource
	private UserService userService;

	public void setUserService(UserService userService) {
		userService = userService;
	}

	
}
