package com.ruoyi.http.func;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Flame on 2020/03/25.
 **/
public abstract class CallbackFunc<T> implements Callback<T> {

    public abstract void onResponse(T response);

    public abstract void onFailure(Throwable throwable);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        onResponse(response.body());
    }

    @Override
    public void onFailure(Call<T> call, Throwable throwable) {
        onFailure(throwable);
    }
}
