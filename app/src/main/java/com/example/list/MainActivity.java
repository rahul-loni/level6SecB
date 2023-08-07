package com.example.list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.list.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    String Data[] ={"Rahul","Rohan ","Roushan","Rupak","nepal"
            ,"india","Rahul","Rohan ","Roushan","Rupak","nepal"
            ,"india",};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter arrayAdapter=new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,Data);
        binding.list.setAdapter(arrayAdapter);
        binding.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                if (i==0){
                    Toast.makeText(MainActivity.this, "Click To Rahul", Toast.LENGTH_SHORT).show();
                }
                if (i==1){
                    Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
                    startActivity(intent);
                }
                if (i==2){
                    Intent intent3=new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com/"));
                    startActivity(intent3);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Click to 1st item", Toast.LENGTH_SHORT).show();
            break;
            case R.id.item2:
                Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}