package data;

import android.content.Context;
import android.content.res.Resources;

import javax.inject.Inject;
import javax.inject.Singleton;

import data.model.User;
import di.ApplicationContext;

/**
 * Created by Amr Gharseldin on 10/4/17.
 */

@Singleton
public class DataManager {

    private Context context;
    private DbHelper dbHelper;
    private SharedPrefsHelper sharedPrefsHelper;

    @Inject
    public DataManager(@ApplicationContext Context context,
                       DbHelper dbHelper,
                       SharedPrefsHelper sharedPrefsHelper){
        this.context = context;
        this.dbHelper = dbHelper;
        this.sharedPrefsHelper = sharedPrefsHelper;
    }

    public void saveAccessToken(String accessToken){
        sharedPrefsHelper.put(sharedPrefsHelper.PREF_KEY_ACCESSS_TOKEN, accessToken);
    }

    public String getAccessToken(){
        return sharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESSS_TOKEN, null);
    }

    public Long createUser(User user) throws Exception {
        return dbHelper.insertUser(user);
    }

    public User getUser(Long userId) throws Resources.NotFoundException, NullPointerException{
        return dbHelper.getUser(userId);
    }
}
