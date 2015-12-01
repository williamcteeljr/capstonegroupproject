package com.capstone.project.user.validate;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;

import com.capstone.project.admin.AdminDao;
import com.capstone.project.admin.AdminRequest;
import com.capstone.project.admin.AdminResponse;
import com.capstone.project.admin.status.AdminStatusDao;
import com.capstone.project.admin.status.AdminStatusRequest;
import com.capstone.project.admin.status.AdminStatusResponse;
import com.capstone.project.dao.LoginResponse;
import com.capstone.project.dao.UserDao;
import com.capstone.project.donar.DonarDTO;
import com.capstone.project.donar.DonarDao;
import com.capstone.project.donar.transaction.DonarTransactionDao;
import com.capstone.project.donar.transaction.DonarTransactionRequest;
import com.capstone.project.donar.transaction.DonarTransactionResponse;
import com.capstone.project.donation.DonationDao;
import com.capstone.project.donation.DonationFamilyResponse;
import com.capstone.project.donation.wish.DonationWish;
import com.capstone.project.donation.wish.DonationWishDao;
import com.capstone.project.donation.wish.DonationWishRequest;
import com.capstone.project.donation.wish.DonationWishResponse;
import com.capstone.project.donation.wish.submit.WishSubmitDao;
import com.capstone.project.donation.wish.submit.WishSubmitRequest;
import com.capstone.project.donation.wish.submit.WishSubmitResponse;
import com.capstone.project.family.FamilyDTO;
import com.capstone.project.family.FamilyDTOUI;
import com.capstone.project.family.FamilyDao;
import com.capstone.project.family.transaction.FamilyTransactionDao;
import com.capstone.project.family.transaction.FamilyTransactionRequest;
import com.capstone.project.family.transaction.FamilyTransactionResponse;
import com.capstone.project.user.ServiceStatus;
import com.capstone.project.user.User;

@Service
public class UserValidation {

	private UserDao userDao;
	private DonarDao donarDao;
	private FamilyDao familyDao;
	private AdminDao adminDao;
	private AdminStatusDao adminStatusDao;
	private DonationDao donationDao;
	private DonationWishDao donationWishDao;
	private WishSubmitDao wishSubmitDao;
	private FamilyTransactionDao familyTransactionDao;
	private DonarTransactionDao donarTransactionDao;

	@POST
	@Path("/userauth")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public ServiceStatus validateUser(User user) {
		ServiceStatus s = new ServiceStatus();
		s.setMessageStatus("Fail");
		if (user != null) {
			if (user.getUsername().equalsIgnoreCase("admin")
					&& user.getPassword().equalsIgnoreCase("admin")) {

				s.setMessageStatus("Success");

				List<User> userList = userDao.getUserList();
				System.out.println(userList);

				return s;
			}
		}

		return s;
	}
	
	
	
	@POST
	@Path("/userauth/validate")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public LoginResponse doValidateUser(User user) {
		
		LoginResponse r = new LoginResponse();
		r.setStatus("fail");
		if (user != null) {
			List<User> userList = userDao.getUserList();
			
			for (User u : userList) {
				if (u.getUsername().equalsIgnoreCase(user.getUsername())
						&& u.getPassword().equalsIgnoreCase(user.getPassword())) {
					r.setStatus("Success");
					r.setUsername(u.getUsername());
					r.setRole(u.getRole());
					break;
				}
			}
		}

		return r;
	}
	
	
	
	
	
	
	@POST
	@Path("/transaction/family")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public FamilyTransactionResponse getFamilyTransaction(
			FamilyTransactionRequest request) {
		FamilyTransactionResponse r = new FamilyTransactionResponse();
		r.setMessage("Fail");
		if (request != null) {
			r = familyTransactionDao.finalSubmitDonation(request.getFamilyId());
		}
		return r;
	}
	
	
	
	@POST
	@Path("/transaction/donar")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public DonarTransactionResponse getTransactions(
			DonarTransactionRequest request) {
		DonarTransactionResponse r = new DonarTransactionResponse();
		r.setMessage("Fail");
		if (request != null) {
			r = donarTransactionDao.finalSubmitTransactionRequest(request.getUserId());
		}
		return r;
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

	@POST
	@Path("/register/donar")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public ServiceStatus registerDonar(DonarDTO d) {
		ServiceStatus s = new ServiceStatus();
		s.setMessageStatus("Fail");
		if (d != null) {

			s.setMessageStatus("Success");
			User u = new User();
			u.setUsername(d.getUsername());
			u.setPassword(d.getPassword());
			u.setRole(d.getRole());
			userDao.registerUser(u);
			donarDao.registerDonar(d);
			return s;
		}

		return s;
	}

	@POST
	@Path("/register/family")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public ServiceStatus registerFamily(FamilyDTOUI d) {
		ServiceStatus s = new ServiceStatus();
		s.setMessageStatus("Fail");
		if (d != null) {
			s.setMessageStatus("Success");
			User u = new User();
			u.setUsername(d.getUsername());
			u.setPassword(d.getPassword());
			u.setRole(d.getRole());
			userDao.registerUser(u);
			familyDao.registerFamily(d);
			return s;
		}
		return s;
	}

	@POST
	@Path("/admin/family")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public AdminResponse getFamily(AdminRequest d) {
		AdminResponse a = null;

		if (d != null) {

			a = adminDao.getAllFamilies();
		}
		return a;
	}

	@POST
	@Path("/admin/status")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public AdminStatusResponse setStatus(AdminStatusRequest d) {

		AdminStatusResponse a = null;
		if (d != null) {
			a = adminStatusDao.changeStatus(d);
		}
		return a;
	}

	@POST
	@Path("/donation/famalies")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public DonationFamilyResponse getfamilies(AdminRequest r) {
		DonationFamilyResponse a = null;
		if (r != null) {
			a = new DonationFamilyResponse();
			List<FamilyDTO> familyList = donationDao.getapprovedFamilies();
			;
			a.setFamilyList(familyList);
		}
		return a;
	}

	@POST
	@Path("/donation/wishlist")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public DonationWishResponse getchildWishList(DonationWishRequest r) {
		DonationWishResponse a = null;
		if (r != null) {
			a = new DonationWishResponse(); 
			List<DonationWish> wishes = donationWishDao.geallWish(r.getFamilyId());
			a.setWishes(wishes);
		}
		return a;
	}
	
	
	
	
	@POST
	@Path("/donation/final/submit")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public WishSubmitResponse doFinalSubmit(WishSubmitRequest r) {
		
		WishSubmitResponse a = null;
		
		if (r != null) {
		
			 a = wishSubmitDao.finalSubmitDonation(r);
			
		}
		return a;
	}
	

	public DonarDao getDonarDao() {
		return donarDao;
	}

	public void setDonarDao(DonarDao donarDao) {
		this.donarDao = donarDao;
	}

	public FamilyDao getFamilyDao() {
		return familyDao;
	}

	public void setFamilyDao(FamilyDao familyDao) {
		this.familyDao = familyDao;
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public AdminStatusDao getAdminStatusDao() {
		return adminStatusDao;
	}

	public void setAdminStatusDao(AdminStatusDao adminStatusDao) {
		this.adminStatusDao = adminStatusDao;
	}

	public DonationDao getDonationDao() {
		return donationDao;
	}

	public void setDonationDao(DonationDao donationDao) {
		this.donationDao = donationDao;
	}

	public DonationWishDao getDonationWishDao() {
		return donationWishDao;
	}

	public void setDonationWishDao(DonationWishDao donationWishDao) {
		this.donationWishDao = donationWishDao;
	}

	public WishSubmitDao getWishSubmitDao() {
		return wishSubmitDao;
	}

	public void setWishSubmitDao(WishSubmitDao wishSubmitDao) {
		this.wishSubmitDao = wishSubmitDao;
	}



	public FamilyTransactionDao getFamilyTransactionDao() {
		return familyTransactionDao;
	}



	public void setFamilyTransactionDao(FamilyTransactionDao familyTransactionDao) {
		this.familyTransactionDao = familyTransactionDao;
	}



	public DonarTransactionDao getDonarTransactionDao() {
		return donarTransactionDao;
	}



	public void setDonarTransactionDao(DonarTransactionDao donarTransactionDao) {
		this.donarTransactionDao = donarTransactionDao;
	}

}