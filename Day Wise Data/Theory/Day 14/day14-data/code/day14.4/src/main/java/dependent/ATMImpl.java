package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;// =new HttpTransport();// dependency

//constr based D.I 
	public ATMImpl(Transport t) {
		myTransport = t;
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

	public void myInit() {
		System.out.println("in init " + myTransport);
	}

	public void myDestroy() {
		System.out.println("in destroy " + myTransport);
	}

}
