package tester;

import dependency.HttpTransport;
import dependency.Transport;
import dependent.ATMImpl;

public class TestATM {

	public static void main(String[] args) {
		ATMImpl atm=new ATMImpl();//dependent obj
		Transport transport=new HttpTransport();//dependenct obj
		atm.setMyTransport(transport);//providing the dependency(wiring)
		atm.withdraw(1000);

	}

}
