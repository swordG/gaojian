package gjmaven;
import java.util.*;

public class Handler {
	private AbstractNode node;
	
	public void handle(String instruction) {
		//用栈来保存语法树。
		Stack<AbstractNode> stack = new Stack<AbstractNode>();
		Stack<String> stack1 = new Stack<String>();
		
		//用空格分隔指令
		String[] word = instruction.split("\\s+");
		
		//循环,直到栈为空为止
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
			{//出栈操作
				stack1pop = stack1.pop();
				rightHad= false; 				//表示右边含有abstract类而不是一个字符串
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
						if(rightHad)  //右边有类
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
						else   //纯数字
						{
							rcondition = new Condition(rightC);
							if(leftC.contentEquals("("))  //如果（（xx）&B这种，表示左值为一abstract
							{ 
								leftabstract = stack.pop();
								andnode = new AndNode(leftabstract,rcondition);
							}
							else   //数字
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
						if(rightHad)  //右边有类
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
						else   //纯数字
						{
							rcondition = new Condition(rightC);
							if(leftC.contentEquals("("))  //如果（（xx）&B这种，表示左值为一abstract
							{ 
								leftabstract = stack.pop();
								ornode = new OrNode(leftabstract,rcondition);
							}
							else   //数字
							{
								lcondition = new Condition(leftC);
								ornode = new OrNode(lcondition,rcondition);
							}
						}
						stack.push(ornode);
						rightHad = true;
					}
				}
				if(stack1pop.contentEquals("!"))   //暂时认为到头了
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
		//最终的拼合
		this.node = stack.pop();
	}
	
	public String output() {
		String result = node.interpret();
		return result;
	}
}
