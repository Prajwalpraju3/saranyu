package com.basic_demo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataList {

@SerializedName("coord")
@Expose
private Coord coord;
@SerializedName("sys")
@Expose
private Sys sys;
@SerializedName("weather")
@Expose
private ArrayList<Weather> weather = null;
@SerializedName("main")
@Expose
private Main main;
@SerializedName("visibility")
@Expose
private String visibility;
@SerializedName("wind")
@Expose
private Wind wind;
@SerializedName("clouds")
@Expose
private Clouds clouds;
@SerializedName("dt")
@Expose
private String dt;
@SerializedName("id")
@Expose
private String id;
@SerializedName("name")
@Expose
private String name;

public Coord getCoord() {
return coord;
}

public void setCoord(Coord coord) {
this.coord = coord;
}

public Sys getSys() {
return sys;
}

public void setSys(Sys sys) {
this.sys = sys;
}

public ArrayList<Weather> getWeather() {
return weather;
}

public void setWeather(ArrayList<Weather> weather) {
this.weather = weather;
}

public Main getMain() {
return main;
}

public void setMain(Main main) {
this.main = main;
}

public String getVisibility() {
return visibility;
}

public void setVisibility(String visibility) {
this.visibility = visibility;
}

public Wind getWind() {
return wind;
}

public void setWind(Wind wind) {
this.wind = wind;
}

public Clouds getClouds() {
return clouds;
}

public void setClouds(Clouds clouds) {
this.clouds = clouds;
}

public String getDt() {
return dt;
}

public void setDt(String dt) {
this.dt = dt;
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

}