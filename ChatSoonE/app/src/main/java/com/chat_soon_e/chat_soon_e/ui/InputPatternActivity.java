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
    int mode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_pattern);

        // 패턴 모드 확인
        // 0: 숨긴 폴더 목록을 확인하기 위한 입력 모드
        // 1: 메인 화면의 설정창 -> 변경 모드
        // 2: 폴더 화면의 설정창 -> 변경 모드
        // 3: 메인 화면 폴더로 보내기 -> 숨김 폴더 눌렀을 경우
        SharedPreferences modeSPF = getSharedPreferences("mode", 0);
        mode = modeSPF.getInt("mode", 0);
        Log.d("CREATE/MODE", String.valueOf(mode));

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
                    if(mode == 0) { // 숨긴 폴더 목록을 보여주면 된다.
                        Intent intent = new Intent(getApplicationContext(), HiddenFolderActivity.class);
                        startActivity(intent);
                        finish();
                    } else if(mode == 1 || mode == 2) {  // 패턴 변경 모드이므로, 패턴을 생성하는 CreatePatternActivity로 가면 된다.
                        Intent intent = new Intent(getApplicationContext(), CreatePatternActivity.class);
                        startActivity(intent);
                        finish();
                    } else { // 폴더 리스트에서 숨김 폴더 클릭했을 때
                        finish();
                    }
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