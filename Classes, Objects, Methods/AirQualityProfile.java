import java.time.LocalDateTime;

public class AirQualityProfile 
{
	private LocalDateTime datetime;
	private String location;
	private int aqi;
	private int pm25;
	private int temp;
	private String weather;
	public static int count=0;
	public AirQualityProfile(LocalDateTime _datetime, String _location, int _aqi, int _pm25, int _temp, String _weather)
	{
		this.datetime = _datetime;
		location =_location;
		aqi = _aqi;
		pm25 = _pm25;
		temp = _temp;
		weather = _weather;
	}
	public AirQualityProfile() {
		datetime = LocalDateTime.now();
		location = "Thonburi";
		aqi = 112;
		pm25 = 40;
		temp = 29;
		weather = "Few Clouds";
	}
	public LocalDateTime getDatetime()
	{
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) 
	{
		this.datetime = datetime;
	}
	public String getLocation() 
	{
		return location;
	}
	public void setLocation(String location) 
	{
		this.location = location;
	}
	public int getAqi() {
		return aqi;
	}
	public void setAqi(int aqi) 
	{
		this.aqi = aqi;
	}
	public int getPm25() 
	{
		return pm25;
	}
	public void setPm25(int pm25)
	{
		this.pm25 = pm25;
	}
	public int getTemp()
	{
		return temp;
	}
	public void setTemp(int temp)
	{
		this.temp = temp;
	}
	public String getWeather() 
	{
		return weather;
	}
	public void setWeather(String weather) 
	{
		this.weather = weather;
	}

	public void printAirQualityInfo()
	{
		System.out.println(getLocation()+" at "+getDatetime());
		System.out.println("AQI: "+getAqi()+(", PM2.5: ")+getPm25()+" microgram/m3");
		System.out.println(getTemp()+" celcius ("+getWeather()+")");
		System.out.println(isUnhealty(aqi));
	}
	public boolean isUnhealty(int aqi) 
	{
		if(aqi>100) 
		{
			return true;
		}
			else
				return false;
	}
}
	

