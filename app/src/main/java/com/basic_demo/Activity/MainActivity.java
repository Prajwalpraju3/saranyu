package com.basic_demo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.basic_demo.R;
import com.basic_demo.ViewModels.ListViewModel;
import com.basic_demo.adapter.MyDataAdapter;
import com.basic_demo.databinding.ActivityMainBinding;
import com.basic_demo.models.Example;

import java.util.List;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    ListViewModel listViewModel;
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    MyDataAdapter myDataAdapter;
    List<Example> maindata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.llPgbar.setVisibility(View.VISIBLE);

        ListViewModel.Factory factory = new ListViewModel.Factory(getApplication(), "");
        listViewModel = ViewModelProviders.of(MainActivity.this, factory).get(ListViewModel.class);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        binding.rvNews.setLayoutManager(linearLayoutManager);

        observeViewModel();


    }

    private void observeViewModel() {

        listViewModel.getObservable().observe(this, new Observer<List<Example>>() {
            @Override
            public void onChanged(List<Example> examples) {
                binding.llPgbar.setVisibility(View.GONE);
                maindata = examples;

                myDataAdapter = new MyDataAdapter(maindata,MainActivity.this);
                binding.rvNews.setAdapter(myDataAdapter);
            }
        });
    }
}
