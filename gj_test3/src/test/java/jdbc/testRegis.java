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
		// 1.��ȡ�����ļ�
		in = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 2.���������߶���
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		// 3.����SqlSession��������
		factory = builder.build(in);
		// 4.����SqlSession����
		session = factory.openSession();  //����ΪtrueΪ�Զ��ύ��ȱʡ�����Ϊfalse
		// 5.����Dao�Ĵ������
		userDao = session.getMapper(IUserDao.class);
		accountDao = session.getMapper(IAccountDao.class);
		//roleDao = session.getMapper(IRoleDao.class);
	}
	
//	@Test
//	public void testFindOne() {
//		// 6.ִ�в���
//		User user = userDao.findById(41);
//		System.out.println(user);
//		assert user.getUsername().equals("����");
//	}
	
//	@Test
//	public void testSave() {
//		User user = new User();
//		user.setUsername("��̩");
//		user.setAddress("�Ͼ��н�����");
//		user.setSex("��");
//		user.setBirthday(new Date());
//		// 1.ִ�б��淽��
//		int id = userDao.saveUser(user);
//		System.out.println("�����id:"+id);
//		// 2. ��֤������
//		User savedUser = userDao.findById(id);
//		assert user.getUsername().equals("��̩");
//	}
	
//	@Test
//	public void testUpdateUser() {
//		int id = 46;
//		//1.����id��ѯ
//		User user = userDao.findById(id);
//		//2.���²���
//		user.setAddress("������˳����");
//		int res = userDao.updateUser(user);
//		// 3. ��֤������
//		User savedUser = userDao.findById(id);
//		assert user.getAddress().equals("������˳����");
//		
//		System.out.println(user.getAddress());
//		System.out.println(savedUser.getAddress());
//	}

//	@Test
//	public void testDeleteUser() {
//		// 1.ִ�в���
//		int res = userDao.deleteUser(49);
//		assert res == 1;
//	}

	
//	@Test
//	public void testFindByName() {
//		// 1.ִ�в�ѯһ������
//		List<User> users = userDao.findByName("%��%");
//		assert users.size() == 2;
//		for(User user : users) {
//		System.out.println(user);
//		}
//	}
	
//	@Test
//	public void testCount() {
//		// 1.ִ�в���
//		int res = userDao.count();
//		System.out.println("����Ϊ��"+res);
//		assert res == 25;
//	}
	
//	@Test
//	public void testQueryByVo() {
//		QueryVo vo = new QueryVo();
//		vo.setName("%��%");
//		vo.setAddress("%�Ͼ�%");
//		List<User> users = userDao.findByVo(vo);
//		assert users.size() == 1;
//	}
//	@Test
//	public void testFindAll()
//	{
//		List<User> users = userDao.findAll();
//		//System.out.println("�û�����"+users.size());
//		assert users.size() == 30;
//	}
//	
//	@Test
//	public void testQueryByVo() {
//		QueryVo vo = new QueryVo();
//		vo.setName("%��%");
//		vo.setAddress("%�Ͼ�%");
//		List<User> users = userDao.findByVo(vo);
//		assert users.size() == 1;
//	}
//	
//	@Test
//	public void testQueryByVo_withoutAddress() {
//		QueryVo vo = new QueryVo();
//		vo.setName("%��%");
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
	//6.ִ�в���
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
//			System.out.println("---ÿ����ɫ����Ϣ----");
//			System.out.println(role);
//			System.out.println(role.getUsers());
//		}
//	}

	@After
	public void tearDown() throws Exception {
		session.commit();  //��ǰ�����ύ�����ݿ���
		//7.�ͷ���Դ
		session.close();
		in.close();
	}
}
