package sqlGet;
import java.util.*;

public class test {
	Database database = new Database();
	public void insertData()
	{
		database.insertLine("1", "huatai", "uu", "gg", "**", "8086", "111111111");
		database.insertLine("2", "huatai", "uu", "gg", "**", "8087", "222222222");
		database.insertLine("3", "huatai", "uu", "gg", "**", "8088", "333333333");
		database.insertLine("4", "huatai", "uu", "gg", "**", "8089", "444444444");
		database.insertLine("5", "huatai", "uu", "gg", "**", "8090", "555555555");
		database.insertLine("6", "huatai", "uu", "gg", "**", "8091", "666666666");
		System.out.println("数据插入完成！");
		database.printData();
	}
	
	//TEST
	public String creatSQL1()
	{
		String SQL = new String("SELECT * FROM Database");
		Scanner input = new Scanner(System.in);
		System.out.println("判断CompanyName 1.equal  2.not equal 其它数字表示不选\n");
		int inputint = input.nextInt();
		if(inputint==1 || inputint==2)
		{
			SQL = SQL + " WHERE CompanyName ";
			if(inputint==1)
				SQL = SQL +"= ";
			else
				SQL = SQL +"!= ";
			System.out.println("输入CompanyName相关字符串\n");
			String str = input.next();
			if(str.length()==0)
				SQL = SQL + "NULL ";
			else
				SQL = SQL +"'" +str + "' ";
		}
		
		System.out.println("判断ContactTitle 1.equal  2.not equal 其它数字表示不选\b");
		inputint = input.nextInt();
		if(inputint==1 || inputint==2)
		{
			SQL = SQL + "AND ContactTitle ";
			if(inputint==1)
				SQL = SQL +"= ";
			else
				SQL = SQL +"!= ";
			System.out.println("输入ContactTitle相关字符串\n");
			String str = input.next();
			if(str.length()==0)
				SQL = SQL + "NULL ";
			else
				SQL = SQL+"'" + str + "' ";
		}
		
		System.out.println("判断PhoneNumble 1.contains  2.not contains 其它数字表示不选\b");
		inputint = input.nextInt();
		if(inputint==1 || inputint==2)
		{
			SQL = SQL + "AND PhoneNumble ";
			if(inputint==1)
				SQL = SQL +"LIKE ";
			else
				SQL = SQL +"NOT LIKE ";
			System.out.println("输入PhoneNumble相关号码串\n");  //插入检测非数字
			boolean isNum = false;
			while(!isNum)
			{
				String str = input.next();
				//判断是否为均为数字
				for(int i=0;i<str.length();i++)
				{
					if(str.charAt(i)<'0'||str.charAt(i)>'9')
					{
						isNum = false;
						break;
					}
					else
						isNum = true;
				}
				
				if(isNum)
				{
					if(str.length()!=0)
						SQL = SQL +"'%"+str + "%' ";
				}
				else
					System.out.println("输入号码串非法（需为全数字组合），请重新输入\n"); 
			}
		}
		System.out.println("生成的SQL语句为："+SQL+"\n"); 
		return SQL;
	}
	public String creatSQL(int cna,String cns,int cct,String ccs,int call,String number)
	{
		String SQL = new String("SELECT * FROM Database");
		if(cna==1 || cna==2)
		{
			SQL = SQL + " WHERE CompanyName ";
			if(cna==1)
				SQL = SQL +"= ";
			else
				SQL = SQL +"!= ";
			if(cns.length()==0)
				SQL = SQL + "NULL ";
			else
				SQL = SQL +"'" +cns + "' ";
		}
		
		if(cct==1 || cct==2)
		{
			SQL = SQL + "AND ContactTitle ";
			if(cct==1)
				SQL = SQL +"= ";
			else
				SQL = SQL +"!= ";
			if(ccs.length()==0)
				SQL = SQL + "NULL ";
			else
				SQL = SQL+"'" + ccs + "' ";
		}
		
		if(call==1 || call==2)
		{
			SQL = SQL + "AND PhoneNumble ";
			if(call==1)
				SQL = SQL +"LIKE ";
			else
				SQL = SQL +"NOT LIKE ";
			boolean isNum = false;
			while(!isNum)
			{
				//判断是否为均为数字
				for(int i=0;i<number.length();i++)
				{
					if(number.charAt(i)<'0'||number.charAt(i)>'9')
					{
						isNum = false;
						break;
					}
					else
						isNum = true;
				}
				
				if(isNum)
				{
					if(number.length()!=0)
						SQL = SQL +"'%"+number + "%' ";
				}
			}
		}
		return SQL;
	}
	
}
