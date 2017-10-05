package di.component;

import android.app.Application;
import android.content.Context;

import com.example.gharseldin.practiceapplication.DemoApplication;

import javax.inject.Singleton;

import dagger.Component;
import data.DataManager;
import data.DbHelper;
import data.SharedPrefsHelper;
import di.ApplicationContext;
import di.module.ApplicationModule;

/**
 * Created by Amr Gharseldin on 10/4/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(DemoApplication demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbhelper();
}
