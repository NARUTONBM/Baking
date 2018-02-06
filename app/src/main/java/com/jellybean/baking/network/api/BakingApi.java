package com.jellybean.baking.network.api;

import com.jellybean.baking.bean.RecipeBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Android Studio.烘焙应用获取数据的Api请求接口
 *
 * @author jellybean
 * @Date: 2018/1/9.
 * @Time: 上午12:09.
 */
public interface BakingApi {

	/**
	 * 烘焙应用网络数据接口
	 *
	 * @return 返回烘焙菜谱及具体步骤
	 */
	@GET("nd801/ProjectResources/Baking/baking-cn.json")
	Observable<List<RecipeBean>> getBakingStaffs();
}