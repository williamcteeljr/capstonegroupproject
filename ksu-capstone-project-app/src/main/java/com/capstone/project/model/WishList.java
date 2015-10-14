package com.capstone.project.model;

import java.io.Serializable;
import java.util.List;

public class WishList implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer _wishListId;
	private String _description;
	private Boolean _publishedInd;
	private String _wishListStatus;
	private List<WishListItem> _wishListItems;
	
	public WishList(Integer wishListId, String description, Boolean publishedInd, String wishListStatus, List<WishListItem> wishListItems) {
		super();
		_wishListId = wishListId;
		_description = description;
		_publishedInd = publishedInd;
		_wishListStatus = wishListStatus;
		_wishListItems = wishListItems;
	}

	public Integer getWishListId() {
		return _wishListId;
	}

	public void setWishListId(Integer wishListId) {
		_wishListId = wishListId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Boolean getPublishedInd() {
		return _publishedInd;
	}

	public void setPublishedInd(Boolean publishedInd) {
		_publishedInd = publishedInd;
	}

	public String getWishListStatus() {
		return _wishListStatus;
	}

	public void setWishListStatus(String wishListStatus) {
		_wishListStatus = wishListStatus;
	}

	public List<WishListItem> getWishListItems() {
		return _wishListItems;
	}

	public void setWishListItems(List<WishListItem> wishListItems) {
		_wishListItems = wishListItems;
	}

	@Override
	public String toString() {
		return "WishList [_wishListId=" + _wishListId + ", _description=" + _description + ", _publishedInd="
				+ _publishedInd + ", _wishListStatus=" + _wishListStatus + ", _wishListItems=" + _wishListItems + "]";
	}

}
