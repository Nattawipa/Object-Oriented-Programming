
public class Parallelogram extends Shape {
	
	private double base;
	private double height;
	
	public Parallelogram()
	{
		this.base = 0;
		this.height = 0;
	}
	
	Parallelogram(String color, double base, double height)
	{
		super.setColor(color);
		this.base = base;
		this.height = height;
	}
	
	@Override
	public double getArea()
	{
		double area;
		area = base*height;
		return area;
	}
	
	public double getArea(double base, double height)
	{
		this.base = base;
		this.height = height;
		return getArea();
	}
	
	public String toString()
	{
		return "Parallelogram[base="+base+",height="+height+","+super.toString()+"]";
	}
}

