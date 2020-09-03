package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

import android.os.Bundle;

import java.util.List;

import Database.TaskEntity;
import ViewModels.ListViewModel;

public class MainActivity extends AppCompatActivity {

    private ListViewModel listViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewModel = new ViewModelProvider(this).get(ListViewModel.class);
        listViewModel.getAllTask().observe(this, new Observer<List<TaskEntity>>() {
            @Override
            public void onChanged(List<TaskEntity> taskEntities) {
                //updating the recyclerview

            }
        });
    }
}