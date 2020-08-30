package sqlGet;

public class start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test test1 = new test();
		test1.insertData();
		System.out.println(test1.creatSQL(1, "dass", 1, "dskkla", 2, "234566"));
		
		while(true)
		{
			String SQL = test1.creatSQL1();
		}
	}
}
