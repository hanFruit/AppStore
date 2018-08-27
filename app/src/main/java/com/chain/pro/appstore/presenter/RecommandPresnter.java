package com.chain.pro.appstore.presenter;

import com.chain.pro.appstore.bean.AppInfo;
import com.chain.pro.appstore.bean.PageBean;
import com.chain.pro.appstore.data.RecommandModel;
import com.chain.pro.appstore.presenter.contract.RecommandContract;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecommandPresnter implements RecommandContract.Presenter {


    private RecommandModel model;

    private RecommandContract.View view;

    public RecommandPresnter(RecommandContract.View view, RecommandModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void requestData() {

        view.showLoading();

        model.getApp(new Callback<PageBean<AppInfo>>() {
            @Override
            public void onResponse(Call<PageBean<AppInfo>> call, Response<PageBean<AppInfo>> response) {
                if (response.body() != null) {
                    view.showResult(response.body().getDatas());
                } else {
                    view.showError("error");
                }

                view.dismisLoading();
            }

            @Override
            public void onFailure(Call<PageBean<AppInfo>> call, Throwable t) {

                view.dismisLoading();
                view.showError(t.getMessage());
            }
        });
    }
}
