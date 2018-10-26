package com.example.vnnht.viewpagemvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.vnnht.viewpagemvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private static final int NUMBER_OF_BANNER = 5;
    private static final int MARGIN_LEFT_RIGHT_DOTS = 4;

    private LinearLayout mLinearDots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PagerAdapter pagerAdapter = new PagerAdapter(this.getApplicationContext());
        MainViewModel mainViewModel = new MainViewModel(pagerAdapter);
        ActivityMainBinding activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(mainViewModel);
        mLinearDots = activityMainBinding.linearDots;
        activityMainBinding.viewpagerBanner.setOnPageChangeListener(this);
        onCreateDots(0);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        onCreateDots(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void onCreateDots(int current_possion) {
        if (mLinearDots != null) {
            mLinearDots.removeAllViews();
        }
        ImageView[] imageDots = new ImageView[NUMBER_OF_BANNER];

        for (int i = 0; i < NUMBER_OF_BANNER; i++) {
            imageDots[i] = new ImageView(this);
            if (i == current_possion) {
                imageDots[i].setImageDrawable(
                        ContextCompat.getDrawable(this, R.drawable.active_dots));
            } else {
                imageDots[i].setImageDrawable(
                        ContextCompat.getDrawable(this, R.drawable.unactive_dots));
            }
            LinearLayout.LayoutParams layoutParams =
                    new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(MARGIN_LEFT_RIGHT_DOTS, 0, MARGIN_LEFT_RIGHT_DOTS, 0);
            mLinearDots.addView(imageDots[i], layoutParams);
        }
    }
}
