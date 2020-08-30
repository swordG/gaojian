package sqlGet;
import java.util.*;

public class Database {
	private Map<String,DataTable> store = new HashMap<String,DataTable>();
	public void insertLine(String id,String cpn,String cn,String ct,String region,String pc,String pn)
	{
		DataTable line = new DataTable();
		if(store.containsKey(id))
		{
			System.out.println(id+"�������У��������²���\n");
		}
		else
		{
			line.setDate(id, cpn, cn, ct, region, pc, pn);
			store.put(id, line);
		}
	}
	
	public void printData()
	{
		DataTable.printTableHead();
		for(String id:store.keySet())
		{
			store.get(id).printDate();
		}
	}
	
	//����SQL
	public void search(String SQL)
	{
	}
}
