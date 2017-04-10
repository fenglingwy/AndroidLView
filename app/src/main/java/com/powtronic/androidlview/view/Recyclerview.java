package com.powtronic.androidlview.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.powtronic.androidlview.BaseAdapter;
import com.powtronic.androidlview.R;
import com.powtronic.androidlview.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Recyclerview extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        initView();

    }

    private void initView() {
        //初始数据
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("第" + i + "条数据");
        }

        /*初始化RecycleView
        * LinearLayoutManager           现行管理器，支持横向、纵向。
        * GridLayoutManager             网格布局管理器
        * StaggeredGridLayoutManager    瀑布就式布局管理器
        */

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);       //设置为垂直布局，这也是默认的
        recyclerView.setLayoutManager(layoutManager);                            //设置布局管理器
        recyclerView.setItemAnimator(new DefaultItemAnimator());                  //设置增加或删除条目的动画

        adapter = new MainAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }

    class MainAdapter extends BaseAdapter<String> {

        public MainAdapter(Context context, List<String> datas) {
            super(context, datas);
        }

        @Override
        protected int getItemViewForType(int viewType) {
            return R.layout.item_layout;
        }

        @Override
        protected void convert(ViewHolder holder, String s) {
            holder.setText(R.id.tv_item, s);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_h) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager .setOrientation(OrientationHelper.HORIZONTAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(adapter);
        } else if (id == R.id.action_v) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager .setOrientation(OrientationHelper.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(adapter);
        } else if (id == R.id.action_g) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(adapter);
        } else if (id == R.id.action_p) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL);
            recyclerView.setLayoutManager(staggeredGridLayoutManager);

            recyclerView.setAdapter(adapter);
        }

        return true;
    }

}
