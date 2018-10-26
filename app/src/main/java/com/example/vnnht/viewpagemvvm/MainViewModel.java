package com.example.vnnht.viewpagemvvm;

import android.support.v4.view.ViewPager;

public class MainViewModel{

    private PagerAdapter mAdapter;

    public MainViewModel(PagerAdapter adapter) {
        mAdapter = adapter;
    }

    public PagerAdapter getPagerAdapter() {
        return mAdapter;
    }
}
