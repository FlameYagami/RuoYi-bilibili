package com.ruoyi.http;

import com.google.gson.Gson;
import com.ruoyi.http.func.CallbackFunc;
import com.ruoyi.http.model.UpdateInfo;
import com.ruoyi.http.service.TestApi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Flame on 2020/03/25.
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RuoyiHttpApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpTest {

    @Test
    public void testHttp(){
        TestApi.checkAppUpdate("1.5.0").enqueue(new CallbackFunc<UpdateInfo>() {

            @Override
            public void onResponse(UpdateInfo response) {
                System.out.println(new Gson().toJson(response));
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        });
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
