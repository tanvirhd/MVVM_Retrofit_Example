package com.duarbd.mvvm_retrofit_example.retrofit;

import android.graphics.ColorSpace;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RepositoryEmployee {
    private static final String TAG = "RepositoryEmployee";
     private API_Interface apiInterface;

    public RepositoryEmployee() {
        apiInterface=APIClient.getAPIinterface();
    }

    public LiveData<ModelObject> getEmployeeInfo(){
        MutableLiveData<ModelObject> response=new MutableLiveData<>();

        apiInterface.getEmployeeInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ModelObject>() {
                    @Override
                    public void accept(ModelObject modelObject) throws Exception {
                        response.postValue(modelObject);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "accept: error:"+throwable.getMessage());
                    }
                });

        return response;
    }

}
