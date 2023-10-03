package com.example.myfirstapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myfirstapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.agreeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Открыть соглашение");
                builder.setMessage("Просмотреть лицензионное соглашение?");
                builder.setNegativeButton("Отмена", (dialogInterface, i) -> Toast.makeText(MainActivity.this, "Вы не прочитали соглашение", Toast.LENGTH_SHORT).show());
                builder.setPositiveButton("Да", ((dialogInterface, i) -> nextActivity("android.intent.action.AgreeActivity")));
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        binding.nextBtn.setOnClickListener(view1 -> {
            if(binding.checkBox.isChecked()) {
                nextActivity("android.intent.action.PlayerActivity");
            } else {
                Toast.makeText(MainActivity.this, "Примите соглашение", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void nextActivity(String activity) {
        Intent intent = new Intent(activity);
        startActivity(intent);
    }
}