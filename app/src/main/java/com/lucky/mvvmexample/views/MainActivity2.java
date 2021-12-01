package com.lucky.mvvmexample.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.lucky.mvvmexample.R;
import com.lucky.mvvmexample.databinding.ActivityMain2Binding;
import com.lucky.mvvmexample.databinding.ActivityMainBinding;
import com.lucky.mvvmexample.models.Model;
import com.lucky.mvvmexample.models.Model2;
import com.lucky.mvvmexample.viewModels.Activity2ViewModel;
import com.lucky.mvvmexample.viewModels.AppViewModel;

public class MainActivity2 extends AppCompatActivity {
    Model obh=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getIntent().hasExtra("obj")){
             obh=(Model) getIntent().getSerializableExtra("obj");
        }
      ActivityMain2Binding activityMain2Binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        activityMain2Binding.setVm(new Activity2ViewModel(obh));
        activityMain2Binding.executePendingBindings();
    }
}