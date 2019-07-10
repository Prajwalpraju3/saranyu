package com.basic_demo.NetworkManager;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.basic_demo.Interfaces.DataCallBackListener;

import java.io.IOException;

import androidx.annotation.NonNull;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class BaseManager<E> implements Callback<E> {

    private Context context;
    private static final int totalRetries = 3;
    private int retryCount = 0;

    public BaseManager(Context context) {
        this.context = context;
    }

    private DataCallBackListener<E> getDataCallBack;

    public synchronized Call<E> sendRequest(Call<E> call, DataCallBackListener<E> getDataCallBack) {
        this.getDataCallBack = getDataCallBack;
        Request request = call.request();
        Log.i(TAG, "sendRequest: url=" + request.url() + "  header=" + request.headers()+"    body="+bodyToString(request.body()));
        call.enqueue(this);
        return call;
    }


    @Override
    public void onResponse(@NonNull final Call<E> call, @NonNull Response<E> response) {
        Log.d(TAG, "onResponse=" + response.code() + "  success=" + response.isSuccessful() + "   body=" + new Gson().toJson(response.body()));
//        Log.d(TAG, "------------------------------------------------------------------------------------------------------------------");
//        Log.d(TAG, "onResponse: total" + new GsonBuilder().setPrettyPrinting().create().toJson(response));
//        Log.d(TAG, "onResponse: header" + response.headers().get("Authorization"));

        try {
//            BaseModel baseModel = (BaseModel) response.body();
//
//            if (baseModel != null) {
//                switch (baseModel.getStatus()) {
//                    case 1005:
//                        //access token expired
//                        if (context != null) {
////                                Toast.makeText(context, R.string.something_went, Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(context, TokenService.class);
//                                context.startService(intent);
//
////                                Log.v(TAG, "Retrying_token expire... (" + retryCount + " out of " + totalRetries + ")");
//                            try {
//                                new Handler().postDelayed(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        Throwable throwable=new Throwable();
//                                        getDataCallBack.onError(throwable);
//                                    }
//                                }, 5000);
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//
//
//                        }
//                        return;
//                    case 1006:
//                        //logout the user since the refresh token itself expired
//                        if (context != null) {
//                            Toast.makeText(context, baseModel.getMessage(), Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(context, AuthFailedService.class);
//                            context.startService(intent);
//
//                            /*Log.v(TAG, "Retrying_referesh_token_expire... (" + retryCount + " out of " + totalRetries + ")");
//                            call.clone().enqueue(this);*/
//                        }
//                        return;
//                }
//            }
            getDataCallBack.onResponse(response.body());

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public void onFailure(@NonNull Call<E> call, @NonNull Throwable t) {
        //error response to handle
        try {
            //Log.e(TAG, "onFailure: error=" + t.getMessage());
//            Log.e(TAG, "onFailure: error=" + t.getMessage());
            Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            getDataCallBack.onError(t);

//            if (retryCount++ < totalRetries) {
////                Log.v(TAG, "Retrying... (" + retryCount + " out of " + totalRetries + ")");
////                call.clone().enqueue(this);
////            }else {
////                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
////                getDataCallBack.onError(t);
////            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String bodyToString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }


}
