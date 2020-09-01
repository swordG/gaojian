package gjmaven;
import java.util.*;

public class Handler {
	private AbstractNode node;
	
	public void handle(String instruction) {
		//��ջ�������﷨����
		Stack<AbstractNode> stack = new Stack<AbstractNode>();
		Stack<String> stack1 = new Stack<String>();
		
		//�ÿո�ָ�ָ��
		String[] word = instruction.split("\\s+");
		
		//ѭ��,ֱ��ջΪ��Ϊֹ
		boolean rightHad;
		AbstractNode leftabstract;
		AbstractNode rightabstract;
		String stack1pop;
		String rightC;String leftC;
		AndNode andnode =null;
		OrNode ornode =null;
		Condition lcondition;
		Condition rcondition;
		for(int i=0;i<word.length;i++)
		{
			if(!word[i].contentEquals(")"))
			{
				stack1.push(word[i]);
				if(!stack.empty())
					stack.peek().setSign();
			}
			else
			{//��ջ����
				stack1pop = stack1.pop();
				rightHad= false; 				//��ʾ�ұߺ���abstract�������һ���ַ���
				leftabstract=null;
				while(!stack1pop.contentEquals("("))
				{
					rightC = stack1pop;
					if(!stack1.empty())
						stack1pop = stack1.pop();
					else
						break;
					if(stack1pop.contentEquals("&"))
					{
						andnode =null;
						leftC = stack1.pop();
						if(rightHad)  //�ұ�����
						{
							if(leftC.contentEquals("("))
							{
								andnode = new AndNode(stack.pop(),stack.pop());
							}	
							else
							{
								lcondition = new Condition(leftC);
								andnode = new AndNode(lcondition,stack.pop());
							}
						}
						else   //������
						{
							rcondition = new Condition(rightC);
							if(leftC.contentEquals("("))  //�������xx��&B���֣���ʾ��ֵΪһabstract
							{ 
								leftabstract = stack.pop();
								andnode = new AndNode(leftabstract,rcondition);
							}
							else   //����
							{
								lcondition = new Condition(leftC);
								andnode = new AndNode(lcondition,rcondition);
							}
						}
						stack.push(andnode);
						rightHad = true;
					}
					else if(stack1pop.contentEquals("|"))
					{
						ornode =null;
						leftC = stack1.pop();
						if(rightHad)  //�ұ�����
						{
							if(leftC.contentEquals("("))
							{
								rightabstract = stack.pop();
								leftabstract = stack.pop();
								ornode = new OrNode(leftabstract,rightabstract);
							}
							else
							{
								lcondition = new Condition(leftC);
								ornode = new OrNode(lcondition,stack.pop());
							}
						}
						else   //������
						{
							rcondition = new Condition(rightC);
							if(leftC.contentEquals("("))  //�������xx��&B���֣���ʾ��ֵΪһabstract
							{ 
								leftabstract = stack.pop();
								ornode = new OrNode(leftabstract,rcondition);
							}
							else   //����
							{
								lcondition = new Condition(leftC);
								ornode = new OrNode(lcondition,rcondition);
							}
						}
						stack.push(ornode);
						rightHad = true;
					}
				}
				if(stack1pop.contentEquals("!"))   //��ʱ��Ϊ��ͷ��
				{
					lcondition = new Condition(" NOT IN ");
					NormalNode nn = new NormalNode(lcondition,stack.pop());
					nn.setSign();
					stack.push(nn);
				}
			}
		}
		lcondition = new Condition("SELECT * FROM table WHERE ");
		NormalNode nn = new NormalNode(lcondition,stack.pop());
		stack.push(nn);
		//���յ�ƴ��
		this.node = stack.pop();
	}
	
	public String output() {
		String result = node.interpret();
		return result;
	}
}
