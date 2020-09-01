package gjmaven;

public class AndNode extends AbstractNode{
	private AbstractNode left; 		//����ʽ
	private AbstractNode right;		//�ұ��ʽ
	private boolean sign;  //�ж��Ƿ���Ҫ������
	
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
