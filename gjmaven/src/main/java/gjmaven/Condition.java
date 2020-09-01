package gjmaven;

public class Condition extends AbstractNode{
	private String condition;
	public Condition(String str)
	{
		this.condition = str;
	}
	
	public String interpret() {
		// TODO Auto-generated method stub
		return this.condition;
	}
	
	public void setSign()
	{
	}
}
