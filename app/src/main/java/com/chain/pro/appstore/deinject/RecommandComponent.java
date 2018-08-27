package com.chain.pro.appstore.deinject;

import com.chain.pro.appstore.fragment.RecommandFragment;

import dagger.Component;


@Component(modules = RecommandModule.class)
public interface RecommandComponent {


    void inject(RecommandFragment fragment);

}
