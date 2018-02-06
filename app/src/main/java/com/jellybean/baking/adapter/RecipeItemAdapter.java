package com.jellybean.baking.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jellybean.baking.MyApplication;
import com.jellybean.baking.R;
import com.jellybean.baking.bean.RecipeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jellybean.
 * @Date 2018/1/31.
 * @Time 上午12:36.
 */
public class RecipeItemAdapter extends RecyclerView.Adapter {

	private Context mContext = new MyApplication().getContext();
	List<RecipeBean> mRecipeBeanList;
	List<Integer> mNameList = new ArrayList<Integer>();

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		View view = LayoutInflater.from(mContext).inflate(R.layout.recipe_item, parent, false);
		mNameList.add(0, R.mipmap.cover_nutella_pie);
		mNameList.add(1, R.mipmap.cover_brownies);
		mNameList.add(2, R.mipmap.cover_yellow_cake);
		mNameList.add(3, R.mipmap.cover_cheesecake);

		return new RecipeViewHolder(view);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

		RecipeViewHolder recipeViewHolder = (RecipeViewHolder) holder;
		RecipeBean recipeBean = mRecipeBeanList.get(position);
		recipeViewHolder.mIvCover.setImageResource(mNameList.get(position));
		recipeViewHolder.mTvRecipeName.setText(recipeBean.getName());
		recipeViewHolder.mTvRecipeStep.setText(recipeBean.getSteps().size());
	}

	@Override
	public int getItemCount() {

		return mRecipeBeanList == null ? 0 : mRecipeBeanList.size();
	}

	public void setRecipeBeanList(List<RecipeBean> recipeBeanList) {

		mRecipeBeanList = recipeBeanList;
	}

	private class RecipeViewHolder extends RecyclerView.ViewHolder {

		private final ImageView mIvCover;
		private final TextView mTvRecipeName;
		private final TextView mTvRecipeStep;

		public RecipeViewHolder(View view) {

			super(view);
			mIvCover = view.findViewById(R.id.iv_cover);
			mTvRecipeName = view.findViewById(R.id.tv_recipe_name);
			mTvRecipeStep = view.findViewById(R.id.tv_recipe_step);
		}
	}
}