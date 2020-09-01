package gjmaven;

public class gj_test {
	private Handler1 handler = new Handler1();
	
	public String test_run(String instruction)
	{
		 handler.handle(instruction);
		 return handler.output();
	}

}
