package com.jq.utils;

import java.io.File;
import java.util.ArrayList;

import org.springframework.util.ResourceUtils;

public class CommUtil {
    // 获取资源文件相对路径
    public static ArrayList<String> getUrl() {
        try {
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            File upload = new File(path.getAbsolutePath(), "static/images/work/");
            ArrayList<String> files = new ArrayList<String>();
            getAllFileName(upload.getAbsolutePath(), files);

            return files;

        } catch (Exception e) {
        }
        return null;
    }

    public static void getAllFileName(String path, ArrayList<String> fileNameList) {
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                String temppath = tempList[i].getPath();
                temppath = temppath.substring(temppath.indexOf("static/")+7, temppath.length());
                fileNameList.add(temppath);
            }
            if (tempList[i].isDirectory()) {
                getAllFileName(tempList[i].getAbsolutePath(), fileNameList);
            }
        }
        return;
    }

    /**
     * 获取案例首页图
     * @param path
     * @param fileNameList
     */
    public static void getAllWork01(String path, ArrayList<String> fileNameList){
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                String temppath = tempList[i].getPath();
                temppath = temppath.substring(temppath.indexOf("static/")+7, temppath.length());
                if(temppath.contains("01")){
                    fileNameList.add(temppath);
                }
            }
            if (tempList[i].isDirectory()) {
                getAllWork01(tempList[i].getAbsolutePath(), fileNameList);
            }
        }
        return;
    }
}