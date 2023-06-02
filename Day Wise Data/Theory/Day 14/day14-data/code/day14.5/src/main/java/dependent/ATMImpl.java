package dependent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dependency.Transport;
//singleton n eager , id=my_atm
@Component("my_atm")
public class ATMImpl implements ATM {
	@Autowired// (required = false)
	@Qualifier("httpTransport") //by name
	private Transport myTransport;// dependency


	public ATMImpl() {		
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport);
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);// dependent obj is calling
		// dependency's method for informing the bank

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
	}
	@PostConstruct
	public void myInit() {
		System.out.println("in init " + myTransport);
	}
	@PreDestroy
	public void myDestroy() {
		System.out.println("in destroy " + myTransport);
	}
}
