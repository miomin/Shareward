package scu.miomin.com.shareward.core;


import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import scu.miomin.com.shareward.constants.APPStatu;


/**
 * Created by 莫绪旻 and Stay on 4/2/2016.
 */
public class AppStatusTracker implements Application.ActivityLifecycleCallbacks {

    /**
     * tracker实例
     */
    private static AppStatusTracker tracker;

    /**
     * APP的启动模式状态
     */
    private int mAppStatus = APPStatu.STATUS_FORCE_KILLED;

    /**
     * 判断APP是否在前台
     */
    private boolean isForground;

    /**
     * 用于管理所有的Activity
     */
    private List<Activity> activities = new ArrayList<Activity>();

    /**
     * 记录处于前台状态的activity数量
     */
    private int aliveActivityCount = 0;

    /**
     * 应用进入后台的时间
     */
    private long deathtime;
    private AppController appController;

    private Application application;

    private AppStatusTracker(Application application) {
        this.application = application;
        application.registerActivityLifecycleCallbacks(this);
    }

    /**
     * 通过单例模式获取AppStatusTracker
     * @param application
     * @return
     */
    public static AppStatusTracker getInstance(Application application) {
        if (tracker == null) {
            tracker = new AppStatusTracker(application);
        }
        return tracker;
    }

    public void setAppStatus(int status) {
        this.mAppStatus = status;
    }

    public int getAppStatus() {
        return this.mAppStatus;
    }

    public boolean isForground() {
        return isForground;
    }

    /**
     * 添加一个activity实例
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * 删除一个activity实例
     */
    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * 关闭所有activity
     */
    public void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    /**
     * 获取应用进入后台的总时间
     */
    public long getDeathTime() {
        return deathtime;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {
        aliveActivityCount++;
    }

    /**
     * 界面快要显示的时候被调用
     */
    @Override
    public void onActivityResumed(Activity activity) {
        isForground = true;
        deathtime = 0l;
    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        aliveActivityCount--;
        // 如果处于前台的activity的数量==0，表明APP在后台运行
        if (aliveActivityCount == 0) {
            isForground = false;
            deathtime = System.currentTimeMillis();
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    public void registerAppController(AppController appController) {
        this.appController = appController;
    }

    public void protectApp(Context context) {
        appController.protectApp(context);
    }
}
