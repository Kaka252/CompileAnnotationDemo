package com.zhouyou.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.anno.BindView;
import com.viewbinder.api.ViewBinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_text)
    TextView tvText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewBinder.bind(this);
        setText();
    }

    private void setText() {
        tvText.setText("The view int this Activity has binded Successfully.");
    }
}
