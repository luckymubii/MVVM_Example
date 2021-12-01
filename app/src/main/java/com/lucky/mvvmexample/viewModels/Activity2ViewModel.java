package com.lucky.mvvmexample.viewModels;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.lucky.mvvmexample.BR;
import com.lucky.mvvmexample.models.Model;
import com.lucky.mvvmexample.models.Model2;

public class Activity2ViewModel extends BaseObservable {
    private Model2 obj;
    public Activity2ViewModel(){
        obj=new Model2("","");
    }
    public Activity2ViewModel(Model e){
        obj=new Model2(e.getEmail(),e.getPassword());
    }
    public void setE(String e){
        obj.setEmail(e);
        notifyPropertyChanged(BR.e);
    }
    @Bindable
    public String getE(){
        return  obj.getEmail();
    }
    public void setP(String e){
        obj.setPassword(e);
        notifyPropertyChanged(BR.p);
    }
    @Bindable
    public String getP(){
        return  obj.getPassword();
    }
}
