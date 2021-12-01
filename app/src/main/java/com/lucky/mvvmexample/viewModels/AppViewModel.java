package com.lucky.mvvmexample.viewModels;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.lucky.mvvmexample.BR;
import com.lucky.mvvmexample.models.Model;
import com.lucky.mvvmexample.views.MainActivity2;

public class AppViewModel extends BaseObservable {

    // creating object of Model class
    private Model model;
    private Context context;
    // string variables for
    // toast messages
    private String successMessage = "Login successful";
    private String errorMessage = "Email or Password is not valid";

    @Bindable
    // string variable for
    // toast message
    private String toastMessage = null;

    // getter and setter methods
    // for toast message
    public String getToastMessage() {
        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    // getter and setter methods
    // for email variable
    @Bindable
    public String getUserEmail() {
        return model.getEmail();
    }

    public void setUserEmail(String email) {
        model.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    // getter and setter methods
    // for password variable
    @Bindable
    public String getUserPassword() {
        return model.getPassword();
    }

    public void setUserPassword(String password) {
        model.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    // constructor of ViewModel class
    public AppViewModel() {

        // instantiating object of
        // model class
        model = new Model("", "");
    }

    public AppViewModel(Context c) {
        this.context = c;
        // instantiating object of
        // model class
        model = new Model("", "");
    }

    // actions to be performed
    // when user clicks
    // the LOGIN button
    public void onButtonClicked() {
        if (isValid()) {
            setToastMessage(successMessage);
            Intent intent = new Intent(context, MainActivity2.class);
            intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("obj", model);
            context.startActivity(intent);
        } else
            setToastMessage(errorMessage);
    }

    // method to keep a check
    // that variable fields must
    // not be kept empty by user
    public boolean isValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches()
                && getUserPassword().length() > 5;
    }
}