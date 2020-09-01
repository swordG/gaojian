package gjmaven;

import java.util.Stack;

public class gj_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Handler1 test = new Handler1();
		
		String input = new String("( name='gaojian' | class='19' ) | num='222'");
		System.out.println(input);
		test.handle(input);
		String output = test.output();
		System.out.println(output);
	}
}
