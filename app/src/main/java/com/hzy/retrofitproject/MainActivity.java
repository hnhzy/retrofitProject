package com.hzy.retrofitproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hzy.retrofitproject.bean.LoginBean;
import com.hzy.retrofitproject.config.Urls;
import com.hzy.retrofitproject.service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1、创建retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASIC_URL)
                //设置数据解析器
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //2、用retrofit加工出对应的接口实例对象
        ApiService api = retrofit.create(ApiService.class);
        //3、获取适配转换Call对象
        Call<LoginBean> call = api.postLogin("362070860@qq.com", "123456");
        //4、调用call.enqueue方法获取数据
        call.enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                Log.d("Response--response", response.body().toString());
                Log.d("Response--response", response.code() + "");
                Log.d("Response--response", response.isSuccessful() + "");
                Log.d("Response--response", response.message() + "");
                LoginBean loginBeans = response.body();
                Log.d("Response--loginBeans", loginBeans.toString() + "");
                Log.d("Response--loginBeans", loginBeans.getErrorMsg() + "");
                Log.d("Response--loginBeans", loginBeans.getData().getUsername() + "");
                Log.d("Response--loginBeans", loginBeans.getErrorCode() + "");
//                try {
//                    String resStr=response.body().toString();
//                    JSONObject jb=new JSONObject(resStr);
//                    String errorMsg =jb.optString("errorMsg");
//                    double errorCode =jb.optDouble("errorCode");
//                    Log.d("Response--errorMsg", errorMsg+"");
//                    Log.d("Response--errorCode", errorCode+"");
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                Log.d("Response--onFailure", t.toString());
            }
        });

//        //3、获取适配转换Call对象
//        Call<KnowledgeSystem> call = api.getKnowledgeSystem(1,60);
//        //4、调用call.enqueue方法获取数据
//        call.enqueue(new Callback<KnowledgeSystem>() {
//            @Override
//            public void onResponse(Call<KnowledgeSystem> call, Response<KnowledgeSystem> response) {
//                Log.d("Response--response", response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<KnowledgeSystem> call, Throwable t) {
//                Log.d("Response--onFailure", t.toString());
//            }
//        });


    }
}
