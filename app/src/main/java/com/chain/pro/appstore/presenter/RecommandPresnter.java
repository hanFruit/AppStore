package com.chain.pro.appstore.presenter;

import com.chain.pro.appstore.bean.AppInfo;
import com.chain.pro.appstore.bean.PageBean;
import com.chain.pro.appstore.data.RecommandModel;
import com.chain.pro.appstore.presenter.contract.RecommandContract;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecommandPresnter extends BasePresenter<RecommandModel, RecommandContract.View> {


    @Inject
    public RecommandPresnter(RecommandModel model, RecommandContract.View view) {
        super(model, view);

    }


    public void requestData() {

        mView.showLoading();

        mModel.getRecomandList(new Callback<PageBean<AppInfo>>() {
            @Override
            public void onResponse(Call<PageBean<AppInfo>> call, Response<PageBean<AppInfo>> response) {
                if (response != null) {

                    mView.showResult(response.body().getDatas());
                } else {
                    mView.showNodata();
                }

                mView.dismisLoading();
            }

            @Override
            public void onFailure(Call<PageBean<AppInfo>> call, Throwable t) {
                mView.dismisLoading();
            }
        });
    }
}
