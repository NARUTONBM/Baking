package com.jellybean.baking.fragment;

import android.support.v4.app.Fragment;

import io.reactivex.disposables.Disposable;

/**
 * @author jellybean.
 * @Date 2018/1/26.
 * @Time 下午3:40.
 */

public abstract class BaseFragment extends Fragment {

	protected Disposable mDisposable;

	@Override
	public void onDestroyView() {

		super.onDestroyView();
		unSubscribe();
	}

	protected void unSubscribe() {

		if (mDisposable != null && mDisposable.isDisposed()) {

			mDisposable.dispose();
		}
	}
}