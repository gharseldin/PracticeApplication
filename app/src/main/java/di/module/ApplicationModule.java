package di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;
import di.ApplicationContext;
import di.DatabaseInfo;

/**
 * Created by Amr Gharseldin on 10/4/17.
 */

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application app){
        application = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext(){
        return application;
    }

    @Provides
    Application provideApplication(){
        return application;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName(){
        return "demo-dagger.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion(){
        return 2;
    }

    @Provides
    SharedPreferences provideSharedPrefs(){
        return application.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }
}
