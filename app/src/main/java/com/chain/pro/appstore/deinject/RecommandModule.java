package com.chain.pro.appstore.deinject;


import android.app.ProgressDialog;

import com.chain.pro.appstore.data.RecommandModel;
import com.chain.pro.appstore.fragment.RecommandFragment;
import com.chain.pro.appstore.presenter.RecommandPresnter;
import com.chain.pro.appstore.presenter.contract.RecommandContract;

import dagger.Module;
import dagger.Provides;

@Module
public class RecommandModule {

    private RecommandContract.View mView;

    public RecommandModule(RecommandContract.View view) {
        this.mView = view;
    }


    @Provides
    public RecommandContract.View provideView() {
        return mView;
    }


    @Provides
    public RecommandContract.Presenter provideRecommandPresenter(RecommandContract.View view, RecommandModel model) {

        return new RecommandPresnter(view, model);
    }


    @Provides
    public RecommandModel provideRecommandModel() {
        return new RecommandModel();
    }


    @Provides
    public ProgressDialog provideDialog(RecommandContract.View mView) {

        return new ProgressDialog(((RecommandFragment) mView).getActivity());
    }

}
