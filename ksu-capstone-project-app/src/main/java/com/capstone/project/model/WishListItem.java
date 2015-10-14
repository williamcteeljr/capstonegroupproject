package com.capstone.project.model;

import java.io.Serializable;

public class WishListItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer _wishListItemId;
	private String _description;
	private Integer _currentStatusId;
	
	public WishListItem(Integer wishListItemId, String description, Integer currentStatusId) {
		super();
		_wishListItemId = wishListItemId;
		_description = description;
		_currentStatusId = currentStatusId;
	}

	public Integer getWishListItemId() {
		return _wishListItemId;
	}

	public void setWishListItemId(Integer wishListItemId) {
		_wishListItemId = wishListItemId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Integer getCurrentStatusId() {
		return _currentStatusId;
	}

	public void setCurrentStatusId(Integer currentStatusId) {
		_currentStatusId = currentStatusId;
	}

	@Override
	public String toString() {
		return "WishListItem [_wishListItemId=" + _wishListItemId + ", _description=" + _description
				+ ", _currentStatusId=" + _currentStatusId + "]";
	}
	
	
}
