package com.example.prasanth.creatingshortcutsapps.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.prasanth.creatingshortcutsapps.R;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    Button secondActivityShortcut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        secondActivityShortcut = findViewById(R.id.createSeondActivityShortcut);
        secondActivityShortcut.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.createSeondActivityShortcut:
                createShortCutforSecondActivity();
                break;
            default:
                break;
        }
    }

    public void createShortCutforSecondActivity() {
        Intent secondActivityShortcut = new Intent(this, SecondActivity.class);
        secondActivityShortcut.setAction("android.intent.action.MYACTION");

        Intent intent = new Intent();
        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, secondActivityShortcut);
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "SecondActivity");
        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(getApplicationContext(),
                R.drawable.images));

        intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("duplicate", false);
        this.sendBroadcast(intent);

        Toast.makeText(this, "Shortcut Successfully created", Toast.LENGTH_LONG).show();
    }
}
