package com.duarbd.mvvm_retrofit_example.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelObject {

    @SerializedName("status")
    @Expose
    String status;

    @SerializedName("data")
    @Expose
    List<ModelEmployee> employeeList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ModelEmployee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<ModelEmployee> employeeList) {
        this.employeeList = employeeList;
    }
}
