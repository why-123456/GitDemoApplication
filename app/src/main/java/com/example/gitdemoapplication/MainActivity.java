package com.example.gitdemoapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import android.os.Bundle;
import android.view.Menu;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnAdd,btnSub;
    private TextView textView;
//    private int number=0;
    private MyViewModel myViewModel;
    private int myNum;
    private MutableLiveData<Integer> mutableLiveData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //和ViewModel的效果一样的
//        if (savedInstanceState!=null){
//            number=savedInstanceState.getInt("num");
//        }
        myViewModel=new ViewModelProvider(this).get(MyViewModel.class);
//        myNum=myViewModel.getNumber();
        btnAdd=findViewById(R.id.btnAdd);
        btnSub=findViewById(R.id.btnSub);
        textView=findViewById(R.id.textView);
//         mutableLiveData=new MutableLiveData<>();
         mutableLiveData=myViewModel.getmNameEvent();
//        myViewModel.setmNameEvent(mutableLiveData);
//         mutableLiveData.setValue(0);
        mutableLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
//                if (integer==null){
//                    textView.setText(0+"");
//                }else{
                    textView.setText(integer+"");
//                }
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myViewModel.add(++myNum);
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                textView.setText(String.valueOf(myViewModel.setNumber(--myNum)));
                myViewModel.add(--myNum);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.reset){
            myNum=0;
//            textView.setText(String.valueOf(myNum));
            myViewModel.reset();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

//    @Override
//    protected void onSaveInstanceState( Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt("num",number);
//    }
}