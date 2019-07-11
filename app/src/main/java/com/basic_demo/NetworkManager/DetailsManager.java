package com.basic_demo.NetworkManager;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.basic_demo.Interfaces.ApiInterface;
import com.basic_demo.Interfaces.DataCallBackListener;
import com.basic_demo.R;
import com.basic_demo.common.AppUtils;
import com.basic_demo.models.ExampleOld;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;


public class DetailsManager {
    private Context context;
    private Call<List<ExampleOld>> modelCall;
    private PreferenceManager preferenceManager;
    private final MutableLiveData<List<ExampleOld>> data;
    private int page_count=10;
    public DetailsManager(Context context){
        this.context=context;
        preferenceManager=new PreferenceManager(context);
        data = new MutableLiveData<>();
    }

    public LiveData<List<ExampleOld>> getDetailsModelRequest(String id) {

        if (!AppUtils.isNetworkAvailable(context)) {
            Toast.makeText(context, R.string.no_internet, Toast.LENGTH_SHORT).show();
            return data;
        }

       ApiInterface storeInterface = NetworkGenerator.getAuthClient(context).create(ApiInterface.class);
        modelCall = storeInterface.getDetails();
        BaseManager baseManager = new BaseManager(context);
        baseManager.sendRequest(modelCall, new DataCallBackListener() {
            @Override
            public void onResponse(Object body) {
                    List<ExampleOld> list = (List<ExampleOld>) body;
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
