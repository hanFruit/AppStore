package com.chain.pro.appstore.ui.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.chain.pro.appstore.R;
import com.chain.pro.appstore.di.component.AppComponent;
import com.chain.pro.appstore.ui.adapter.FragmentAdapter;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.container)
    LinearLayout container;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private View headerView;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        headerView = navigationView.getHeaderView(0);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "头点击事件", Toast.LENGTH_SHORT).show();
            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.menu_app_update:
                        Toast.makeText(MainActivity.this, "应用更新", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.menu_download_manager:
                        Toast.makeText(MainActivity.this, "下载管理", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.menu_app_uninstall:
                        Toast.makeText(MainActivity.this, "卸载", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.menu_setting:
                        Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();

                        break;

                }
                return false;
            }
        });


        toolbar.inflateMenu(R.menu.toolbar_menu);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);


        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void setUpActivityComponent(AppComponent component) {

    }
}
