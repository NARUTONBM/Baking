package com.jellybean.baking.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.jellybean.baking.BuildConfig;
import com.jellybean.baking.network.api.BakingApi;
import com.jellybean.baking.utils.ConstantValues;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 用Retrofit+RxJava2封装的获取烘焙应用网络数据的工具类
 *
 * @author jellybean
 * @Date: 2018/1/9.
 * @Time: 上午12:42.
 */
public class NetWork {

	private static BakingApi sBakingApi;

	/**
	 * 构建Retrofit实例，用于发出网络请求
	 *
	 * @return 返回一个Retrofit实例
	 */
	public static BakingApi getBakingApi() {

		if (sBakingApi == null) {

			// 创建OkHttpClient对象
			OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
			// 设置超时
			builder.readTimeout(10, TimeUnit.SECONDS);
			builder.connectTimeout(9, TimeUnit.SECONDS);

			if (BuildConfig.DEBUG) {

				HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
				interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
				builder.addInterceptor(interceptor);
			}

			// 创建Retrofit实例
			Retrofit retrofit = new Retrofit.Builder().baseUrl(ConstantValues.BASE_URL).client(builder.build())
							.addConverterFactory(GsonConverterFactory.create())
							.addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();

			sBakingApi = retrofit.create(BakingApi.class);
		}

		return sBakingApi;
	}
}