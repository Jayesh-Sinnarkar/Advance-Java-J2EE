package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATMImpl;

public class TestSpringContainer {

	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aditya-config.xml"))
		{
			System.out.println("Spring up and running...");
			//tester demanding SC to ret fully configured bean
			ATMImpl bean1 = ctx.getBean("atm",ATMImpl.class);//making first demand
			bean1.deposit(100000);
			
			//next demand
			ATMImpl bean2 = ctx.getBean("atm",ATMImpl.class);//making first demand
			
			
			//next demand
			ATMImpl bean3 = ctx.getBean("atm",ATMImpl.class);//making first demand
			System.out.println(bean1==bean2);
			System.out.println(bean1==bean3);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		

	}

}
