package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable{
	
	private Integer userId;
	private String userName;
	private Date userBirthday;
	private String userSex;
	private String userAddress;
	
	private List<Account> accounts;
	
	public Integer getId() {
	return userId;
	}
	public void setId(Integer id) {
	this.userId = id;
	}
	public void setUsername(String string) {
		// TODO Auto-generated method stub
		this.userName=string;
	}

	public void setSex(String string) {
		// TODO Auto-generated method stub
		this.userSex = string;
	}
	
	@Override
	public String toString() {
	    return "User{" +
	            "id=" + userId +
	            ", username='" + userName + '\'' +
	            ", sex='" + userSex + '\'' +
	            ", address='" + userAddress + '\'' +
	            ", birthday=" + userBirthday +
	            '}';
	}

	public void setAddress(String string) {
		// TODO Auto-generated method stub
		this.userAddress = string;
	}

	public void setBirthday(Date date) {
		// TODO Auto-generated method stub
		this.userBirthday = date;
	}
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userName;
	}
	public String getAddress() {
		// TODO Auto-generated method stub
		return this.userAddress;
	}
	public Date getBirthday() {
		// TODO Auto-generated method stub
		return this.userBirthday;
	}
	public String getSex() {
		// TODO Auto-generated method stub
		return this.userSex;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
	
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
}
