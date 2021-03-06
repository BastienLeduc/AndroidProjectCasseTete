package com.bldc.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartBoot extends Activity {

    private static final int INTERVAL_COUNTDOWN_TICK = 2000;
    private static final int INTERVAL_COUNTDOWN_TIMER = 2000;

    /***
     * Activty display during 2000 tick at start
     */
    private class TimerBoot extends CountDownTimer {
        public TimerBoot(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            finish();
            final Intent homeActivityIntent = new Intent(StartBoot.this,
                    MenuActivity.class);
            startActivity(homeActivityIntent);
        }

        @Override
        public void onTick(long millisUntilFinished) {
        }
    }

    /***
     * Creation of timer
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_boot);

        final CountDownTimer timer = new TimerBoot(INTERVAL_COUNTDOWN_TIMER,
                INTERVAL_COUNTDOWN_TICK);
        timer.start();
    }
}
