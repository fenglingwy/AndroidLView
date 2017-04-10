package com.powtronic.androidlview.view;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.powtronic.androidlview.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Animation extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);

        // 这里指定了被共享的视图元素
        ViewCompat.setTransitionName(imageView, "image");
    }
}
