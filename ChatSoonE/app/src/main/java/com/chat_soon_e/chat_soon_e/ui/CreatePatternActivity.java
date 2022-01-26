package com.chat_soon_e.chat_soon_e.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.chat_soon_e.chat_soon_e.R;

import java.util.List;

public class CreatePatternActivity extends AppCompatActivity {
    PatternLockView mPatternLockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pattern);

        mPatternLockView = (PatternLockView) findViewById(R.id.create_pattern_lock_view);
        mPatternLockView.addPatternLockListener(new PatternLockViewListener() {
            @Override
            public void onStarted() {
                Log.d(getClass().getName(), "Pattern drawing started");
            }

            @Override
            public void onProgress(List<PatternLockView.Dot> progressPattern) {
                Log.d(getClass().getName(), "Pattern progress: " +  PatternLockUtils.patternToString(mPatternLockView, progressPattern));
            }

            @Override
            public void onComplete(List<PatternLockView.Dot> pattern) {
                Log.d(getClass().getName(), "Pattern complete: " + PatternLockUtils.patternToString(mPatternLockView, pattern));
                SharedPreferences sharedPreferences = getSharedPreferences("lock", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("pattern", PatternLockUtils.patternToString(mPatternLockView, pattern));
                editor.apply();

                Log.d("CREATE-PATTERN", PatternLockUtils.patternToString(mPatternLockView, pattern));

                Intent intent = new Intent(getApplicationContext(), InputPatternActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onCleared() {
                Log.d(getClass().getName(), "Pattern has been cleared");
            }
        });
    }
}