package domain;

import java.io.Serializable;

public class Account implements Serializable{
	private Integer id;
	private Integer uid;
	private Double money;
	public Integer getId() {
	return id;
	}
	public void setId(Integer id) {
	this.id = id;
	}
	public Integer getUid() {
		// TODO Auto-generated method stub
		return this.uid;
	}
	public void setUid(Integer uid2) {
		// TODO Auto-generated method stub
		this.uid = uid2;
	}
	public Double getMoney() {
		// TODO Auto-generated method stub
		return this.money;
	}
	public void setMoney(Double money2) {
		// TODO Auto-generated method stub
		this.money = money2;
	}
}
