package com.capstone.project.user.validate;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;

import com.capstone.project.dao.UserDao;
import com.capstone.project.dao.UserDaoImpl;
import com.capstone.project.user.ServiceStatus;
import com.capstone.project.user.User;

@Service
public class UserValidation {

	private UserDao userDao;

	@POST
	@Path("/userauth")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public ServiceStatus validateUser(User user) {
		ServiceStatus s = new ServiceStatus();
		s.setMessageStatus("Fail");
		if (user != null) {
			if (user.getUserName().equalsIgnoreCase("admin")
					&& user.getPassWord().equalsIgnoreCase("admin")) {

				s.setMessageStatus("Success");

				List<User> userList = userDao.getUserList();
				System.out.println(userList);

				return s;
			}
		}

		return s;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/*
	 * @GET
	 * 
	 * @Path("/userServ")
	 * 
	 * public Response validatGetUser(@QueryParam(value="userName") String
	 * userName,
	 * 
	 * @QueryParam(value="passWord") String passWord ) { //ServiceStatus s = new
	 * ServiceStatus(); //s.setMessageStatus("Fail"); if
	 * (userName.equalsIgnoreCase("admin") &&
	 * passWord.equalsIgnoreCase("admin")) { //s.setMessageStatus("Success");
	 * return Response.ok().build(); } return Response.status(450).build(); }
	 */

	@POST
	@Path("/register")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public ServiceStatus registerUser(User user) {
		ServiceStatus s = new ServiceStatus();
		s.setMessageStatus("Fail");
		if (user != null) {

			s.setMessageStatus("Success");
			userDao.registerUser(user);
			return s;

		}

		return s;
	}

}