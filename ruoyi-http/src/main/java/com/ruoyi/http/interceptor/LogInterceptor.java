package com.ruoyi.http.interceptor;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Http拦截器
 * Created by Flame on 2020/03/24.
 **/
@Slf4j
public class LogInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        log.info("Http request => {}", request);
        Response response = chain.proceed(chain.request());
        ResponseBody responseBody = response.body();
        String content = responseBody.string();
        MediaType mediaType = response.body().contentType();
        log.info("Http response => {}", content);
        return response.newBuilder()
                .body(ResponseBody.create(mediaType, content))
                .build();
    }
}
