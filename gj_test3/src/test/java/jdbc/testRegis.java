package jdbc;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.IUserDao;
import dao.IAccountDao;
import dao.IRoleDao;
import domain.AccountUser;
import domain.QueryVo;
import domain.QueryVoIds;
import domain.Role;
import domain.User;

public class testRegis {
	private InputStream in ;
	private SqlSessionFactory factory;
	private SqlSession session;
	private IUserDao userDao;
	private IAccountDao accountDao;
	//private IRoleDao roleDao;
	@Before
	public void setUp() throws Exception {
		// 1.读取配置文件
		in = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 2.创建构建者对象
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		// 3.创建SqlSession工厂对象
		factory = builder.build(in);
		// 4.创建SqlSession对象
		session = factory.openSession();  //设置为true为自动提交，缺省情况下为false
		// 5.创建Dao的代理对象
		userDao = session.getMapper(IUserDao.class);
		accountDao = session.getMapper(IAccountDao.class);
		//roleDao = session.getMapper(IRoleDao.class);
	}
	
//	@Test
//	public void testFindOne() {
//		// 6.执行操作
//		User user = userDao.findById(41);
//		System.out.println(user);
//		assert user.getUsername().equals("张三");
//	}
	
//	@Test
//	public void testSave() {
//		User user = new User();
//		user.setUsername("华泰");
//		user.setAddress("南京市建邺区");
//		user.setSex("男");
//		user.setBirthday(new Date());
//		// 1.执行保存方法
//		int id = userDao.saveUser(user);
//		System.out.println("保存的id:"+id);
//		// 2. 验证保存结果
//		User savedUser = userDao.findById(id);
//		assert user.getUsername().equals("华泰");
//	}
	
//	@Test
//	public void testUpdateUser() {
//		int id = 46;
//		//1.根据id查询
//		User user = userDao.findById(id);
//		//2.更新操作
//		user.setAddress("北京市顺义区");
//		int res = userDao.updateUser(user);
//		// 3. 验证保存结果
//		User savedUser = userDao.findById(id);
//		assert user.getAddress().equals("北京市顺义区");
//		
//		System.out.println(user.getAddress());
//		System.out.println(savedUser.getAddress());
//	}

//	@Test
//	public void testDeleteUser() {
//		// 1.执行操作
//		int res = userDao.deleteUser(49);
//		assert res == 1;
//	}

	
//	@Test
//	public void testFindByName() {
//		// 1.执行查询一个方法
//		List<User> users = userDao.findByName("%王%");
//		assert users.size() == 2;
//		for(User user : users) {
//		System.out.println(user);
//		}
//	}
	
//	@Test
//	public void testCount() {
//		// 1.执行操作
//		int res = userDao.count();
//		System.out.println("行数为："+res);
//		assert res == 25;
//	}
	
//	@Test
//	public void testQueryByVo() {
//		QueryVo vo = new QueryVo();
//		vo.setName("%王%");
//		vo.setAddress("%南京%");
//		List<User> users = userDao.findByVo(vo);
//		assert users.size() == 1;
//	}
//	@Test
//	public void testFindAll()
//	{
//		List<User> users = userDao.findAll();
//		//System.out.println("用户量："+users.size());
//		assert users.size() == 30;
//	}
//	
//	@Test
//	public void testQueryByVo() {
//		QueryVo vo = new QueryVo();
//		vo.setName("%王%");
//		vo.setAddress("%南京%");
//		List<User> users = userDao.findByVo(vo);
//		assert users.size() == 1;
//	}
//	
//	@Test
//	public void testQueryByVo_withoutAddress() {
//		QueryVo vo = new QueryVo();
//		vo.setName("%王%");
//		vo.setAddress(null);
//		List<User> users = userDao.findByVo(vo);
//		assert users.size() == 2;
//	}
	
	@Test
	public void testFindInIds() {
		QueryVoIds voIds = new QueryVoIds();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(41);
		ids.add(42);
		ids.add(45);
		ids.add(46);
		voIds.setIds(ids);
		List<User> users = userDao.findInIds(voIds);
		assert users.size() == 4;
	}
	
	@Test
	public void testFindAll() {
	//6.执行操作
		List<AccountUser> accountusers = accountDao.findAll();
		for(AccountUser au : accountusers) {
			System.out.println(au);
		}
		assert accountusers.size() == 3;
	}
	
//	@Test
//	public void testFindAll2() {
//		List<Role> roles = roleDao.findAll();
//		assert roles.size()==3;
//		for(Role role : roles){
//			System.out.println("---每个角色的信息----");
//			System.out.println(role);
//			System.out.println(role.getUsers());
//		}
//	}

	@After
	public void tearDown() throws Exception {
		session.commit();  //当前事务提交到数据库中
		//7.释放资源
		session.close();
		in.close();
	}
}
