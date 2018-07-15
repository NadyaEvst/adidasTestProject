package tests;

import api.apiUtils;
import org.testng.annotations.Test;

/**
 * Created by Надежда on 15.07.2018.
 */
//The structure prepared for JSON mapping allows me to easily test if I get the proper response structure.
public class ApiWeatherTest {
    @Test
    public void apiResponseByCityTest() {
        apiUtils.getWeatherByCity("Krakow");
    }

    @Test
    public void apiResponseByCityAndCountryTest() {
        apiUtils.getWeatherByCityAndCountry("Warsaw", "PL");
    }

    @Test
    public void apiResponseByCityIdTest() {
        apiUtils.getWeatherByCityId("2172797");
    }
    //TODO: can be done for calling every api method with DataProvider, for negative cases can be checked error message
}
