package com.basic_demo.NetworkManager;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.basic_demo.Interfaces.ApiInterface;
import com.basic_demo.Interfaces.DataCallBackListener;
import com.basic_demo.R;
import com.basic_demo.common.AppUtils;
import com.basic_demo.models.Example;
import com.basic_demo.models.ExampleOld;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;


public class DetailsManager {
    private Context context;
    private Call<Example> modelCall;
    private PreferenceManager preferenceManager;
    private final MutableLiveData<Example> data;
    private int page_count=10;
    public DetailsManager(Context context){
        this.context=context;
        preferenceManager=new PreferenceManager(context);
        data = new MutableLiveData<>();
    }

    public LiveData<Example> getDetailsModelRequest(String id) {

        if (!AppUtils.isNetworkAvailable(context)) {
            Toast.makeText(context, R.string.no_internet, Toast.LENGTH_SHORT).show();
            String dataStr=preferenceManager.getStoreData();
            if(!TextUtils.isEmpty(dataStr)){
                Example list=new Gson().fromJson(dataStr,Example.class);
                data.setValue(list);
                return data;
            }
        }

       ApiInterface storeInterface = NetworkGenerator.getAuthClient(context).create(ApiInterface.class);
        String fruitArray = "1264527,1269843,1256237,1263780,1262321";

        modelCall = storeInterface.getDetails(fruitArray,"metric","d32091b3739b5fd38c00f4b681ca4004");
        BaseManager baseManager = new BaseManager(context);
        baseManager.sendRequest(modelCall, new DataCallBackListener() {
            @Override
            public void onResponse(Object body) {
                Example list = (Example) body;

                    String response = new GsonBuilder().create().toJson(list);
                    preferenceManager.setStoreData(response);

                    data.setValue(list);

            }

            @Override
            public void onError(Throwable t) {

                Log.d("ttt", "onError: "+t.getMessage());
                data.setValue(null);
            }
        });
        return data;
    }


    public void cancelRequest() {
        modelCall.cancel();
    }
}
