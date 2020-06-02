

/*  The structure of Triangle class is similar to Rectangle */
public class Triangle extends Shape {


   //add your code here
	private double base;
	private double height;
	
	public Triangle()
	{
		this.base = 0;
		this.height = 0;
	}
	
	Triangle(String color, double base, double height)
	{
		super.setColor(color);
		this.base = base;
		this.height = height;
	}
	
	@Override
	public double getArea()
	{
		double area;
		area = 0.5*base*height;
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
		return "Triangle[base="+base+",height="+height+","+super.toString()+"]";
	}
}
