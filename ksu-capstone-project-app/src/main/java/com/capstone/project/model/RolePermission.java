package com.capstone.project.model;

import java.io.Serializable;

public class RolePermission implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer _rolePermissionId;
	private String _application;
	private Boolean _permissionSetting;
	
	public RolePermission(Integer rolePermissionId, String application, Boolean permissionSetting) {
		super();
		_rolePermissionId = rolePermissionId;
		_application = application;
		_permissionSetting = permissionSetting;
	}

	public Integer getRolePermissionId() {
		return _rolePermissionId;
	}

	public void setRolePermissionId(Integer rolePermissionId) {
		_rolePermissionId = rolePermissionId;
	}

	public String getApplication() {
		return _application;
	}

	public void setApplication(String application) {
		_application = application;
	}

	public Boolean getPermissionSetting() {
		return _permissionSetting;
	}

	public void setPermissionSetting(Boolean permissionSetting) {
		_permissionSetting = permissionSetting;
	}

	@Override
	public String toString() {
		return "RolePermission [_rolePermissionId=" + _rolePermissionId + ", _application=" + _application
				+ ", _permissionSetting=" + _permissionSetting + "]";
	}
	
	
}
