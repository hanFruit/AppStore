package com.chain.pro.appstore.di.module;


import android.app.ProgressDialog;

import com.chain.pro.appstore.data.RecommandModel;
import com.chain.pro.appstore.data.http.APIService;
import com.chain.pro.appstore.presenter.RecommandPresnter;
import com.chain.pro.appstore.presenter.contract.RecommandContract;
import com.chain.pro.appstore.ui.fragment.RecommandFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class RecommandModule {

    private RecommandContract.View mView;

    public RecommandModule(RecommandContract.View view) {
        mView = view;
    }

    @Provides
    public RecommandContract.View provideView() {
        return mView;
    }


    @Provides
    public RecommandPresnter provideRecommandPresnter(RecommandContract.View view, RecommandModel model) {

        return new RecommandPresnter(view, model);
    }

    @Provides
    public RecommandModel provideRecommandModel(APIService apiService) {

        return new RecommandModel(apiService);
    }


    @Provides
    public ProgressDialog provideProgressDialog(RecommandContract.View view) {

        return new ProgressDialog(((RecommandFragment) view).getActivity());
    }




}
