package com.chain.pro.appstore.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.chain.pro.appstore.AppApplication;
import com.chain.pro.appstore.di.component.AppComponent;
import com.chain.pro.appstore.presenter.BasePresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    private Unbinder mBind;

    private AppApplication mApplication;

    @Inject
    T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        mBind = ButterKnife.bind(this);

        this.mApplication= (AppApplication) this.getApplication();

        setUpActivityComponent(mApplication.getAppComponent());

        initView();

        initData();

    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    public abstract void setUpActivityComponent(AppComponent component);


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mBind != Unbinder.EMPTY) {
            mBind.unbind();
        }
    }
}
