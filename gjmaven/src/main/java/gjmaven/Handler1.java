package gjmaven;

import java.util.*;

public class Handler1 {
	private AbstractNode node;
	//��ջ�������﷨��
	Stack<AbstractNode> stack = new Stack<AbstractNode>();
	Stack<String> stackAll = new Stack<String>();
	Stack<String> stackOneLuoji = new Stack<String>();
	
	//����stackOneLuoji�е�ֵ������
	public void creatAnd_OR()
	{
		String nowStr;
		AbstractNode leftabstract;
		AbstractNode rightabstract;
		Condition lcondition;
		if(stackOneLuoji.empty())
			return;
		
		nowStr = stackOneLuoji.pop();    //�����Ƿ���
		if(nowStr.contentEquals("|") || nowStr.contentEquals("&"))
		{
			leftabstract = stack.pop(); //������ֵ
			if(nowStr.contentEquals("&"))
			{
				creatAnd_OR();
				rightabstract = stack.pop();
				AndNode an = new AndNode(leftabstract,rightabstract);
				stack.push(an);
			}
			else  //|
			{
				creatAnd_OR();
				rightabstract = stack.pop();
				OrNode on = new OrNode(leftabstract,rightabstract);
				stack.push(on);
			}
		}
		else  		//����
		{
			lcondition = new Condition(nowStr);
			stack.push(lcondition);
			creatAnd_OR();   //�ݹ飬��һ��һ���Ƿ���
		}
	}
	
	public void handle(String instruction) {
		//�ÿո�ָ�ָ��
		String[] word = instruction.split("\\s+");

		for(int i=0;i<word.length;i++)
		{
			if(!word[i].contentEquals(")"))
			{
				stackAll.push(word[i]);
				if(i==(word.length-1))
				{
					word[i]=")";i=i-1;
				}
			}
			else  //�ͽ���ջ���������һ���������ݵ���
			{
				stackOneLuoji.clear();
				while(!stackAll.empty() && !stackAll.peek().contentEquals("("))  //����������ȫ�������ݴ�
					stackOneLuoji.push(stackAll.pop());
				
				//ִ���߼�
				creatAnd_OR();
				stack.peek().setSign();  //��������
				if(!stackAll.empty())
					stackAll.pop();   //����(
			}
		}
		if(!stackAll.empty() && stackAll.peek().contentEquals("!"))
		{
			Condition lcondition = new Condition("NOT IN ");
			NormalNode nn = new NormalNode(lcondition,stack.pop());
			stack.push(nn);
		}
		Condition lcondition = new Condition("SELECT * FROM table WHERE ");
		NormalNode nn = new NormalNode(lcondition,stack.pop());
		stack.push(nn);
		
		this.node = stack.pop();
	}
	
	public String output()
	{
		return this.node.interpret();
	}
}
