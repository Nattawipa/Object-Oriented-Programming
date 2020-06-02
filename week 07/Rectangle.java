
/*
 * The Rectangle class, subclass of Shape
 */
public class Rectangle extends Shape {
   // Private member variables
   //add your code here
	private double length;
	private double width;

   // Constructors
   public Rectangle()
   {
	  //add your code here
	   this.length = 0;
	   this.width = 0;
   }
   public Rectangle(String color, double length, double width) {
      //add your code here
	   super.setColor(color);
	   this.length = length;
	   this.width = width;
   }

   @Override
   public String toString() {
      //add your code here
	  return "Rectanglele[base="+length+",height="+width+","+super.toString()+"]";   
   }

   // Override the inherited getArea() to provide the proper implementation
   public double getArea() {
      //add your code here
	   double area = length * width;
	   return area;
   }

   public double getArea(double length, double width) {
	   	 //add your code here
	   this.length = length;
	   this.width = width;
	   return getArea();
	   }
}
