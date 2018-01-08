package com.jellybean.baking.network;

import com.jellybean.baking.bean.BakingBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Android Studio.
 *
 * @author jellybean
 * @Date: 2018/1/9.
 * @Time: 上午12:09.
 */
public interface Api {

	/**
	 * 烘焙应用网络数据接口
	 *
	 * @return 返回烘焙菜谱及具体步骤
	 */
	@GET("/nd801/ProjectResources/Baking/baking-cn.json")
	Observable<List<BakingBean>> getBakingStaffs();
}