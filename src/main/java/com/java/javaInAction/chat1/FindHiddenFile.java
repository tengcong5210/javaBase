package com.java.javaInAction.chat1;

import java.io.File;
import java.io.FileFilter;

/**
 * java8中方法引用的使用
 * @创建人 tengcc
 * @创建时间 2019/4/22
 * @描述
 */
public class FindHiddenFile {

    public static void main(String[] args) {
        //java8之前的写法 检索某目录下为隐藏文件的列表
        File[] hiddenFiles=new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });

        //java8 的写法   其中 ::为方法引用的写法
        File[] hiddenFiles1=new File(".").listFiles(File::isHidden);
    }
}