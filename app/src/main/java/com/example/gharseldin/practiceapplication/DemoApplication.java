package com.example.gharseldin.practiceapplication;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import data.DataManager;
import di.component.ApplicationComponent;
import di.component.DaggerApplicationComponent;
import di.module.ApplicationModule;

/**
 * Created by Amr Gharseldin on 10/4/17.
 */

public class DemoApplication extends Application {

    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    public static DemoApplication get(Context context){
        return (DemoApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate(){
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                                    .builder()
                                    .applicationModule(new ApplicationModule(this))
                                    .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }

}
