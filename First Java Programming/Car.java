public class Car
{
	public double fuel_effiency=0;
	public double gas_tank;
	
	public Car(double efficiency)
	{
		this.fuel_effiency = efficiency;
	}
	
	public void drive(double distance)
	{
		this.gas_tank = this.gas_tank - (distance/fuel_effiency);
	}
	
	public double getGasIntank() 
	{
		return this.gas_tank;
	}
	
	public void addGas(double litter)
	{
		this.gas_tank = this.gas_tank + litter;
	}
}