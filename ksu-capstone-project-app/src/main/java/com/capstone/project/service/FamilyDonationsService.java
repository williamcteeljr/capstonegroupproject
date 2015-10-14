package com.capstone.project.service;

import java.util.List;
import com.capstone.project.dto.FamilyDTO;
import com.capstone.project.dto.UserDTO;

public interface FamilyDonationsService {

	//Family
	//List<FamilyDTO> getFamiliesList();
	// FamilyDTO getFamilyByFamilyId(Integer familyId);
	// FamilyDTO getFamilyByFamilyName(String familyName);
	// List<FamilyMemberDTO>getFamilyMembersByFamilyId(Integer familyId);
	// createFamily()
	// saveFamilyChanges()
	// deleteFamily() //ADMIN only
	
	//User
	//UserDTO getRegisteredUserByLogonIdAndPassword(String loginUserId, String password);
	// getUserRoleByUserId()
	// getUserPermissionsByUserRoleId()
	// insertRegisteredUser()
	
	//WishList
	// getWishListsByFamilyId()
	// getWishListItemsByWishListId()
	// getPublishedWishListsByFamilyId()
	// getNonPublishedWishListsByFamilyId()
	// insertWishList()
	// insertWishListItem()
	// deleteWishList()
	// deleteWishListItem()
	// publishWishList(Integer wishListId)  //UPDATE
	
	//Transaction History
	// getTransactionHistoryByUserId()
	// getTransactionHistoryByUserLoginId()
	// insertTransaction()
	// deleteTransaction()  NOTE: will need a property to define length of time to wait for delete (ie, purge action)
	
	//Contact Us
	// getMessagesFromMessageQueue() //ORDER BY CreatedDate DESC
	// insertMessage()
	// markMessageRead() //UPDATE
}
