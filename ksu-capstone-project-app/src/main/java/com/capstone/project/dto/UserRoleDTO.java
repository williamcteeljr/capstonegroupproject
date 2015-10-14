package com.capstone.project.dto;

import java.io.Serializable;
import java.util.List;

import com.capstone.project.model.RolePermission;

public class UserRoleDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer _userRoleId;
	private String _role;
	private List<RolePermission> _rolePermissions;
	
	public UserRoleDTO(Integer userRoleId, String role, List<RolePermission> rolePermissions) {
		super();
		_userRoleId = userRoleId;
		_role = role;
		_rolePermissions = rolePermissions;
	}

	public Integer getUserRoleId() {
		return _userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		_userRoleId = userRoleId;
	}

	public String getRole() {
		return _role;
	}

	public void setRole(String role) {
		_role = role;
	}

	public List<RolePermission> getRolePermissions() {
		return _rolePermissions;
	}

	public void setRolePermissions(List<RolePermission> rolePermissions) {
		_rolePermissions = rolePermissions;
	}

	@Override
	public String toString() {
		return "UserRole [_userRoleId=" + _userRoleId + ", _role=" + _role + ", _rolePermissions=" + _rolePermissions
				+ "]";
	}
	
	
}
