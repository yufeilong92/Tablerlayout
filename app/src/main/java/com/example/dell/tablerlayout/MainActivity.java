package com.example.dell.tablerlayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tablayout;
    private ViewPager viewpager;
    private List<String> titles=new ArrayList<>();
    private List<Fragment> fragment=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {
        for (int i = 0; i < 4; i++) {
            BlankFragment blankFragment = new BlankFragment();
            fragment.add(blankFragment);
            titles.add("弄您死啊"+i);
        }
        viewpagerAdapter viewpagerAdapter = new viewpagerAdapter(getSupportFragmentManager(), fragment, titles, this);
        viewpager.setAdapter(viewpagerAdapter);
         tablayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimaryDark));
        tablayout.setWillNotDraw(true);
        tablayout.setupWithViewPager(viewpager);
    }

    private void initView() {
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
    }
}
