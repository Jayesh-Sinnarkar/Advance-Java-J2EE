package dependency;

public class EmailNotification implements CustomerNotificationService {

	public EmailNotification() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void alertCustomer(String msgs) {
		System.out.println("Customer alerted "+getClass()+" Message:"+msgs);

	}

}
