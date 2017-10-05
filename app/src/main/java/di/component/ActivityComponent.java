package di.component;

import com.example.gharseldin.practiceapplication.MainActivity;

import dagger.Component;
import di.PerActivity;
import di.module.ActivityModule;

/**
 * Created by Amr Gharseldin on 10/4/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}
