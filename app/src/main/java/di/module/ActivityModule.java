package di.module;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import di.ActivityContext;

/**
 * Created by Amr Gharseldin on 10/4/17.
 */

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity){
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return activity;
    }

    @Provides
    Activity provideActivity(){
        return activity;
    }
}
