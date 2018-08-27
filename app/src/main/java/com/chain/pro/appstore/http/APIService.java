package com.chain.pro.appstore.http;

import com.chain.pro.appstore.bean.AppInfo;
import com.chain.pro.appstore.bean.PageBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    String BASE_URL = "http://112.124.22.238:8081/course_api/cniaoplay/";


    @GET("featured")
    Call<PageBean<AppInfo>> getApps(@Query("p") String jsonParam);
}
