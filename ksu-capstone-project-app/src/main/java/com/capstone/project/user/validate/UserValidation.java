package com.capstone.project.user.validate;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.capstone.project.user.ServiceStatus;
import com.capstone.project.user.User;

@Service
public class UserValidation {

	@POST
	@Path("/userauth")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	
	public ServiceStatus validateUser(User user) {
		ServiceStatus s = new ServiceStatus();
		
		s.setMessageStatus("Fail");
		if(user != null){
			
			if (user.getUserName().equalsIgnoreCase("admin")
					&& user.getPassWord().equalsIgnoreCase("admin")) {
				s.setMessageStatus("Success");
				return s;
			}
			
		}
		
		
		return s;
	}
	
	
	@GET
	@Path("/userServ")
	
	public Response validatGetUser(@QueryParam(value="userName")  String userName,
			@QueryParam(value="passWord") String passWord ) {
		//ServiceStatus s = new ServiceStatus();
		//s.setMessageStatus("Fail");
		if (userName.equalsIgnoreCase("admin")
				&& passWord.equalsIgnoreCase("admin")) {
			//s.setMessageStatus("Success");
			return Response.ok().build();
		}
		return Response.status(450).build();
	}

}