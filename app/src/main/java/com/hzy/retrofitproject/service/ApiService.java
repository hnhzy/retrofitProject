package com.hzy.retrofitproject.service;

import com.hzy.retrofitproject.bean.BannerList;
import com.hzy.retrofitproject.bean.KnowledgeSystem;
import com.hzy.retrofitproject.bean.LoginBean;
import com.hzy.retrofitproject.bean.TestM;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by hzy on 2019/1/10
 **/
public interface ApiService {

    /**
     * 获取banner图
     * @return
     */
    @GET("banner/json")
    Call<BannerList> getBanner();

    /**
     * 获取知识体系数据
     * @param page
     * @param cid
     * @return
     */
    @GET("article/list/{page}/json")
    Call<KnowledgeSystem> getKnowledgeSystem(@Path("page") int page, @Query("cid") int cid);

    @FormUrlEncoded
    @POST("user/login")
    Call<LoginBean> postLogin(@Field("username") String username, @Field("password") String password);


    /**
     * @return
     */
    @GET("aip/guest/user/list?instanceOpenId=mrj2ebf675c1e9545f19ed56cf006ff4d02")
    Call<TestM> getTest();


}
