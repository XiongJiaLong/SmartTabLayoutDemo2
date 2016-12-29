package com.example.administrator.smarttablayoutdemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    ViewPager mViewPager;
    SmartTabLayout tabLayout;
    ImageView imageView;
    ImageView imageView2;
    FragmentPagerItems.Creator creator;
    FragmentPagerItemAdapter fragmentPagerItemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
        tabLayout = (SmartTabLayout) findViewById(R.id.mSmartTabLayout);
        imageView = (ImageView) findViewById(R.id.mLeftImg);
        imageView2 = (ImageView) findViewById(R.id.mSearch);
        imageView.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        initViewPager();
        initTab();
    }

    private void initViewPager(){
        creator = FragmentPagerItems.with(this);
        creator.add("品类",TitleOneFragment.class);
        creator.add("品牌",TitleTwoFragment.class);
        creator.add("动态",TitleOneFragment.class);
        FragmentPagerItems fragmentPagerItems = creator.create();
        fragmentPagerItemAdapter =
                new FragmentPagerItemAdapter(getSupportFragmentManager(),fragmentPagerItems);
        mViewPager.setAdapter(fragmentPagerItemAdapter);
    }

    private void initTab(){
        tabLayout.setViewPager(mViewPager);
        tabLayout.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.e("=========","======onPageScrolled=="+position);

    }

    @Override
    public void onPageSelected(int position) {
        Log.e("=========","======onPageSelected=="+position);
        Toast.makeText(this,position+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.e("=========","======onPageScrollStateChanged=="+state);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mLeftImg:
                Toast.makeText(MainActivity.this,"左边的图片",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mSearch:
                Toast.makeText(MainActivity.this,"右边的图片",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
