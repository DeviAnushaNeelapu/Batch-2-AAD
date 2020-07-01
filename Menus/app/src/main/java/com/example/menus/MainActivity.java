package com.example.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 RadioGroup radioGroup;
 RadioButton radioButton1,radioButton2;
 Button b1;
 CheckBox ch1,ch2,ch3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=findViewById(R.id.rb);
        radioButton1=findViewById(R.id.rgb1);
        radioButton2=findViewById(R.id.rgb2);
        ch1=findViewById(R.id.cb1);
        ch2=findViewById(R.id.cb2);
        ch3=findViewById(R.id.cb3);
        b1=findViewById(R.id.button);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.rgb1:
                        Toast.makeText(MainActivity.this, "male", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rgb2:
                        Toast.makeText(MainActivity.this, "female", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ch1.isChecked()&&ch2.isChecked()&&ch3.isChecked()){
                    Toast.makeText(MainActivity.this, ""+ch1.getText()+","+ch2.getText()+","+ch3.getText(), Toast.LENGTH_SHORT).show();
                }
                else if(ch1.isChecked()&&ch2.isChecked()){
                    Toast.makeText(MainActivity.this, ""+ch1.getText()+","+ch2.getText(), Toast.LENGTH_SHORT).show();
                }
                else if(ch2.isChecked()&&ch3.isChecked()){
                    Toast.makeText(MainActivity.this, ""+ch2.getText()+","+ch3.getText(), Toast.LENGTH_SHORT).show();
                }
                else if(ch3.isChecked()&&ch1.isChecked()){
                    Toast.makeText(MainActivity.this, ""+ch3.getText()+","+ch1.getText(), Toast.LENGTH_SHORT).show();
                }
                else if(ch1.isChecked()){
                    Toast.makeText(MainActivity.this, ""+ch1.isChecked(), Toast.LENGTH_SHORT).show();
                }
                else if(ch2.isChecked()){
                    Toast.makeText(MainActivity.this, "java selected"+ch2.isChecked(), Toast.LENGTH_SHORT).show();
                }
                else if(ch3.isChecked()){
                    Toast.makeText(MainActivity.this, ""+ch3.isChecked(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_selected,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                Toast.makeText(this, "selected item"+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.search:
                Toast.makeText(this, "selected item"+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
