package com.powtronic.androidlview.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.powtronic.androidlview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaletteActivity extends AppCompatActivity {

    @BindView(R.id.tv_vs)
    TextView tvVs;
    @BindView(R.id.tv_dvs)
    TextView tvDvs;
    @BindView(R.id.tv_lvs)
    TextView tvLvs;
    @BindView(R.id.tv_ms)
    TextView tvMs;
    @BindView(R.id.tv_dms)
    TextView tvDms;
    @BindView(R.id.tv_lms)
    TextView tvLms;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.activity_palette)
    LinearLayout activityPalette;
    private Bitmap bitmap;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        paletteTest();
    }

    private void paletteTest() {
        iv.setImageResource(i[count%5]);
        bitmap = BitmapFactory.decodeResource(getResources(), i[count%5]);

        // 此方法可能会阻塞主线程，建议使用异步方法
//        Palette generate = Palette.from(bitmap).generate();
        // 异步提取Bitmap颜色
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                // 提取完毕
                // 有活力的颜色
                Palette.Swatch vibrant = palette.getVibrantSwatch();
                // 有活力的暗色
                Palette.Swatch darkVibrant = palette.getDarkVibrantSwatch();
                // 有活力的亮色
                Palette.Swatch lightVibrant = palette.getLightVibrantSwatch();
                // 柔和的颜色
                Palette.Swatch muted = palette.getMutedSwatch();
                // 柔和的暗色
                Palette.Swatch darkMuted = palette.getDarkMutedSwatch();
                // 柔和的亮色
                Palette.Swatch lightMuted = palette.getLightMutedSwatch();
                //设置toolBar背景颜色
                toolbar.setBackgroundColor(vibrant != null ? vibrant.getRgb() : 0x999933);
                // 修改文字的颜色
                tvVs.setBackgroundColor(vibrant != null ? vibrant.getRgb() : 0x999933);
                tvDvs.setBackgroundColor(darkVibrant != null ? darkVibrant.getRgb() : 0x999933);
                tvLvs.setBackgroundColor(lightVibrant != null ? lightVibrant.getRgb() : 0x999933);
                tvMs.setBackgroundColor(muted != null ? muted.getRgb() : 0x999933);
                tvDms.setBackgroundColor(darkMuted != null ? darkMuted.getRgb() : 0x999933);
                tvLms.setBackgroundColor(lightMuted != null ? lightMuted.getRgb() : 0x999933);
                tvVs.setTextColor(vibrant != null ? vibrant.getTitleTextColor() : 0x999933);
                tvDvs.setTextColor(darkVibrant != null ? darkVibrant.getTitleTextColor() : 0x999933);
                tvLvs.setTextColor(lightVibrant != null ? lightVibrant.getTitleTextColor() : 0x999933);
                tvMs.setTextColor(muted != null ? muted.getTitleTextColor() : 0x999933);
                tvDms.setTextColor(darkMuted != null ? darkMuted.getTitleTextColor() : 0x999933);
                tvLms.setTextColor(lightMuted != null ? lightMuted.getTitleTextColor() : 0x999933);
            }
        });
    }


    private int count = 0;
    int[] i = {R.mipmap.bg,R.mipmap.bg1,R.mipmap.bg2,R.mipmap.bg3,R.mipmap.bg4};
    @OnClick(R.id.change)
    public void onClick() {
        count++;
        paletteTest();

    }
}
