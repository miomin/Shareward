package scu.miomin.com.shareward.core;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 莫绪旻 and Stay on 2/2/16.
 */
public class ShareApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        Fresco.initialize(context);
    }
}
