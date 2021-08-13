package com.example.gitdemoapplication;

import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private int number=0;

    public int getNumber() {
        return number;
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
