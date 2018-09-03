package com.chain.pro.appstore.data;

import com.chain.pro.appstore.bean.AppInfo;
import com.chain.pro.appstore.bean.PageBean;
import com.chain.pro.appstore.data.http.APIService;

import retrofit2.Callback;

public class RecommandModel {


    private APIService mAPIService;

    public RecommandModel(APIService apiService) {
        this.mAPIService = apiService;
    }

    public void getRecomandList(Callback<PageBean<AppInfo>> call) {

        mAPIService.getApps("{'page':0}").enqueue(call);
    }
}
