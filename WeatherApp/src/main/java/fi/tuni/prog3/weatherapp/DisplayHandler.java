package fi.tuni.prog3.weatherapp;

import javafx.scene.control.TextField;

/**
 *
 * @author crhiho
 */
public class DisplayHandler {

    private final iMyAPI weatherAPI = new WeatherData();

    public String[] getCurrentWeatherData(TextField textField) {
        if (textField != null) {
            String[] cityData = textField.getText().split(",", 3);
            Object cityLocationObject = weatherAPI.lookUpLocation(cityData[0], "", cityData[1]);
            double[] cityLocation = (double[]) cityLocationObject;
            String[] weatherData = weatherAPI.getCurrentWeather(cityLocation[0], cityLocation[1]);
            
            return weatherData;
        }
        return null;
    }
    
    public String[][] getDailyForecast(TextField textField) {
        String[] cityData = textField.getText().split(",", 3);
        Object cityLocationObject = weatherAPI.lookUpLocation(cityData[0], "", cityData[1]);
        double[] cityLocation = (double[]) cityLocationObject;
        String[][] weatherData = weatherAPI.getForecast(cityLocation[0], cityLocation[1]);

        return weatherData;
    }

}
