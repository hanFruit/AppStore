package com.chain.pro.appstore.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chain.pro.appstore.R;
import com.chain.pro.appstore.bean.AppInfo;
import com.chain.pro.appstore.bean.PageBean;
import com.chain.pro.appstore.deinject.DaggerRecommandComponent;
import com.chain.pro.appstore.deinject.RecommandModule;
import com.chain.pro.appstore.http.APIService;
import com.chain.pro.appstore.http.HttpManager;
import com.chain.pro.appstore.presenter.RecommandPresnter;
import com.chain.pro.appstore.presenter.contract.RecommandContract;
import com.chain.pro.appstore.ui.adapter.RecomendAppAdatper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecommandFragment extends Fragment implements RecommandContract.View {

    @BindView(R.id.recyleview)
    RecyclerView recyleview;
    Unbinder unbinder;

    private RecomendAppAdatper mAdapter;
    private List<AppInfo> mList = new ArrayList<>();


    @Inject
    ProgressDialog mProgressDialog;

    @Inject
    RecommandContract.Presenter presnter;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recommand, container, false);
        unbinder = ButterKnife.bind(this, view);

        DaggerRecommandComponent.builder()
                .recommandModule(new RecommandModule(this)).build().inject(this);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();
    }


    private void initData() {

        presnter.requestData();
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
    public void showResult(List<AppInfo> list) {
        initRecleView(list);
    }

    @Override
    public void showError(String msg) {

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
