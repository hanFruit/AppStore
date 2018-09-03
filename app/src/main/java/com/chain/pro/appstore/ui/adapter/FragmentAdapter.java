package com.chain.pro.appstore.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.chain.pro.appstore.bean.FragmentInfo;
import com.chain.pro.appstore.ui.fragment.CategoryFragment;
import com.chain.pro.appstore.ui.fragment.GameFragment;
import com.chain.pro.appstore.ui.fragment.RankFragment;
import com.chain.pro.appstore.ui.fragment.RecommandFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends FragmentStatePagerAdapter {

    private List<FragmentInfo> list = new ArrayList<>();

    public FragmentAdapter(FragmentManager fm) {
        super(fm);

        initFragments();
    }

    private void initFragments() {
        list.add(new FragmentInfo("推荐", RecommandFragment.class));
        list.add(new FragmentInfo("排行", RankFragment.class));
        list.add(new FragmentInfo("游戏", GameFragment.class));
        list.add(new FragmentInfo("分类", CategoryFragment.class));
    }

    @Override
    public Fragment getItem(int position) {
        try {
            return (Fragment) list.get(position).getFragment().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getTitle();
    }
}
