package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring-config.xml")) {
			System.out.println("SC up  n running !!!!!!!!!!!!!");
			//withdraw 1000 from atm
			ATMImpl ref1=ctx.getBean("my_atm", ATMImpl.class);
			ref1.withdraw(1000);//B.L 
			ATMImpl ref2=ctx.getBean("my_atm", ATMImpl.class);
			System.out.println(ref1==ref2);//f
			
		} // ctx.close() => shutting down SC -- looks for singleton beans --chks for
			// destroy --invokes the same -- marked for GC
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
