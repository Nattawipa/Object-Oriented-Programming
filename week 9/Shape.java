
abstract class Shape implements Comparable
{
	public static double PI = 3.14 ;
	public String color ;
	public String description ;
	
	public Shape(String color, String description) 
	{
		this.color = color;
		this.description = description;
	}

	public String getColor(){
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString()
	{
		return this.description+" (color="+this.getColor()+", area="+this.getArea() +")";
		
	}
	
	public int  compareTo(Object shape)
	{
		if(this.getArea() > ((Shape)shape).getArea())
		{
			return 1 ;
		}
		else if (this.getArea() == ((Shape)shape).getArea())
		{
			return 0 ;
		}
		else
		 return -1 ;
	}
	
	abstract double getArea();
}
