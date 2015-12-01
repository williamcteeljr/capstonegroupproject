package com.capstone.project.family.transaction;

import java.util.List;

public class FamilyTransactionResponse {

	private String message;
	
	List<FamilyTransactionDTO> itemList;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<FamilyTransactionDTO> getItemList() {
		return itemList;
	}

	public void setItemList(List<FamilyTransactionDTO> itemList) {
		this.itemList = itemList;
	}

}
