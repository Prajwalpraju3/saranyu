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
private Long visibility;
@SerializedName("wind")
@Expose
private Wind wind;
@SerializedName("clouds")
@Expose
private Clouds clouds;
@SerializedName("dt")
@Expose
private Long dt;
@SerializedName("id")
@Expose
private Long id;
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

public Long getVisibility() {
return visibility;
}

public void setVisibility(Long visibility) {
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

public Long getDt() {
return dt;
}

public void setDt(Long dt) {
this.dt = dt;
}

public Long getId() {
return id;
}

public void setId(Long id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

}