package com.basic_demo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExampleOld {

@SerializedName("id")
@Expose
private String id;
@SerializedName("title")
@Expose
private String title;
@SerializedName("description")
@Expose
private String description;
@SerializedName("category")
@Expose
private Category category;

boolean bigView;

    public boolean isBigView() {
        return bigView;
    }

    public void setBigView(boolean bigView) {
        this.bigView = bigView;
    }

    public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public Category getCategory() {
return category;
}

public void setCategory(Category category) {
this.category = category;
}

}