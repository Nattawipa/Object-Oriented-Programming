public class BankAccountTester 
{
	public static void main(String[] args)
	{
		BankAccount money = new BankAccount();
		money.deposit(1000);
		money.withdraw(500);
		money.withdraw(400);
		System.out.println(money.getBalance());
	}
}
