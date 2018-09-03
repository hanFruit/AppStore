package com.chain.pro.appstore.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chain.pro.appstore.AppApplication;
import com.chain.pro.appstore.R;
import com.chain.pro.appstore.bean.AppInfo;
import com.chain.pro.appstore.di.component.DaggerAppComponent;
import com.chain.pro.appstore.di.component.DaggerRecommandComponent;
import com.chain.pro.appstore.di.module.RecommandModule;
import com.chain.pro.appstore.presenter.RecommandPresnter;
import com.chain.pro.appstore.presenter.contract.RecommandContract;
import com.chain.pro.appstore.ui.adapter.RecomendAppAdatper;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RecommandFragment extends Fragment implements RecommandContract.View {

    @BindView(R.id.recyleview)
    RecyclerView recyleview;
    Unbinder unbinder;

    private RecomendAppAdatper mAdapter;

    @Inject
    ProgressDialog mProgressDialog;
    @Inject
    RecommandPresnter mPresnter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommand, container, false);
        unbinder = ButterKnife.bind(this, view);


        DaggerRecommandComponent.builder()
                .appComponent(((AppApplication) (getActivity().getApplication())).getAppComponent())
                .recommandModule(new RecommandModule(this))
                .build().inject(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();
    }


    private void initData() {

        mPresnter.requestData();
    }

    private void initRecleView(List<AppInfo> list) {

        recyleview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyleview.setItemAnimator(new DefaultItemAnimator());
        recyleview.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));

        mAdapter = new RecomendAppAdatper(getActivity(), list);
        recyleview.setAdapter(mAdapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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
