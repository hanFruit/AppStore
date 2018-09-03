package com.chain.pro.appstore.di.component;


import com.chain.pro.appstore.data.http.APIService;
import com.chain.pro.appstore.di.module.AppModule;
import com.chain.pro.appstore.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

     APIService getApiService();
}
