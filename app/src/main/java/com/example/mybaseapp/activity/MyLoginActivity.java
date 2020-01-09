package com.example.mybaseapp.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mybaseapp.R;

public class MyLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_login);
        init();
    }

    private void init() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new LoginFragment())
                .addToBackStack(null)
                .commit();
    }
}
