package domain;

import java.util.List;

public class QueryVo {
	private String username;
	private String address;
	
	
	public void setName(String name)
	{
		this.username = name;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getname()
	{
		return this.username;
	}
	public String getaddress()
	{
		return this.address;
	}
	

}
