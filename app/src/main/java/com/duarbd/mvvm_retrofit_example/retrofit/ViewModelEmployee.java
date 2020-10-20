package com.duarbd.mvvm_retrofit_example.retrofit;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModelEmployee extends AndroidViewModel {

    private RepositoryEmployee repositoryEmployee;
    public ViewModelEmployee(@NonNull Application application) {
        super(application);
        repositoryEmployee=new RepositoryEmployee();
    }


    public LiveData<ModelObject>  getEmployeeInfo(){
        return repositoryEmployee.getEmployeeInfo();
    }
}
