package com.basic_demo.Interfaces;

import com.basic_demo.common.Const;
import com.basic_demo.models.Example;
import com.basic_demo.models.ExampleOld;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET(Const.Local.SUBDOMAIN)
    Call<Example> getDetails(@Query("id") String id,@Query("units") String units,@Query("appid") String appid);
}
