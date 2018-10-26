package com.example.vnnht.Untils;

import android.databinding.BindingAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class BindingUntils {

    @BindingAdapter({ "imageUrl" })
    public static void loadImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
    }

    @BindingAdapter("onPageChangeListener")
    public static void setOnPageChangeListener(ViewPager viewPager,
            ViewPager.OnPageChangeListener listener) {
        viewPager.clearOnPageChangeListeners();
        viewPager.addOnPageChangeListener(listener);
    }

    /**
     * setAdapter For RecyclerView
     */
    @BindingAdapter({ "pagerAdapter" })
    public static void setAdapterForRecyclerView(ViewPager viewPager,
             PagerAdapter adapter) {
        viewPager.setAdapter(adapter);
    }


}
