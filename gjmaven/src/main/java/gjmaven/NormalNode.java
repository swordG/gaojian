package gjmaven;

public class NormalNode extends AbstractNode {
	private AbstractNode left; 		//左表达式
	private AbstractNode right;		//右表达式
	private boolean sign;
	
	public NormalNode(AbstractNode l,AbstractNode r) {
		// TODO Auto-generated constructor stub
		this.left=l;
		this.right=r;
		this.sign = false;
	}
	public String interpret() {
		// TODO Auto-generated method stub
		if(sign)
		{
			return "("+left.interpret()+right.interpret()+")";
		}
		else
			return left.interpret()+right.interpret();
	}
	public void setSign()
	{
		this.sign = true;
	}

}
