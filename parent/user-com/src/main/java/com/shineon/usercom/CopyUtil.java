package com.shineon.usercom;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: wsh
 */
public  class CopyUtil {
    public static void  copyPojo(Object source, Object target){
        BeanUtils.copyProperties(source,target);
    }
    public static <T> List<T> copyList(List list, Class<T> clazz) {
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList();
        }
        return JSON.parseArray(JSON.toJSONString(list), clazz);
    }
    public static Map<String, Object> copyMap(Map map) {
        return JSON.parseObject(JSON.toJSONString(map));
    }

}
