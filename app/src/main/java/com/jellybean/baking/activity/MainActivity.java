package com.jellybean.baking.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.jellybean.baking.R;

/**
 * @author jellybean
 */

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//getSupportFragmentManager().beginTransaction().add(new RecipesFragment(),"Recipes").commit();

		initUI();
	}

	private void initUI() {

		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
	}
}