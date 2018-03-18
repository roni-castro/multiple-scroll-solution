package com.example.roni.multiplescroll;

import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.generic_view_pager)
    ViewPager viewPager;

    @BindView(R.id.rv_schedule)
    RecyclerView schedulerRecyclerView;

    @BindView(R.id.generic_tab_layout)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUpViewPagerAdapter();
        setUpScheduleRecyclerView();
    }

    public void setUpScheduleRecyclerView(){
        SingleTextAdapter schedulerSingleTextAdapter = new SingleTextAdapter(this, createMockSchedulerArray());

        schedulerRecyclerView.setAdapter(schedulerSingleTextAdapter);
        //schedulerRecyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        schedulerRecyclerView.setLayoutManager(linearLayoutManager);
    }

    public void setUpViewPagerAdapter() {
        FragmentAdapter adapter = new FragmentAdapter(this ,getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private ArrayList<String> createMockSchedulerArray(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Monday");
        arrayList.add("Tuesday");
        arrayList.add("Wednesday");
        arrayList.add("Thursday");
        arrayList.add("Friday");
        return arrayList;
    }
}
