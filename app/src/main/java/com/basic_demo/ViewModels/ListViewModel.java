package com.basic_demo.ViewModels;

import android.app.Application;

import com.basic_demo.NetworkManager.DetailsManager;
import com.basic_demo.models.ExampleOld;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


public class ListViewModel extends BaseViewModel {

    private LiveData<List<ExampleOld>> liveData;
    private ObservableField<List<ExampleOld>> observableField = new ObservableField<>();
    private DetailsManager detailsManager;
    private ListViewModel(Application application, String id){
        super(application);
        detailsManager = new DetailsManager(application);
        callNextPageResult(id);
    }

    private void callNextPageResult(String id){
        this.liveData= detailsManager.getDetailsModelRequest(id);
    }


    public LiveData<List<ExampleOld>> getObservable() {
        return liveData;
    }


    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application application;

        private final String id;

        public Factory(@NonNull Application application, String id) {
            this.application = application;
            this.id = id;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            return (T) new ListViewModel(application,id);
        }
    }

}
