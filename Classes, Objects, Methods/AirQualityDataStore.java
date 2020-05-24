import java.time.LocalDateTime;

public class AirQualityDataStore 
{
	public static void main(String[] args)
	{
		LocalDateTime today = LocalDateTime.now();
		AirQualityProfile Thonburi = new AirQualityProfile();
		AirQualityProfile London = new AirQualityProfile(today, "London", 99, 35, -1, "Mist");
		AirQualityProfile Paris = new AirQualityProfile();
		
		Paris.setLocation("Paris");
		Paris.setAqi(114);
		Paris.setPm25(41);
		Paris.setTemp(-3);
		Paris.setWeather("Mist");
		
		Thonburi.isUnhealty(Thonburi.getAqi());
		Thonburi.printAirQualityInfo();
		London.printAirQualityInfo();
		Paris.printAirQualityInfo();
	}
}
