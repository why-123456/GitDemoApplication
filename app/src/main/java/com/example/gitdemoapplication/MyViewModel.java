package com.example.gitdemoapplication;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private int number=0;
    private MutableLiveData<Integer> mNameEvent=new MutableLiveData<>();
    public int getNumber() {
        return number;
    }
    public MutableLiveData<Integer> getNameEvent() {
        return mNameEvent;
    }
    public int setNumber(int number) {
        this.number = number;
        return number;
    }

    @Override
    public String toString() {
        return "MyViewModel{" +
                "number=" + number +
                '}';
    }
}
