package com.chain.pro.appstore.presenter.contract;

import com.chain.pro.appstore.bean.AppInfo;
import com.chain.pro.appstore.presenter.BasePresenter;
import com.chain.pro.appstore.ui.BaseView;

import java.util.List;

public interface RecommandContract {

    interface View extends BaseView {

        void showResult(List<AppInfo> datas);

        void showNodata();
    }


}
