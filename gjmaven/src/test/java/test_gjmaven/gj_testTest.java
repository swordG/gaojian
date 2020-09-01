package test_gjmaven;

import gjmaven.gj_test;
import junit.framework.TestCase;

public class gj_testTest extends TestCase {
	
	private gj_test test = new gj_test();
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void test_And() {
		String a1 = "name='gaojian' & class='19'";
		String b1 = "SELECT * FROM table WHERE (name='gaojian' AND class='19')";
		
		String a2 = "( name='gaojian' & class='19' )";
		String b2 = "SELECT * FROM table WHERE (name='gaojian' AND class='19')";
		
		String a3 = "name='gaojian' & class='19' & num='222' & num='222'";
		String b3 = "SELECT * FROM table WHERE (name='gaojian' AND class='19' AND num='222' AND num='222')";
		
		String a4 = "( name='gaojian' & class='19' & num='222' & num='222' )";
		String b4 = "SELECT * FROM table WHERE (name='gaojian' AND class='19' AND num='222' AND num='222')";
		
		assertEquals(b1,test.test_run(a1));
		assertEquals(b2,test.test_run(a2));
		assertEquals(b3,test.test_run(a3));
		assertEquals(b4,test.test_run(a4));
	}
	
	public void test_Or()
	{
		String a1 = "name='gaojian' | class='19'";
		String b1 = "SELECT * FROM table WHERE (name='gaojian' OR class='19')";
		
		String a2 = "( name='gaojian' | class='19' )";
		String b2 = "SELECT * FROM table WHERE (name='gaojian' OR class='19')";
		
		String a3 = "name='gaojian' | class='19' | num='222' | num='222'";
		String b3 = "SELECT * FROM table WHERE (name='gaojian' OR class='19' OR num='222' OR num='222')";
		
		String a4 = "( name='gaojian' | class='19' | num='222' | num='222' )";
		String b4 = "SELECT * FROM table WHERE (name='gaojian' OR class='19' OR num='222' OR num='222')";
		
		assertEquals(b1,test.test_run(a1));
		assertEquals(b2,test.test_run(a2));
		assertEquals(b3,test.test_run(a3));
		assertEquals(b4,test.test_run(a4));
	}
	
	public void test_mutilAnd()
	{
		String a1 = "( name='gaojian' & class='19' ) & num='222'";
		String b1 = "SELECT * FROM table WHERE ((name='gaojian' AND class='19') AND num='222')";
		
		String a2 = "( ( name='gaojian' & class='19' ) & ( num='222' & num='222' ) )";
		String b2 = "SELECT * FROM table WHERE ((num='222' AND num='222') AND (name='gaojian' AND class='19'))";
		
		String a3 = "( name='gaojian' & ( class='19' & num='222' ) )";
		String b3 = "SELECT * FROM table WHERE (name='gaojian' AND (class='19' AND num='222'))";
		
		assertEquals(b1,test.test_run(a1));
		assertEquals(b2,test.test_run(a2));
		assertEquals(b3,test.test_run(a3));
	}
	
	public void test_mutilOr()
	{
		String a1 = "( name='gaojian' | class='19' ) | num='222'";
		String b1 = "SELECT * FROM table WHERE ((name='gaojian' OR class='19') OR num='222')";
		
		String a2 = "( ( name='gaojian' | class='19' ) | ( num='222' | num='222' ) )";
		String b2 = "SELECT * FROM table WHERE ((num='222' OR num='222') OR (name='gaojian' OR class='19'))";
		
		String a3 = "( name='gaojian' | ( class='19' | num='222' ) )";
		String b3 = "SELECT * FROM table WHERE (name='gaojian' OR (class='19' OR num='222'))";
		
		assertEquals(b1,test.test_run(a1));
		assertEquals(b2,test.test_run(a2));
		assertEquals(b3,test.test_run(a3));
	}
	
	public void test_mixAnd_Or()
	{
		String a1 = "! ( ( name='gaojian' & class='19' | phone='12233' ) | age=20 )";
		String b1 = "SELECT * FROM table WHERE NOT IN ((name='gaojian' AND class='19' OR phone='12233') OR age=20)";
		String a2 = "! ( name='gaojian' & class='19' | phone='12233' )";
		String b2 = "SELECT * FROM table WHERE NOT IN (name='gaojian' AND class='19' OR phone='12233')";
		
		String a3 = "! ( ( name='gaojian' & class='19' ) | phone='12233' & nation='CHNIA' )";
		String b3 = "SELECT * FROM table WHERE NOT IN ((name='gaojian' AND class='19') OR phone='12233' AND nation='CHNIA')";
		
		String a4 = "! ( ( name='gaojian' & class='19' ) | ( phone='12233' & nation='CHNIA' ) )";
		String b4 = "SELECT * FROM table WHERE NOT IN ((phone='12233' AND nation='CHNIA') OR (name='gaojian' AND class='19'))";
		
		assertEquals(b1,test.test_run(a1));
		assertEquals(b2,test.test_run(a2));
		assertEquals(b3,test.test_run(a3));
		assertEquals(b4,test.test_run(a4));
	}
}
