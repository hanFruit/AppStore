package com.chain.pro.appstore.ui.fragment;

import android.app.ProgressDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chain.pro.appstore.R;
import com.chain.pro.appstore.bean.AppInfo;
import com.chain.pro.appstore.di.component.AppComponent;
import com.chain.pro.appstore.di.component.DaggerRecommandComponent;
import com.chain.pro.appstore.di.module.RecommandModule;
import com.chain.pro.appstore.presenter.RecommandPresnter;
import com.chain.pro.appstore.presenter.contract.RecommandContract;
import com.chain.pro.appstore.ui.adapter.RecomendAppAdatper;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class RecommandFragment extends BaseFragment<RecommandPresnter> implements RecommandContract.View {

    @BindView(R.id.recyleview)
    RecyclerView recyleview;

    private RecomendAppAdatper mAdapter;

    @Inject
    ProgressDialog mProgressDialog;



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommand;
    }

    @Override
    protected void init() {
        mPresenter.requestData();
    }


    @Override
    public void setUpActivityComponent(AppComponent component) {
        DaggerRecommandComponent.builder()
                .appComponent(component)
                .recommandModule(new RecommandModule(this))
                .build().inject(this);
    }

    private void initRecleView(List<AppInfo> list) {

        recyleview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyleview.setItemAnimator(new DefaultItemAnimator());
        recyleview.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));

        mAdapter = new RecomendAppAdatper(getActivity(), list);
        recyleview.setAdapter(mAdapter);
    }



    @Override
    public void showResult(List<AppInfo> datas) {
        initRecleView(datas);
    }

    @Override
    public void showNodata() {

    }

    @Override
    public void showLoading() {
        mProgressDialog.show();
    }

    @Override
    public void dismisLoading() {
        mProgressDialog.dismiss();
    }
}
