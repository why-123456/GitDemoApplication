package com.example.gitdemoapplication;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private int number=0;
    private MutableLiveData<Integer> mNameEvent=new MutableLiveData<>(0);
    public int getNumber() {
        return number;
    }
//    public MutableLiveData<Integer> getNameEvent() {
//        return mNameEvent;
//    }


    public MutableLiveData<Integer> getmNameEvent() {
        return mNameEvent;
    }

    public void add(int num){
//        int n=this.mNameEvent.getValue() ;
               this.mNameEvent.postValue(num);
    }
    public void reset(){
        mNameEvent.setValue(0);
    }

    public void setmNameEvent(MutableLiveData<Integer> mNameEvent) {
        this.mNameEvent = mNameEvent;
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
