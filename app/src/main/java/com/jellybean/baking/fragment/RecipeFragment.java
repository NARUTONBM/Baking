package com.jellybean.baking.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jellybean.baking.R;

/**
 * 步骤页面
 *
 * @author jellybean.
 * @Date 2018/2/8.
 * @Time 下午3:40.
 */
public class RecipeFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recipe, container);
        RecyclerView rvIngredients = view.findViewById(R.id.rv_ingredients);

        return view;
    }
}