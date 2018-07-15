package api;

import java.util.List;

/**
 * Created by Надежда on 15.07.2018.
 */
public class WeatherResponse {
    private CoordObject coord;
    private List<WeatherObject> weather;
    private String base;
    private MainObject main;
    private String visibility;
    private WindObject wind;
    private CloudsObject clouds;
    private String dt;
    private SysObject sys;
    private String id;
    private String name;
    private String cod;

    public CoordObject getCoord() {
        return coord;
    }

    public void setCoord(CoordObject coord) {
        this.coord = coord;
    }

    public List<WeatherObject> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherObject> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public MainObject getMain() {
        return main;
    }

    public void setMain(MainObject main) {
        this.main = main;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public WindObject getWind() {
        return wind;
    }

    public void setWind(WindObject wind) {
        this.wind = wind;
    }

    public CloudsObject getClouds() {
        return clouds;
    }

    public void setClouds(CloudsObject clouds) {
        this.clouds = clouds;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public SysObject getSys() {
        return sys;
    }

    public void setSys(SysObject sys) {
        this.sys = sys;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
}

