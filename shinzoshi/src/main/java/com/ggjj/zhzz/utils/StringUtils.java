package com.ggjj.zhzz.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具
 * Created by lanjw on 2017/1/1.
 */
public class StringUtils {
    /**
     * 根据类型匹配，把带逗号的字符串进行切割，转换为List集合
     * @author Helga
     * @param str 带逗号分隔的字符串
     * @param dataType 需要转换的类型
     * @return List集合
     */
    public static List parseList(String str, String dataType ){
        String[] arr = str.split(",");
        int size = arr.length;
        List list = new ArrayList();
        if("long".equals(dataType)){
            for (int i = 0; i < size; i ++) {
                list.add(Long.parseLong(arr[i].trim()));
            }
        }else if("str".equals(dataType)){
            for (int i = 0; i < size; i ++) {
                list.add(arr[i].trim().toString());
            }
        } else if("int".equals(dataType)){
            for (int i = 0; i < size; i ++) {
                list.add(Integer.parseInt(arr[i].trim()));
            }
        }
        return list;
    }
}
