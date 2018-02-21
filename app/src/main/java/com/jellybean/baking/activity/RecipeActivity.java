package com.jellybean.baking.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jellybean.baking.R;

/**
 * 步骤页面
 *
 * @author jellybean.
 * @Date 2018/2/8.
 * @Time 下午3:41.
 */
public class RecipeActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {

        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_recipe);
    }
}