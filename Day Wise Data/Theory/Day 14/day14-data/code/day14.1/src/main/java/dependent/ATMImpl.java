package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;// =new HttpTransport();// dependency

//called by prog
	private ATMImpl(Transport t1234) {
		myTransport=t1234;
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
	//factory method based D.I => partial IoC
	public static ATMImpl myFactory(Transport t)
	{
		System.out.println("in factory method ");//invoked by SC
		return new ATMImpl(t);
	}

}
