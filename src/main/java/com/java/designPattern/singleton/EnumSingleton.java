package com.java.designPattern.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

/**
 * 枚举单例
 * 用枚举创建单例的好处：
 * 1.无需再考虑可序列化的情况
 * 2.无需再考虑通过反射调用私有构造函数的情况
 * 3.枚举实例创建是线程安全的，无需再考虑Double checked locking
 * Created by tengcongcong on 2016/12/20.
 */
public enum EnumSingleton {


    INSTANCE();


    /**
     * 属性文件对象
     */
    private Properties properties;

    private EnumSingleton(){

    }

    public static final Logger LOG=LoggerFactory.getLogger(EnumSingleton.class);

    /**
     * 根据指定属性文件返回属性文件对象
     * @param propertiesFile
     * @return
     */
    public void getProperties(String propertiesFile){

        Properties p=new Properties();
        InputStream inputStream=null;
        if(propertiesFile==null){
        	LOG.info("propertiesFile is null");
            throw new RuntimeException(" propertiesFile is null ");
        }
        try {
            inputStream= EnumSingleton.class.getClassLoader().getResourceAsStream(propertiesFile);
            p.load(inputStream);
        }catch (Exception e){
        	LOG.error("加载属性文件失败",e);
            throw new RuntimeException("加载属性文件失败",e);
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        }
        this.properties=p;
    }

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    public String getProperty(String key){
        if(properties==null){
           return null;
        }
        return properties.getProperty(key);
    }

}
