package com.ruoyi.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Flame on 2020/03/20.
 **/
@Slf4j
public class GsonUtils {

    /**
     * 序列化
     *
     * @param obj 对象
     * @return Json
     */
    public static String serializer(Object obj) {
        return new GsonBuilder().create().toJson(obj);
    }

    /**
     * 反序列化对象
     *
     * @param data Json
     * @return 对象
     */
    public static <T> T deserializer(String data, Class<T> classType) {
        try {
            return new Gson().fromJson(data, classType);
        } catch (Exception e) {
            log.error("deserializer error");
            return null;
        }
    }

    /**
     * 反序列化数组对象
     *
     * @param data Json
     * @return 数组集合
     */
    public static <T> List<T> deserializerArray(String data, Class<T[]> clazz) {
        try {
            Gson gson = new Gson();
            T[] array = gson.fromJson(data, clazz);
            return Arrays.asList(array);
        } catch (Exception e) {
            log.error("deserializerArray error");
            return new ArrayList<>();
        }
    }

    /**
     * 反序列化集合对象
     *
     * @param data Json
     * @return 对象集合
     */
    public static <T> List<T> deserializerList(String data, Class<T> classType) {
        List<T> arrayList = new ArrayList<>();
        try {
            Type type = new TypeToken<ArrayList<JsonObject>>() {
            }.getType();
            Gson gson = new Gson();
            List<JsonObject> jsonObjects = gson.fromJson(data, type);
            for (JsonObject jsonObject : jsonObjects) {
                arrayList.add(gson.fromJson(jsonObject, classType));
            }
            return arrayList;
        } catch (Exception e) {
            log.error("deserializerList error");
            return arrayList;
        }
    }
}
