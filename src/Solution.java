import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    // weather_data.put(date, Weather) to add data to the map
    public static List<Weather> weather_list = new ArrayList<>();
    public static Map<String, Weather> weather_data = new HashMap<>();

    public static void main(String[] args) {

        //initalize variables for when input is read lat
        int query = 0;
        String query_date = "";
        //prevent query variable from not initalized

        //Load data
        try(Scanner reader = new Scanner(System.in)){
            int LineCount = Integer.parseInt(reader.nextLine());

            //data population loop
            for(int i = 0; i < LineCount; i++) {
                String data = reader.nextLine();
                String[] weather_entry = data.split(","); // length should be 5, [0] date, [1] temp, [2] humidity, [3] windSpeed, [4] rainfall
                //check for query


                if(weather_entry.length < 2) { break; }


                Pattern rg_date_format = Pattern.compile("^(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])-(19|20)\\d{2}$", Pattern.CASE_INSENSITIVE);
                Matcher matcher = rg_date_format.matcher(weather_entry[0]);
                boolean matchFound = matcher.find();
                if(matchFound) {
                    Weather newWeather = new Weather(weather_entry[0], Integer.parseInt(weather_entry[1]), Integer.parseInt(weather_entry[2]), Integer.parseInt(weather_entry[3]), Integer.parseInt(weather_entry[4]));
                    weather_data.put(weather_entry[0], newWeather);
                    weather_list.add(newWeather);
                }

                //access temporary array that contains weather data
                //[0] date, [1] temp, [2] humidity, [3] windSpeed, [4] rainfall


                //}
            }
            query = Integer.parseInt(reader.nextLine());
            if(query == 1){
                query = 1;

            }
            else if(query == 2) {
                query = 2;
                query_date = reader.nextLine();

            }
        }
        catch(Exception e) {
            System.out.println("unexpected exception:" + e.getMessage());
        }

        //user input
        System.out.println("Records loaded -> " + weather_list.size());
        if (query == 1) {
            if (weather_list.isEmpty()) {
                System.out.println("\nNo valid records available to show any stats");

            }
            else{
                System.out.println("\nWeather Stats:");
                System.out.println("Highest Temperature: " + HighestTemperture());
                System.out.println("Lowest Temperature: " + LowestTemperature());

                System.out.print("Average Temperature: ");
                System.out.printf("%.2f", AverageTemperature());
                System.out.println();

                System.out.print("Average Humidity: ");
                System.out.printf("%.2f", AverageHumidity());
                System.out.println();

                System.out.println("Total Rainfall: " + TotalRainfall());
                System.out.println("Highest Wind Speed Day: " + DateWithHighestWindSpeed());
            }
        }

        //Note: change to use map not list
        else if (query == 2) {
            //check if date exists in the map
            System.out.println("\nSearch by Date:");
            if (weather_data.containsKey(query_date)) {
                Weather weatherOfDate = weather_data.get(query_date);
                System.out.println("Date: " + weatherOfDate.getDate());
                System.out.println("Temperature: " + weatherOfDate.getTemperature());
                System.out.println("Humidity: " + weatherOfDate.getHumidity());
                System.out.println("Wind Speed: " + weatherOfDate.getWindspeed());
                System.out.println("Rainfall: " + weatherOfDate.getRainfall());
            }
            else {
                System.out.println("Record not found");
            }
        }

    } //end of main method

    /*
    -------------------Calculation methods-------------------
    */
    public static int HighestTemperture() {
        int highestTemp = Integer.MIN_VALUE;
        for (Weather weather : weather_list) {
            if(weather.getTemperature() > highestTemp) {
                highestTemp = weather.getTemperature();
            }
        }
        return highestTemp;
    }

    public static int LowestTemperature() {
        int lowestTemp = Integer.MAX_VALUE;
        for (Weather weather : weather_list) {
            if(weather.getTemperature() < lowestTemp) {
                lowestTemp = weather.getTemperature();
            }
        }
        return lowestTemp;
    }

    public static int TotalRainfall() {
        int totalRainfall = 0;
        for (Weather weather : weather_list) {
            totalRainfall += weather.getRainfall();
        }
        return totalRainfall;
    }

    public static String DateWithHighestWindSpeed() {
        //make highestWindow speed min value
        int highestWindSpeed = -1;
        //empty string initalization
        String dateWithHighestWindSpeed = "";

        //searches though weather list for highest wind speed int
        for (Weather weather : weather_list) {
            if(weather.getWindspeed() > highestWindSpeed) {
                highestWindSpeed = weather.getWindspeed();
                dateWithHighestWindSpeed = weather.getDate();
            }
        }
        return dateWithHighestWindSpeed;
    }

    public static double AverageTemperature() {
        int totalTemperature = 0;
        for (Weather weather : weather_list) {
            totalTemperature += weather.getTemperature();
        }
        return (double) totalTemperature / weather_list.size();
    }

    public static double AverageHumidity() {
        int totalHumidity = 0;
        for (Weather weather : weather_list) {
            totalHumidity += weather.getHumidity();
        }
        return (double) totalHumidity / weather_list.size();
    }

}//end of main class


class Weather {
    //variables
    private String date;
    private int temperature;
    private int humidity;
    private int rainfall;
    private int windspeed;

    //constructor
    public Weather(String date, int temperature, int humidity, int windspeed, int rainfall) {
        this.date = date;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windspeed = windspeed;
        this.rainfall = rainfall;
    }

    //getters
    public String getDate() {
        return date;
    }
    public int getTemperature() {
        return temperature;
    }
    public int getHumidity() {
        return humidity;
    }
    public int getRainfall() {
        return rainfall;
    }
    public int getWindspeed() {
        return windspeed;
    }

    //setters
    public void setDate(String date) {
        this.date = date;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
    public void setRainfall(int rainfall) {
        this.rainfall = rainfall;
    }
    public void setWindspeed(int windspeed) {
        this.windspeed = windspeed;
    }
}//end of weather class
