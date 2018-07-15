package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;


/**
 * Created by Надежда on 15.07.2018.
 */
public class apiUtils {
    final static String APPID = "&APPID=e87d9935a4d97a763869d9e576429c62";

    public static String getResult(String url) {
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));
        try {
            int statusCode = client.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + method.getStatusLine());
            }
            byte[] responseBody = method.getResponseBody();
            String result = new String(responseBody);
            return result;

        } catch (HttpException e) {
            System.err.println("Fatal protocol violation: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Fatal transport error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
        return null;
    }

    public static WeatherResponse parseResponse(String result) {
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse response = new WeatherResponse();
        try {
            response = mapper.readValue(result, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static WeatherResponse getWeatherByCity(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + APPID;
        return parseResponse(getResult(url));
    }

    public static WeatherResponse getWeatherByCityAndCountry(String city, String country) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country + APPID;
        return parseResponse(getResult(url));
    }

    public static WeatherResponse getWeatherByCityId(String cityId) {
        String url = "https://api.openweathermap.org/data/2.5/weather?id=" + cityId + APPID;
        return parseResponse(getResult(url));
    }
}
