package com.example.dell.tablerlayout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;

import java.util.List;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: Tablerlayout
 * @Package com.example.dell.tablerlayout
 * @Description: $todo$
 * @author: YFL
 * @date: 2017/5/25 19:49
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2017 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */


public class viewpagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mData;
    private List<String> mTitles;
    private Context mContext;

    public viewpagerAdapter(FragmentManager fm, List<Fragment> mData, List<String> mTitles, Context mContext) {
        super(fm);
        this.mData = mData;
        this.mTitles = mTitles;
        this.mContext = mContext;
    }

    public viewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public CharSequence getPageTitle(int pos) {
        SpannableStringBuilder ssb = new SpannableStringBuilder(" "
                + mTitles.get(pos)); // space added before text for
        Drawable myDrawable = mContext.getResources().getDrawable(
                R.drawable.card_visited_like);
        myDrawable.setBounds(0, 0, myDrawable.getIntrinsicWidth(),
                myDrawable.getIntrinsicHeight());
        ImageSpan span = new ImageSpan(myDrawable, ImageSpan.ALIGN_BASELINE);

        ForegroundColorSpan fcs = new ForegroundColorSpan(Color.GREEN);//字体颜色设置为绿色
        ssb.setSpan(span, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);//设置图标
        ssb.setSpan(fcs, 1, ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);//设置字体颜色
        ssb.setSpan(new RelativeSizeSpan(1.2f), 1, ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }
}
