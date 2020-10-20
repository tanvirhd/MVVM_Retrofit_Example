package com.duarbd.mvvm_retrofit_example.retrofit;

import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.POST;

public interface API_Interface {
    @POST("employees/")
    Observable<ModelObject> getEmployeeInfo();
}
