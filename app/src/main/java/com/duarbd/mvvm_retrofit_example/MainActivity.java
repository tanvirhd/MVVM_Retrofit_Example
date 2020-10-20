package com.duarbd.mvvm_retrofit_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.duarbd.mvvm_retrofit_example.retrofit.ModelEmployee;
import com.duarbd.mvvm_retrofit_example.retrofit.ModelObject;
import com.duarbd.mvvm_retrofit_example.retrofit.ViewModelEmployee;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity"; //logt+tab
    ViewModelEmployee viewModelEmployee;
    List<ModelEmployee> employeelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModelEmployee=new ViewModelProvider.AndroidViewModelFactory(getApplication())
                .create(ViewModelEmployee.class);

        employeelist=new ArrayList<>();

        viewModelEmployee.getEmployeeInfo().observe(MainActivity.this, new Observer<ModelObject>() {
            @Override
            public void onChanged(ModelObject modelObject) {
                if(modelObject==null){
                    Log.d(TAG, "onChanged: got null ModelObject");
                }else {
                    Log.d(TAG, "onChanged: Employee name:"+modelObject.getEmployeeList().get(0).getEmployeeName());
                    employeelist.addAll(modelObject.getEmployeeList());
                }
            }
        });


    }
}