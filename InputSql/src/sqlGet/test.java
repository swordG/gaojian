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
		System.out.println("���ݲ�����ɣ�");
		database.printData();
	}
	
	//TEST
	public String creatSQL1()
	{
		String SQL = new String("SELECT * FROM Database");
		Scanner input = new Scanner(System.in);
		System.out.println("�ж�CompanyName 1.equal  2.not equal �������ֱ�ʾ��ѡ\n");
		int inputint = input.nextInt();
		if(inputint==1 || inputint==2)
		{
			SQL = SQL + " WHERE CompanyName ";
			if(inputint==1)
				SQL = SQL +"= ";
			else
				SQL = SQL +"!= ";
			System.out.println("����CompanyName����ַ���\n");
			String str = input.next();
			if(str.length()==0)
				SQL = SQL + "NULL ";
			else
				SQL = SQL +"'" +str + "' ";
		}
		
		System.out.println("�ж�ContactTitle 1.equal  2.not equal �������ֱ�ʾ��ѡ\b");
		inputint = input.nextInt();
		if(inputint==1 || inputint==2)
		{
			SQL = SQL + "AND ContactTitle ";
			if(inputint==1)
				SQL = SQL +"= ";
			else
				SQL = SQL +"!= ";
			System.out.println("����ContactTitle����ַ���\n");
			String str = input.next();
			if(str.length()==0)
				SQL = SQL + "NULL ";
			else
				SQL = SQL+"'" + str + "' ";
		}
		
		System.out.println("�ж�PhoneNumble 1.contains  2.not contains �������ֱ�ʾ��ѡ\b");
		inputint = input.nextInt();
		if(inputint==1 || inputint==2)
		{
			SQL = SQL + "AND PhoneNumble ";
			if(inputint==1)
				SQL = SQL +"LIKE ";
			else
				SQL = SQL +"NOT LIKE ";
			System.out.println("����PhoneNumble��غ��봮\n");  //�����������
			boolean isNum = false;
			while(!isNum)
			{
				String str = input.next();
				//�ж��Ƿ�Ϊ��Ϊ����
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
					System.out.println("������봮�Ƿ�����Ϊȫ������ϣ�������������\n"); 
			}
		}
		System.out.println("���ɵ�SQL���Ϊ��"+SQL+"\n"); 
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
				//�ж��Ƿ�Ϊ��Ϊ����
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
