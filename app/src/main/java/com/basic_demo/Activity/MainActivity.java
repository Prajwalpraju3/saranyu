package com.basic_demo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.basic_demo.R;
import com.basic_demo.ViewModels.ListViewModel;
import com.basic_demo.adapter.MyDataAdapter;
import com.basic_demo.databinding.ActivityMainBinding;
import com.basic_demo.models.Example;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    ListViewModel listViewModel;
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
    MyDataAdapter myDataAdapter;
    Example maindata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.llPgbar.setVisibility(View.VISIBLE);

        ListViewModel.Factory factory = new ListViewModel.Factory(getApplication(), "");
        listViewModel = ViewModelProviders.of(MainActivity.this, factory).get(ListViewModel.class);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        binding.rvNews.setLayoutManager(gridLayoutManager);

        observeViewModel();



    }


    private void observeViewModel() {

        listViewModel.getObservable().observe(this, new Observer<Example>() {
            @Override
            public void onChanged(Example exampleOlds) {
                binding.llPgbar.setVisibility(View.GONE);
                binding.llMain.setVisibility(View.VISIBLE);
                maindata = exampleOlds;
                binding.setDatalist(maindata.getList().get(0));
                myDataAdapter = new MyDataAdapter(maindata.getList(),MainActivity.this);
                binding.rvNews.setAdapter(myDataAdapter);
            }
        });
    }
}
