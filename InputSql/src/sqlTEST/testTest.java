package sqlTEST;

import java.util.*;
import sqlGet.test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sqlGet.test;

class testTest extends test {
	
	private static test Test = new test();
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCreatSQL() {
		String str = new String("SELECT * FROM Database WHERE CompanyName = 'dass' AND ContactTitle = 'dskkla' AND PhoneNumble NOT LIKE '%234566%' ");
		String str1 = new String("SELECT * FROM Database WHERE CompanyName != 'dass' AND ContactTitle != 'dskkla' AND PhoneNumble NOT LIKE '%234566%' ");
		String str2 = new String("SELECT * FROM Database WHERE CompanyName = 'dass' AND ContactTitle = 'dskkla' AND PhoneNumble LIKE '%234566%' ");
		assertEquals(str,Test.creatSQL(1, "dass", 1, "dskkla", 2, "234566"));
		assertEquals(str1,Test.creatSQL(2, "dass", 2, "dskkla", 2, "234566"));
		assertEquals(str2,Test.creatSQL(1, "dass", 1, "dskkla", 1, "234566"));
	}

}
