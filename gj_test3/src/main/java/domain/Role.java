package domain;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {
	private Integer roleId;
	private String roleName;
	private String roleDesc;
	private List<User> users;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return this.users;
	}

}
