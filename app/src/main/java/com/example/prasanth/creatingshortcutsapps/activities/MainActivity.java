package com.example.prasanth.creatingshortcutsapps.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.prasanth.creatingshortcutsapps.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button createShortCutBttn, navigationToanotherActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createShortCutBttn = findViewById(R.id.createShortcutBtn);
        navigationToanotherActivity = findViewById(R.id.navigateTonextActivity);
        createShortCutBttn.setOnClickListener(this);
        navigationToanotherActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.createShortcutBtn:
                createShortCut();
                break;
            case R.id.navigateTonextActivity:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void createShortCut() {
        Intent shortCut = new Intent(this, MainActivity.class);
        shortCut.setAction(Intent.ACTION_MAIN);

        Intent intent = new Intent();
        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortCut);
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "MainActivity");
        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                Intent.ShortcutIconResource.fromContext(getApplicationContext(),
                        R.drawable.images));


        intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("duplicate", false);
        this.sendBroadcast(intent);

        Toast.makeText(this, "Shortcut Successfully created", Toast.LENGTH_LONG).show();
    }
}
