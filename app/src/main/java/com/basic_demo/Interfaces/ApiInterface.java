package com.basic_demo.Interfaces;

import com.basic_demo.common.Const;
import com.basic_demo.models.ExampleOld;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {

    @GET(Const.Local.SUBDOMAIN)
    Call<List<ExampleOld>> getDetails();
}
