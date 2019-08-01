package com.anhtam.futurify_test.base;

import android.content.Intent;
import android.view.View;

public interface IBase {
    void showKeyBoard(View view);
    void hideKeyBoard(View view);
    void onStartActivity(Intent intent);
}
