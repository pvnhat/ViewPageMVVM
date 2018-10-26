package com.example.vnnht.viewpagemvvm;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.vnnht.viewpagemvvm.databinding.SlideImageItemBinding;
import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends android.support.v4.view.PagerAdapter {
    private List<String> mImages;
    private Context mContext;

    public PagerAdapter(Context context) {
        mContext = context;
        mImages = new ArrayList<>();
        mImages.add("http://a9.vietbao.vn/images/vi955/2011/10/55409225-1317540817-ngoc-trinh-khoa-than--4-.jpg");
        mImages.add("http://a9.vietbao.vn/images/vi955/2011/10/55409225-1317540817-ngoc-trinh-khoa-than--4-.jpg");
        mImages.add("http://a9.vietbao.vn/images/vi955/2011/10/55409225-1317540817-ngoc-trinh-khoa-than--4-.jpg");
        mImages.add("http://a9.vietbao.vn/images/vi955/2011/10/55409225-1317540817-ngoc-trinh-khoa-than--4-.jpg");
        mImages.add("http://a9.vietbao.vn/images/vi955/2011/10/55409225-1317540817-ngoc-trinh-khoa-than--4-.jpg");

    }

    @Override
    public int getCount() {
        return mImages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        PagerAdapterViewModel pagerAdapterViewModel = new PagerAdapterViewModel();
        pagerAdapterViewModel.setData(mImages.get(position));
        SlideImageItemBinding slideImageItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(container.getContext()),
                        R.layout.slide_image_item, container, false);
        container.addView(slideImageItemBinding.getRoot());
        slideImageItemBinding.setViewModel(pagerAdapterViewModel);
        slideImageItemBinding.executePendingBindings();
        return slideImageItemBinding.getRoot();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
