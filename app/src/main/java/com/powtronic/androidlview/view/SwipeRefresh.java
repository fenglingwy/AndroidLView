package com.powtronic.androidlview.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.powtronic.androidlview.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SwipeRefresh extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.activity_swipe_refresh)
    SwipeRefreshLayout activitySwipeRefresh;
    private ArrayList<String> datas;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        activitySwipeRefresh.setColorSchemeResources(R.color.colorPrimary,
                R.color.colorAccent, R.color.colorPrimaryDark,
                R.color.colorAccent);
        activitySwipeRefresh.setOnRefreshListener(this);

        datas = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(adapter);

        activitySwipeRefresh.setRefreshing(true);
        onRefresh();
    }


    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                activitySwipeRefresh.setRefreshing(false);
                datas.add(0,"数据"+datas.size());
                adapter.notifyDataSetChanged();
            }
        }, 1500);
    }
}
