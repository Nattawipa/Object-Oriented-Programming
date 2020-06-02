public class CarTester 
{
	public static void main(String[] args)
	{
		Car myCar = new Car(20);
		myCar.addGas(40);
		myCar.drive(100);
		double gasLeft = myCar.getGasIntank();
		System.out.println(gasLeft);
	}

}
