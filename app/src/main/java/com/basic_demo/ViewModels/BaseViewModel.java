/*Copyright © 2018, 22 Feet Tribal Worldwide Private Limited
 Written under contract by Robosoft Technologies Pvt. Ltd.*/
package com.basic_demo.ViewModels;

import android.app.Application;


import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.AndroidViewModel;


public class BaseViewModel extends AndroidViewModel implements Observable {

    private PropertyChangeRegistry mCallbacks;

    public BaseViewModel(Application application) {
        super(application);
    }

    @Override
    public void addOnPropertyChangedCallback(Observable.OnPropertyChangedCallback onPropertyChangedCallback) {
        synchronized(this){
            if(this.mCallbacks == null) {
                this.mCallbacks = new PropertyChangeRegistry();
            }
        }
        mCallbacks.add(onPropertyChangedCallback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
        synchronized(this){
            if(this.mCallbacks == null) {
                this.mCallbacks = new PropertyChangeRegistry();
            }
        }
        mCallbacks.remove(onPropertyChangedCallback);
    }


}
