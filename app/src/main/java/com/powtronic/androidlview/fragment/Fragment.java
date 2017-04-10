package com.powtronic.androidlview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by pp on 2017/3/31.
 */

public class Fragment  extends android.support.v4.app.Fragment{

    public static Fragment newInstance(int type) {
        Bundle args = new Bundle();
        Fragment fragment = new Fragment();
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
