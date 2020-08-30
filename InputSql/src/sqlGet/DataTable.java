package sqlGet;

public class DataTable {
	public String ID = new String();
	public String CompanyName = new String();
	public String ContactName = new String();
	public String ContactTitle = new String();
	public String Region = new String();
	public String PostalCode = new String();
	public String PhoneNumble = new String();
	
	public void setDate(String id,String cpn,String cn,String ct,String region,String pc,String pn)
	{
		ID = id;CompanyName = cpn;ContactName = cn;ContactTitle = ct;Region = region;PostalCode = pc;PhoneNumble = pn;
	}
	public void printDate()
	{
		System.out.println(ID+"\t"+CompanyName+"\t"+ContactName+"\t"+ContactTitle+"\t"+Region+"\t"+PostalCode+"\t"+PhoneNumble+"\n");
	}
	public static void printTableHead()
	{
		System.out.println("ID\tCompanyName\tContactName\tContactTitle\tRegion\tPostalCode\tPhoneNumble\t");
	}
}
