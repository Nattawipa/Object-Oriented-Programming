public class Person
{
	public String firstname;
	public String lastname;
	public MyDate birthday;
	
	Person(String aFirstname, String aLastname)
	{
		this.firstname = aFirstname;
		this.lastname = aLastname;
	}
	
	Person(String aFirstname, String aLastname, int aYear, int aMonth, int aDay)
	{
		this.firstname = aFirstname;
		this.lastname = aLastname;
		this.birthday = new MyDate(aYear, aMonth, aDay);
	}
	
	public int getAge(MyDate aDate)
	{
		MyDate today = new MyDate(2019, 2, 4);
		return today.yearDiff(birthday, today);
	}
	
	public boolean isEligible(MyDate elecDate)
	{
		if(elecDate.year - birthday.year >=18)
		{
			return true;
		}
		return false;
	}
	 
	public void printPersonInfo()
	{
		System.out.println("Person : "+this.firstname+" "+this.lastname);
		System.out.println("Birthday : "+this.birthday.day+" "+this.birthday.month+" "+this.birthday.year);
	}

}
