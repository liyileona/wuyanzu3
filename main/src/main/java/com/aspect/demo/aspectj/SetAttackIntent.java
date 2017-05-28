package com.aspect.demo.aspectj;

import android.app.Activity;
import android.content.Intent;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by ger on 2017/5/22.
 */
@Aspect
public class SetAttackIntent {
    private Intent AttackIntent;

    @Pointcut("execution(* com.google.android.apps.muzei.MuzeiActivity.onCreate*(..))")
    public void SetIntentPoint() {}
    @Pointcut("execution(* com.google.android.apps.muzei.MuzeiActivity.onEventMainThread*(..))")
    public void SendIntentPoint() {}

    @After("SetIntentPoint()")
    public void SetIntent() {
        AttackIntent = new Intent("com.google.android.apps.muzei.MuzeiActivity");
        AttackIntent.setAction(Intent.ACTION_MAIN);
        AttackIntent.addCategory(Intent.CATEGORY_LAUNCHER);

        return;
    }

    @Before("SendIntentPoint()")
    public void SendIntent() {
        Activity attack = new Activity();
        //attack.startActivity(AttackIntent);
        return;
    }

}
