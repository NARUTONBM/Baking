package com.jellybean.baking.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jellybean.baking.MyApplication;
import com.jellybean.baking.R;
import com.jellybean.baking.bean.RecipeBean;

import java.util.List;

/**
 * @author jellybean.
 * @Date 2018/1/31.
 * @Time 上午12:36.
 */
public class RecipeItemAdapter extends RecyclerView.Adapter {

	private Context mContext = new MyApplication().getContext();
	List<RecipeBean> mRecipeBeanList;

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		View view = LayoutInflater.from(mContext).inflate(R.layout.recipe_item, parent, false);

		return new RecipeViewHolder(view);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

	}

	@Override
	public int getItemCount() {

		return mRecipeBeanList == null ? 0 : mRecipeBeanList.size();
	}

	private class RecipeViewHolder extends RecyclerView.ViewHolder {

		public RecipeViewHolder(View view) {

			super(view);
		}
	}
}