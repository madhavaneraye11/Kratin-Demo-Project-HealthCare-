package com.spam.maddy.kratindemoproject.listeners;

import android.app.Activity;
import android.view.View;

import com.spam.maddy.kratindemoproject.MyMenuActivity;


public class ToWindowOnClickWithClosing extends ToWindowOnClick {
    public ToWindowOnClickWithClosing(Activity fromActivity, Class<? extends Activity> toActivityClass) {
        super(fromActivity, toActivityClass);
    }

    @Override
    public void onClick(View v) {
        if (!MyMenuActivity.isOpen) {
            super.onClick(v);
        }
        fromActivity.finish();
    }
}
