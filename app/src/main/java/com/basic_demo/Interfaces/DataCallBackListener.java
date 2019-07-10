package com.basic_demo.Interfaces;


public interface DataCallBackListener<E>{
    void onResponse(E body);
    void onError(Throwable t);
}
