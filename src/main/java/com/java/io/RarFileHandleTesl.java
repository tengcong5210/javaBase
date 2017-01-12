package com.java.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 将rar文件重命名
 * 
 * @author linco lee
 */
public class RarFileHandleTesl {
    /**
     * 获取指定路径下的文件列表 使用泛型 可以传任意类型的
     * 
     * @param path
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> getFileList(String pathname) {
        List<T> fileList = new ArrayList<T>();
        File file = new File(pathname);
        if (file.isDirectory()) {
            String[] filenames = file.list();
            fileList = (List<T>) Arrays.asList(filenames);
        }
        return fileList;
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> getFilenameList(String pathname) {
        List<T> fileList = new ArrayList<T>();
        File file = new File(pathname);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            fileList = (List<T>) Arrays.asList(files);
        }
        return fileList;
    }

    public static void main(String[] args) {
        String pathname = "D:\\myStudyVideo\\shengsiyuan\\src";
        File oldFile = new File(pathname);
        String[] filenames = oldFile.list();
        File newFile = null;
        String filename = "";
        for (String name : filenames) {
            newFile = new File(oldFile, name);//相当于创建源文件的拷贝
            filename = newFile.getName();
            newFile.renameTo(new File(oldFile.getAbsolutePath() + File.separator
                    + filename.replace("[北京圣思园Java培训教学视频]", "[北京圣思园视频]")));
        }

    }
}
