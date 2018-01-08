package com.jellybean.baking.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.jellybean.baking.BuildConfig;
import com.jellybean.baking.bean.BakingBean;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Android Studio.
 *
 * @author jellybean
 * @Date: 2018/1/9.
 * @Time: 上午12:42.
 */
public class RetrofitClient {

	private static final String BASE_URL = "https://s3.cn-north-1.amazonaws.com.cn/static-documents";

	private static class SingleInstance {

		static final RetrofitClient INSTANCE = new RetrofitClient();
	}

	public static RetrofitClient getInstance() {

		return SingleInstance.INSTANCE;
	}

	private static Retrofit create() {

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

		return new Retrofit.Builder().baseUrl(BASE_URL).client(builder.build()).addConverterFactory(GsonConverterFactory.create())
						.addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
	}

	public void getBaking(Observer<List<BakingBean>> observable) {

		Retrofit retrofit = create();
		retrofit.create(Api.class).getBakingStaffs().subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
						.observeOn(AndroidSchedulers.mainThread()).subscribe(observable);
	}
}