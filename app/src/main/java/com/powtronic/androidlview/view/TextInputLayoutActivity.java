package com.powtronic.androidlview.view;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;

import com.powtronic.androidlview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TextInputLayoutActivity extends AppCompatActivity {


    @BindView(R.id.usernameWrapper)
    TextInputLayout usernameWrapper;
    @BindView(R.id.passwordWrapper)
    TextInputLayout passwordWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_layout);
        ButterKnife.bind(this);
//        usernameWrapper.setErrorEnabled(true);
//        passwordWrapper.setErrorEnabled(true);
    }


    @OnClick(R.id.login)
    public void onClick() {
        String username = usernameWrapper.getEditText().getText().toString();
        String password = passwordWrapper.getEditText().getText().toString();

        if (!validate(username)) {
            usernameWrapper.setError("用户名长度大于5");
        } else {
            usernameWrapper.setErrorEnabled(false);
        }
        if (!validate(password)) {
            passwordWrapper.setError("密码长度大于5");
        } else {
            passwordWrapper.setErrorEnabled(false);
        }
    }

    public boolean validate(String password) {
        return password.length() > 5;
    }
}
