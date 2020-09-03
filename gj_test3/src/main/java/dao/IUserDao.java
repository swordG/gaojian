package dao;

import java.util.*;

import domain.QueryVo;
import domain.QueryVoIds;
import domain.User;

public interface IUserDao {
	List<User> findAll();
	User findById(Integer userId);
	int saveUser(User user);
	int updateUser(User user);
	int deleteUser(Integer userId);
	List<User> findByName(String username);
	int count();
	
	List<User> findByVo(QueryVo vo);
	List<User> findInIds(QueryVoIds voIds);
}
