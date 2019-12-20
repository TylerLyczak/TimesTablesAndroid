package com.example.timetables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    
    SeekBar numberControl;

    ArrayList<Integer> timeTableList = new ArrayList<>();

    ArrayAdapter<Integer> arrayAdapter;


    ArrayList<Integer> changeArrayList (int newNum) {
        ArrayList<Integer> newList = new ArrayList<>();

        for (int i=1; i<=20; i++)   {
            newList.add(i*newNum);
        }

        return newList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberControl = (SeekBar) findViewById(R.id.seekBar);
        numberControl.setMax(20);
        numberControl.setProgress(1);

        timeTableList = changeArrayList(1);

        ListView numberListView = findViewById(R.id.listView);

        arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, timeTableList);

        numberListView.setAdapter(arrayAdapter);

        numberControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // change array list numbers here
                timeTableList = changeArrayList(progress);
                arrayAdapter.clear();
                arrayAdapter.addAll(timeTableList);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
