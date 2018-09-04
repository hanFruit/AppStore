package com.chain.pro.appstore.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chain.pro.appstore.AppApplication;
import com.chain.pro.appstore.di.component.AppComponent;
import com.chain.pro.appstore.presenter.BasePresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    private AppApplication mApplication;

    private Unbinder mBind;

    private View mRootView;

    @Inject
    T mPresenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(getLayoutId(), container, false);
        mBind = ButterKnife.bind(this, mRootView);

        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.mApplication = (AppApplication) getActivity().getApplication();

        setUpActivityComponent(mApplication.getAppComponent());

        init();
    }

    protected abstract int getLayoutId();

    protected abstract void init();


    public abstract void setUpActivityComponent(AppComponent component);


    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mBind != Unbinder.EMPTY) {
            mBind.unbind();
        }
    }
}
