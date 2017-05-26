package com.example.dell.tablerlayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

import static com.example.dell.tablerlayout.R.id.pager;

public class Main3Activity extends AppCompatActivity {

    private PagerSlidingTabStrip mTabs;
    private ViewPager mPager;
    private List<String> titles = new ArrayList<>();
    private List<Fragment> fragment = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        mTabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        mPager = (ViewPager) findViewById(pager);
        for (int i = 0; i < 4; i++) {
            BlankFragment blankFragment = new BlankFragment();
            fragment.add(blankFragment);
            titles.add("弄您死啊" + i);
        }
        viewpagerAdapter adapter = new viewpagerAdapter(getSupportFragmentManager(), fragment, titles, this);
        mPager.setAdapter(adapter);
        mTabs.setViewPager(mPager);
        PagerSlidingTabStrip.CustomTabProvider customTabProvider = new PagerSlidingTabStrip.CustomTabProvider() {
            @Override
            public View getCustomTabView(ViewGroup parent, int position) {
                LayoutInflater from = LayoutInflater.from(Main3Activity.this);
                View inflate = from.inflate(R.layout.txt, parent, false);

                return inflate;
            }

            @Override
            public void tabSelected(View tab) {
                TextView tv = (TextView) tab.findViewById(R.id.tv);
                tv.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }

            @Override
            public void tabUnselected(View tab) {
                TextView tv = (TextView) tab.findViewById(R.id.tv);
                tv.setTextColor(getResources().getColor(R.color.colorPrimary));
            }
        };
        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                .getDisplayMetrics());
        mPager.setPageMargin(pageMargin);
        mTabs.setTextColorStateListResource(R.color.colorAccent);
        mTabs.setOnTabReselectedListener(new PagerSlidingTabStrip.OnTabReselectedListener() {
            @Override
            public void onTabReselected(int position) {
            }
        });
        mPager.setCurrentItem(1);

    }
}
