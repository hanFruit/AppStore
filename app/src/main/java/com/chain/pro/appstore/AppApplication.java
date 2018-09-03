package com.chain.pro.appstore;

import android.app.Application;
import android.content.Context;

import com.chain.pro.appstore.di.component.AppComponent;
import com.chain.pro.appstore.di.component.DaggerAppComponent;
import com.chain.pro.appstore.di.module.AppModule;
import com.chain.pro.appstore.di.module.HttpModule;

public class AppApplication extends Application {


    public static AppApplication getApplication(Context context){
        return (AppApplication) context.getApplicationContext();
    }


    private AppComponent mAppComponent;

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();


        mAppComponent= DaggerAppComponent.builder().appModule(new AppModule(this))
                .httpModule(new HttpModule()).build();
    }
}
