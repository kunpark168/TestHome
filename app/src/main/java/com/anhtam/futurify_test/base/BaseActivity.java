package com.anhtam.futurify_test.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;

import com.anhtam.futurify_test.R;

public class BaseActivity extends AppCompatActivity implements IBase{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    @Override
    public void showKeyBoard(View e) {
        e.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(e, InputMethodManager.SHOW_IMPLICIT);

    }

    @Override
    public void hideKeyBoard(View view) {
        view.clearFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    @Override
    public void onStartActivity(Intent intent) {
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_start, R.anim.slide_in_start);
    }

    public void action(View v, Runnable runnable) {
        v.setOnTouchListener((view1, e) -> {
            switch (e.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    v.setAlpha(0.5f);
                    break;
                case MotionEvent.ACTION_UP:
                    v.setAlpha(1.0f);
                    break;
                case MotionEvent.ACTION_CANCEL:
                    v.setAlpha(1.0f);
                    break;
            }
            return false;
        });

        v.setOnClickListener(view -> runnable.run());
    }
}
