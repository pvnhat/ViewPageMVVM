package com.example.vnnht.viewpagemvvm;

import android.databinding.ObservableField;

public class PagerAdapterViewModel {
    public ObservableField<String> mStudentObservableField = new ObservableField<>();

    public String getImageUrl() {
        return mStudentObservableField.get();
    }

    public void setData(String imageLink) {
        mStudentObservableField.set(imageLink);
    }
}
