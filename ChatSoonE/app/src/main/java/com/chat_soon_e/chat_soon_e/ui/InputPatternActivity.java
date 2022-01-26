package com.chat_soon_e.chat_soon_e.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.chat_soon_e.chat_soon_e.R;

import java.util.List;

public class InputPatternActivity extends AppCompatActivity {
    PatternLockView mPatternLockView;
    String patternValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_pattern);

        SharedPreferences preferences = getSharedPreferences("lock", 0);
        patternValue = preferences.getString("pattern", "0");
        Log.d("INPUT-PATTERN", patternValue);

        mPatternLockView = (PatternLockView) findViewById(R.id.input_pattern_lock_view);
        mPatternLockView.addPatternLockListener(new PatternLockViewListener() {
            @Override
            public void onStarted() {

            }

            @Override
            public void onProgress(List<PatternLockView.Dot> progressPattern) {

            }

            @Override
            public void onComplete(List<PatternLockView.Dot> pattern) {
                if(patternValue.equals(PatternLockUtils.patternToString(mPatternLockView, pattern))) {
                    Intent intent = new Intent(getApplicationContext(), HiddenFolderActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(InputPatternActivity.this, "잘못된 패턴입니다.", Toast.LENGTH_SHORT).show();
                    mPatternLockView.clearPattern();
                }
            }

            @Override
            public void onCleared() {

            }
        });
    }
}