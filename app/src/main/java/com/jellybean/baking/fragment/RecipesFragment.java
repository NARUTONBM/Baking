package com.jellybean.baking.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jellybean.baking.R;
import com.jellybean.baking.adapter.RecipeItemAdapter;

/**
 * @author jellybean.
 * @Date 2018/1/24.
 * @Time 上午10:23.
 */
public class RecipesFragment extends BaseFragment {

	private RecyclerView mRvRecipe;
	private TextView mTvEmptyView;
	private SwipeRefreshLayout mSRLRecipe;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_main, container);

		// 找到控件
		mRvRecipe = view.findViewById(R.id.rv_recipe);
		mTvEmptyView = view.findViewById(R.id.tv_empty_view);
		mSRLRecipe = view.findViewById(R.id.srl_recipe);

		// 设置布局管理器
		mRvRecipe.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
		// 创建适配器并设置给rv
		RecipeItemAdapter adapter = new RecipeItemAdapter();
		mRvRecipe.setAdapter(adapter);

		return view;
	}

	@Override
	protected int getTitleRes() {
		return 0;
	}
}