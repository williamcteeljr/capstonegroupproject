package com.capstone.project.donar.transaction;

import java.util.List;

public class DonarTransactionResponse {

	private String message;
	
	List<TransactionDTO> itemList;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<TransactionDTO> getItemList() {
		return itemList;
	}

	public void setItemList(List<TransactionDTO> itemList) {
		this.itemList = itemList;
	}
}
