package com.zhuelise.lab02bguiinteractions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView greeting;
    TextView cycle_textview;
    EditText enterName;
    String[] names;
    String greet_user;
    int count = 0;
    String current = "";
    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addName(View view) {
        enterName = (EditText) findViewById(R.id.name_edittext);
        greeting = (TextView) findViewById(R.id.greeting_textview);
        current = enterName.getText().toString();
        greet_user = getString(R.string.greet_user, current);
        greeting.setText(greet_user);
    }

    public void cycleForward(View view) {
        Resources res = getResources();
        names = (String[]) res.getStringArray(R.array.name_list);
        cycle_textview = (TextView) findViewById(R.id.cycle_textview);
        if(count>=names.length)
            count=0;
        cycle_textview.setText(names[count++]);
    }

    public void cycleBack(View view) {
        Resources res = getResources();
        names = (String[]) res.getStringArray(R.array.name_list);
        cycle_textview = (TextView) findViewById(R.id.cycle_textview);
        if(count<=0)
            count=names.length-1;
        cycle_textview.setText(names[count--]);
    }

    public void playMusic(View view) {
        music= MediaPlayer.create(MainActivity.this,R.raw.music);
        music.start();
    }
}