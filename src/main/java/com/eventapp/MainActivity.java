package com.eventapp;

import android.app.Activity;
import android.os.Bundle;
import com.eventapp.fragment.CreateEventFragment;
import com.eventapp.utils.FragmentUtils;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        CreateEventFragment fragment = new CreateEventFragment();
        FragmentUtils.setFragment(this, fragment, R.id.fragment_container);
    }
}
