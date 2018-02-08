package com.jellybean.baking.fragment;

import android.graphics.Color;
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
import com.jellybean.baking.utils.Utils;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
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

public class RecipesFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    private TextView mTvEmptyView;
    private SwipeRefreshLayout mSRLRecipe;
    private RecipeItemAdapter mRecipeItemAdapter = new RecipeItemAdapter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        refreshData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container);

        // 找到控件
        RecyclerView rvRecipe = view.findViewById(R.id.rv_recipe);
        mTvEmptyView = view.findViewById(R.id.tv_empty_view);
        mTvEmptyView.setVisibility(View.GONE);
        mSRLRecipe = view.findViewById(R.id.srl_recipe);
        mSRLRecipe.setRefreshing(true);

        // 设置布局管理器
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        gridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        rvRecipe.setLayoutManager(gridLayoutManager);
        // 设置边距
        SpaceDecoration itemDecoration = new SpaceDecoration((int) Utils.convertDpToPixel(8, getContext()));
        itemDecoration.setPaddingEdgeSide(true);
        itemDecoration.setPaddingStart(true);
        rvRecipe.addItemDecoration(itemDecoration);
        // 将适配器设置给rv
        rvRecipe.setAdapter(mRecipeItemAdapter);
        mSRLRecipe.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW);
        mSRLRecipe.setOnRefreshListener(this);
        mSRLRecipe.setEnabled(true);

        return view;
    }

    @Override
    public void onRefresh() {

        mSRLRecipe.setRefreshing(true);
        refreshData();
    }

    /**
     * 刷新网络数据的方法
     */
    private void refreshData() {

        mDisposable = NetWork.getBakingApi()
                .getBakingStaffs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<RecipeBean>>() {
                    @Override
                    public void accept(List<RecipeBean> bakingBeans) throws Exception {

                        mRecipeItemAdapter.setRecipeBeanList(bakingBeans);
                        mSRLRecipe.setRefreshing(false);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {

                        mTvEmptyView.setVisibility(View.VISIBLE);
                        mTvEmptyView.setText(R.string.res_tv_empty);
                        Toast.makeText(getActivity(), R.string.loading_failed, Toast.LENGTH_SHORT).show();
                        Logger.e(throwable.getMessage());
                    }
                });
    }
}