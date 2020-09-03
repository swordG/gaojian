package dao;

import java.util.List;

import domain.AccountUser;

public interface IAccountDao {
	List<AccountUser> findAll();
}
