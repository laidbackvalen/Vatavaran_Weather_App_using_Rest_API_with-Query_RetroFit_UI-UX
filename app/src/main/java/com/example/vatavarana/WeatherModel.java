// WeatherModel.java


package com.example.vatavarana;
import java.util.List;

public class WeatherModel {
    private long visibility;
    private long timezone;
    private Main main;
    private Clouds clouds;
    private Sys sys;
    private long dt;
    private Coord coord;
    private List<Weather> weather;
    private String name;
    private long cod;
    private long id;
    private String base;
    private Wind wind;

    public long getVisibility() { return visibility; }
    public void setVisibility(long value) { this.visibility = value; }

    public long getTimezone() { return timezone; }
    public void setTimezone(long value) { this.timezone = value; }

    public Main getMain() { return main; }
    public void setMain(Main value) { this.main = value; }

    public Clouds getClouds() { return clouds; }
    public void setClouds(Clouds value) { this.clouds = value; }

    public Sys getSys() { return sys; }
    public void setSys(Sys value) { this.sys = value; }

    public long getDt() { return dt; }
    public void setDt(long value) { this.dt = value; }

    public Coord getCoord() { return coord; }
    public void setCoord(Coord value) { this.coord = value; }

    public List<Weather> getWeather() { return weather; }
    public void setWeather(List<Weather> value) { this.weather = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public long getCod() { return cod; }
    public void setCod(long value) { this.cod = value; }

    public long getid() { return id; }
    public void setid(long value) { this.id = value; }

    public String getBase() { return base; }
    public void setBase(String value) { this.base = value; }

    public Wind getWind() { return wind; }
    public void setWind(Wind value) { this.wind = value; }
}

// Clouds.java


class Clouds {
    private long all;

    public long getAll() { return all; }
    public void setAll(long value) { this.all = value; }
}

// Coord.java


class Coord {
    private double lon;
    private double lat;

    public double getLon() { return lon; }
    public void setLon(double value) { this.lon = value; }

    public double getLat() { return lat; }
    public void setLat(double value) { this.lat = value; }
}

// Main.java


class Main {
    private double temp;
    private double tempMin;
    private long grndLevel;
    private long humidity;
    private long pressure;
    private long seaLevel;
    private double feelsLike;
    private double tempMax;

    public double getTemp() { return temp; }
    public void setTemp(double value) { this.temp = value; }

    public double getTempMin() { return tempMin; }
    public void setTempMin(double value) { this.tempMin = value; }

    public long getGrndLevel() { return grndLevel; }
    public void setGrndLevel(long value) { this.grndLevel = value; }

    public long getHumidity() { return humidity; }
    public void setHumidity(long value) { this.humidity = value; }

    public long getPressure() { return pressure; }
    public void setPressure(long value) { this.pressure = value; }

    public long getSeaLevel() { return seaLevel; }
    public void setSeaLevel(long value) { this.seaLevel = value; }

    public double getFeelsLike() { return feelsLike; }
    public void setFeelsLike(double value) { this.feelsLike = value; }

    public double getTempMax() { return tempMax; }
    public void setTempMax(double value) { this.tempMax = value; }
}

// Sys.java


class Sys {
    private String country;
    private long sunrise;
    private long sunset;

    public String getCountry() { return country; }
    public void setCountry(String value) { this.country = value; }

    public long getSunrise() { return sunrise; }
    public void setSunrise(long value) { this.sunrise = value; }

    public long getSunset() { return sunset; }
    public void setSunset(long value) { this.sunset = value; }
}

// Weather.java

class Weather {
    private String icon;
    private String description;
    private String main;
    private long id;

    public String getIcon() { return icon; }
    public void setIcon(String value) { this.icon = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public String getMain() { return main; }
    public void setMain(String value) { this.main = value; }

    public long getid() { return id; }
    public void setid(long value) { this.id = value; }
}

// Wind.java


class Wind {
    private long deg;
    private double speed;
    private double gust;

    public long getDeg() { return deg; }
    public void setDeg(long value) { this.deg = value; }

    public double getSpeed() { return speed; }
    public void setSpeed(double value) { this.speed = value; }

    public double getGust() { return gust; }
    public void setGust(double value) { this.gust = value; }
}
