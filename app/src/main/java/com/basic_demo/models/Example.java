package com.basic_demo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Example {

@SerializedName("cnt")
@Expose
private Long cnt;
@SerializedName("list")
@Expose
private ArrayList<DataList> list = null;

public Long getCnt() {
return cnt;
}

public void setCnt(Long cnt) {
this.cnt = cnt;
}

public ArrayList<DataList> getList() {
return list;
}

public void setList(ArrayList<DataList> list) {
this.list = list;
}

}