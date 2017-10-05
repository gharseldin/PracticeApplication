package com.example.gharseldin.practiceapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import data.DataManager;
import data.model.User;
import di.component.ActivityComponent;
import di.component.DaggerActivityComponent;
import di.module.ActivityModule;

public class MainActivity extends AppCompatActivity {

    @Inject
    DataManager dataManager;

    private ActivityComponent activityComponent;

    private TextView tVUserInfo;
    private TextView tVAccessToken;

    public ActivityComponent getActivityComponent(){
        if(activityComponent == null){
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(DemoApplication.get(this).getComponent())
                    .build();
        }

        return activityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        tVUserInfo = (TextView) findViewById(R.id.tv_user_info);
        tVAccessToken = (TextView) findViewById(R.id.tv_access_token);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        createUser();
        getUser();
        dataManager.saveAccessToken("THIS SHOULD BE SOME LONG RANDOM STRING");

        String token = dataManager.getAccessToken();
        if(token != null){
            tVAccessToken.setText(token);
        }
    }

    private void createUser(){
        try{
            dataManager.createUser(new User("Amr", "Somewhere in the world"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void getUser(){
        try{
            User user = dataManager.getUser(1L);
            tVUserInfo.setText(user.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
