package Jdbc;

import java.sql.Date;

public class User {
	private int id;
	private String username;
	private String sex;
	private String address;
	private Date birthday;

	public void setId(int int1) {
		// TODO Auto-generated method stub
		this.id = int1;
	}

	public void setUsername(String string) {
		// TODO Auto-generated method stub
		this.username=string;
	}

	public void setSex(String string) {
		// TODO Auto-generated method stub
		sex = string;
	}
	
	@Override
	public String toString() {
	    return "User{" +
	            "id=" + id +
	            ", username='" + username + '\'' +
	            ", sex='" + sex + '\'' +
	            ", address='" + address + '\'' +
	            ", birthday=" + birthday +
	            '}';
	}

	public void setAddress(String string) {
		// TODO Auto-generated method stub
		this.address = string;
	}

	public void setBirthday(Date date) {
		// TODO Auto-generated method stub
		this.birthday = date;
	}
	
	

}
