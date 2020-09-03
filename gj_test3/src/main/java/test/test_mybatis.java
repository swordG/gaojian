package test;
import dao.IUserDao;
import domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class test_mybatis {
	public static void main(String[] args) throws IOException {
		// 1.��ȡ�����ļ�
				InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
				//2.����SqlSessionFactory�Ĺ����߶���
				SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
				//3.ʹ�ù����ߴ�����������SqlSessionFactory
				SqlSessionFactory factory = builder.build(in);
				//4.ʹ��SqlSessionFactory����SqlSession����
				SqlSession session = factory.openSession();
				//5.ʹ��SqlSession����dao�ӿڵĴ������
				IUserDao userDao = session.getMapper(IUserDao.class);
				//6.ʹ�ô������ִ�в�ѯ���з���
				List<User> users = userDao.findAll();
				for(User user : users) {
				System.out.println(user);
				}
				//7.�ͷ���Դ
				session.close(); in.close();
	}
}
