package com.basic_demo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.basic_demo.R;
import com.basic_demo.ViewModels.ListViewModel;
import com.basic_demo.adapter.MyDataAdapter;
import com.basic_demo.databinding.ActivityMainBinding;
import com.basic_demo.models.ExampleOld;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    ListViewModel listViewModel;
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    MyDataAdapter myDataAdapter;
    List<ExampleOld> maindata;


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

        setUp_DateAndTime();


    }

    private void setUp_DateAndTime() {
        String weekDay;
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.ENGLISH);

        Calendar calendar = Calendar.getInstance();
        weekDay = dayFormat.format(calendar.getTime());
        Log.d("ttt","day ---------->"+weekDay);
    }

    private void observeViewModel() {

        listViewModel.getObservable().observe(this, new Observer<List<ExampleOld>>() {
            @Override
            public void onChanged(List<ExampleOld> exampleOlds) {
                binding.llPgbar.setVisibility(View.GONE);
                maindata = exampleOlds;
                myDataAdapter = new MyDataAdapter(maindata,MainActivity.this);
                binding.rvNews.setAdapter(myDataAdapter);
            }
        });
    }
}
