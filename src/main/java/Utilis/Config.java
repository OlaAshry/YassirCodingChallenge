package Utilis;

public class Config {

    //=============================Weather Endpoint==================================
    public static String getWeatherBaseUrl() {
        return "http://api.weatherstack.com";
    }
    public static String getWeatherValidApiKey() {
        return "057d88b60d01ac085c36f4502c47d300";
    }
    public static String getWeatherInvalidApiKey() {
        return "cf9956ef6aa96e1a50e4dfc14dc1234f";
    }
    public static String getWeatherNoApiKey(){
        return "";
    }
    //=============================Fixer Endpoint==================================
    public static String getFixerBaseUrl() {
        return "https://data.fixer.io/api/latest";
    }
    public static String getFixerValidApiKey() {
        return "63da94713e6edf506828c3e470de679b";
    }
    public static String getFixerInvalidApiKey() {
        return "63da94713e6edf506828c3e471de123b";
    }
    public static String getFixerNoApiKey(){
        return "";
    }
}
