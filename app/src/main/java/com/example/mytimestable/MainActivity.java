package com.example.mytimestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    public void updateTimesTable(int timesTable){
        ArrayList<Integer> myNumbers = new ArrayList<>();
        for(int i=1;i<10;i++){

            myNumbers.add(i*timesTable);
        }
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,myNumbers);
        myListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = findViewById(R.id.myListView);
        final SeekBar mySeekBar = findViewById(R.id.mySeekBar);

        mySeekBar.setMax (40);
        mySeekBar.setProgress (1);


        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTable;
                if(progress<min) {
                    timesTable = min;
                    mySeekBar.setProgress(min);
                }else{timesTable = progress;}
                //Log.e("Values",Integer.toString(timesTable));
                updateTimesTable(timesTable);
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        updateTimesTable(1);
    }
}
