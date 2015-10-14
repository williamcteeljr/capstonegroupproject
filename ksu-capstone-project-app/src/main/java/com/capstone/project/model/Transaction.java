package com.capstone.project.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaction implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer _txnId;
	private String _txnDescription;
	private LocalDate _txnDate;
	private Integer _registeredUserId;
	
	public Transaction(Integer txnId, String txnDescription, LocalDate txnDate, Integer registeredUserId) {
		super();
		_txnId = txnId;
		_txnDescription = txnDescription;
		_txnDate = txnDate;
		_registeredUserId = registeredUserId;
	}

	public Integer getTxnId() {
		return _txnId;
	}

	public void setTxnId(Integer txnId) {
		_txnId = txnId;
	}

	public String getTxnDescription() {
		return _txnDescription;
	}

	public void setTxnDescription(String txnDescription) {
		_txnDescription = txnDescription;
	}

	public LocalDate getTxnDate() {
		return _txnDate;
	}

	public void setTxnDate(LocalDate txnDate) {
		_txnDate = txnDate;
	}

	public Integer getRegisteredUserId() {
		return _registeredUserId;
	}

	public void setRegisteredUserId(Integer registeredUserId) {
		_registeredUserId = registeredUserId;
	}

	@Override
	public String toString() {
		return "Transaction [_txnId=" + _txnId + ", _txnDescription=" + _txnDescription + ", _txnDate=" + _txnDate
				+ ", _registeredUserId=" + _registeredUserId + "]";
	}
	
	
}
