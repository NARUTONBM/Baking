package com.jellybean.baking;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * @author jellybean.
 * @Date 2018/1/26.
 * @Time 下午3:47.
 */
public class MyApplication extends Application {

	private Context mContext;

	@Override
	public void onCreate() {

		super.onCreate();
		Logger.addLogAdapter(new AndroidLogAdapter());
	}

	/**
	 * 全局获取context的方法
	 *
	 * @return 返回当前的context
	 */
	public Context getContext() {

		this.mContext = getApplicationContext();

		return mContext;
	}
}