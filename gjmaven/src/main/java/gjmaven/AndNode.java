package gjmaven;

public class AndNode extends AbstractNode{
	private AbstractNode left; 		//左表达式
	private AbstractNode right;		//右表达式
	private boolean sign;  //判断是否需要加括号
	
	public AndNode(AbstractNode l,AbstractNode r) {
		// TODO Auto-generated constructor stub
		this.left=l;
		this.right=r;
		this.sign = false;
	}
	public String interpret() {
		// TODO Auto-generated method stub
		if(sign)
		{
			return "("+left.interpret()+" AND "+right.interpret()+")";
		}
		{
			return left.interpret()+" AND "+right.interpret();
		}
	}
	
	public void setSign()
	{
		this.sign = true;
	}
}
