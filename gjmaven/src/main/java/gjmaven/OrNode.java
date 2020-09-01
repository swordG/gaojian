package gjmaven;

public class OrNode extends AbstractNode{
	private AbstractNode left; 		//左表达式
	private AbstractNode right;		//右表达式
	private boolean sign;
	
	public OrNode(AbstractNode l,AbstractNode r) {
		// TODO Auto-generated constructor stub
		this.left=l;
		this.right=r;
		this.sign = false;
	}
	public String interpret() {
		// TODO Auto-generated method stub
		if(sign)
		{
			return "("+left.interpret()+" OR "+right.interpret()+")";
		}
		{
			return left.interpret()+" OR "+right.interpret();
		}
	}
	
	public void setSign()
	{
		this.sign = true;
	}
}
