package com.chain.pro.appstore.data;

import com.chain.pro.appstore.bean.AppInfo;
import com.chain.pro.appstore.bean.PageBean;
import com.chain.pro.appstore.http.APIService;
import com.chain.pro.appstore.http.HttpManager;

import retrofit2.Callback;

public class RecommandModel {


    public void getApp(Callback<PageBean<AppInfo>> callback) {

        HttpManager httpManager = new HttpManager();
        APIService apiService = httpManager.getRetrofit(httpManager.getOkHttpClient()).create(APIService.class);
        apiService.getApps("{'page':0}").enqueue(callback);

    }
}
