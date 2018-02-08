package com.jellybean.baking.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jellybean.baking.R;
import com.jellybean.baking.bean.RecipeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jellybean.
 * @Date 2018/1/31.
 * @Time 上午12:36.
 */
public class RecipeItemAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    private List<RecipeBean> mRecipeBeanList;
    private List<Integer> mNameList = new ArrayList<Integer>();
	private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item, parent, false);
        view.setOnClickListener(this);

        //准备封面图片的id
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
        recipeViewHolder.mTvRecipeStep.setText(String.valueOf(recipeBean.getSteps().size()));
    }

    @Override
    public int getItemCount() {

        return mRecipeBeanList == null ? 0 : mRecipeBeanList.size();
    }

    public void setRecipeBeanList(List<RecipeBean> recipeBeanList) {

        mRecipeBeanList = recipeBeanList;
        notifyDataSetChanged();
    }

    private class RecipeViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mIvCover;
        private final TextView mTvRecipeName;
        private final TextView mTvRecipeStep;

        RecipeViewHolder(View view) {

            super(view);
            mIvCover = view.findViewById(R.id.iv_cover);
            mTvRecipeName = view.findViewById(R.id.tv_recipe_name);
            mTvRecipeStep = view.findViewById(R.id.tv_recipe_step);
        }
    }

	public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {

		this.mOnItemClickListener = listener;
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public void onClick(View v) {

		if (mOnItemClickListener != null) {

			// 注意这里使用getTag方法获取数据
			mOnItemClickListener.onItemClick(v, (Integer) v.getTag());
		}
	}

	/**
	 * 定义接口
	 */
	public interface OnRecyclerViewItemClickListener {

		/**
		 * 条目点击事件
		 *
		 * @param view
		 *            控件
		 * @param position
		 *            位置
		 */
		void onItemClick(View view, int position);
	}
}