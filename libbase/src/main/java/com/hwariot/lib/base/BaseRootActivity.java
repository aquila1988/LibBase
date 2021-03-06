package com.hwariot.lib.base;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.umeng.analytics.MobclickAgent;

/***
 *@date 创建时间 2018/3/22 11:07
 *@author 作者: yulong
 *@description 所有Activity的基类
 */
public class BaseRootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        enterPendingAnim();
    }

    @Override
    public void finish() {
        super.finish();
        exitPendingAnim();
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        enterPendingAnim();
    }

    public void exitPendingAnim() {
        overridePendingTransition(R.anim.anim_normal, R.anim.slide_out_right);

    }

    public void enterPendingAnim() {
        overridePendingTransition(R.anim.slide_in_right, R.anim.anim_normal);
    }




    @Override
    protected void onResume() {
        super.onResume();
        if (!isApkInDebug()){
            MobclickAgent.onResume(this);
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (!isApkInDebug()){
            MobclickAgent.onPause(this);
        }
    }


    public boolean isApkInDebug() {
        try {
            ApplicationInfo info = getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }
}

