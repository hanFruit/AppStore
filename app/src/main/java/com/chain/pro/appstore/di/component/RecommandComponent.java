package com.chain.pro.appstore.di.component;


import com.chain.pro.appstore.di.FragmentScope;
import com.chain.pro.appstore.di.module.RecommandModule;
import com.chain.pro.appstore.ui.fragment.RecommandFragment;

import dagger.Component;
@FragmentScope
@Component(modules = RecommandModule.class,dependencies = AppComponent.class)
public interface RecommandComponent {
    void inject(RecommandFragment fragment);
}
