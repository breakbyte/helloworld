package com.bytedance.tiktok.base;

import android.os.Bundle;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
        activity基类
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());

        unbinder = ButterKnife.bind(this);
        init();
    }

    protected abstract int setLayoutId();

    protected abstract void init();

    /*
             全屏
     */
    protected void setFullScreen() {
        ImmersionBar.with(this).init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unbinder.unbind();
    }
}
