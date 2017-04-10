package com.powtronic.androidlview.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.powtronic.androidlview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.animation)
    ImageView animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.palette,R.id.textInput,R.id.snackBar,R.id.floatingActionButton,R.id.ripper,R.id.navigationView,R.id.coordinator,R.id.cardView, R.id.recyclerView, R.id.tab, R.id.swipeRefreshLayout, R.id.CollapsingToolbar, R.id.animation,R.id.btn_animation})
    public void onClick(View view) {
        Intent i = new Intent();
        switch (view.getId()) {
            case R.id.navigationView:
                i.setClass(this, Navigation.class);
                startActivity(i);
                break;
            case R.id.recyclerView:
                i.setClass(this, Recyclerview.class);
                startActivity(i);
                break;
            case R.id.tab:
                i.setClass(this, Tab.class);
                startActivity(i);
                break;
            case R.id.swipeRefreshLayout:
                i.setClass(this, SwipeRefresh.class);
                startActivity(i);
                break;
            case R.id.CollapsingToolbar:
                i.setClass(this, ScrollingActivity.class);
                startActivity(i);
                break;
            case R.id.cardView:
                i.setClass(this, CardViewActivity.class);
                startActivity(i);
                break;
            case R.id.ripper:
                i.setClass(this, RipperActivity.class);
                startActivity(i);
                break;
            case R.id.coordinator:
                i.setClass(this, CoordinatorLayoutActivity.class);
                startActivity(i);
                break;
            case R.id.textInput:
                i.setClass(this, TextInputLayoutActivity.class);
                startActivity(i);
                break;
            case R.id.floatingActionButton:
                i.setClass(this, FloatingActionButton.class);
                startActivity(i);
                break;
            case R.id.snackBar:
                i.setClass(this, SnackbarActivity.class);
                startActivity(i);
                break;
            case R.id.palette:
                i.setClass(this, PaletteActivity.class);
                startActivity(i);
                break;
            case R.id.animation:
            case R.id.btn_animation:
                i.setClass(this, Animation.class);
                // 这里指定了共享的视图元素
                ActivityOptionsCompat options = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(this, animation, "image");
                ActivityCompat.startActivity(this, i, options.toBundle());
                break;
        }

    }
}
