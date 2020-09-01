package gjmaven;

import java.util.*;

public class Handler1 {
	private AbstractNode node;
	//用栈来保存语法树
	Stack<AbstractNode> stack = new Stack<AbstractNode>();
	Stack<String> stackAll = new Stack<String>();
	Stack<String> stackOneLuoji = new Stack<String>();
	
	//根据stackOneLuoji中的值来创建
	public void creatAnd_OR()
	{
		String nowStr;
		AbstractNode leftabstract;
		AbstractNode rightabstract;
		Condition lcondition;
		if(stackOneLuoji.empty())
			return;
		
		nowStr = stackOneLuoji.pop();    //可能是符号
		if(nowStr.contentEquals("|") || nowStr.contentEquals("&"))
		{
			leftabstract = stack.pop(); //创建右值
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
		else  		//数字
		{
			lcondition = new Condition(nowStr);
			stack.push(lcondition);
			creatAnd_OR();   //递归，下一个一定是符号
		}
	}
	
	public void handle(String instruction) {
		//用空格分隔指令
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
			else  //就近出栈，将最近的一个括号内容弹出
			{
				stackOneLuoji.clear();
				while(!stackAll.empty() && !stackAll.peek().contentEquals("("))  //括号中内容全部弹到暂存
					stackOneLuoji.push(stackAll.pop());
				
				//执行逻辑
				creatAnd_OR();
				stack.peek().setSign();  //设置括号
				if(!stackAll.empty())
					stackAll.pop();   //弹出(
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
