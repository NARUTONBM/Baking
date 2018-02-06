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
import android.widget.Toast;

import com.jellybean.baking.R;
import com.jellybean.baking.adapter.RecipeItemAdapter;
import com.jellybean.baking.bean.RecipeBean;
import com.jellybean.baking.network.NetWork;
import com.orhanobut.logger.Logger;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author jellybean.
 * @Date 2018/1/24.
 * @Time 上午10:23.
 */

public class RecipesFragment extends BaseFragment {

    private RecyclerView mRvRecipe;
    private TextView mTvEmptyView;
    private SwipeRefreshLayout mSRLRecipe;
    private RecipeItemAdapter mRecipeItemAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mDisposable = NetWork.getBakingApi()
                .getBakingStaffs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<RecipeBean>>() {
                    @Override
                    public void accept(List<RecipeBean> bakingBeans) throws Exception {

                        mRecipeItemAdapter.setRecipeBeanList(bakingBeans);
                        Logger.d(bakingBeans.get(0).getIngredients());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {

                        Toast.makeText(getActivity(), R.string.loading_failed, Toast.LENGTH_SHORT).show();
                        Logger.e(throwable.getMessage());
                    }
                });
    }

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
        mRecipeItemAdapter = new RecipeItemAdapter();
        mRvRecipe.setAdapter(mRecipeItemAdapter);

        return view;
    }

    @Override
    protected int getTitleRes() {
        return 0;
    }
}