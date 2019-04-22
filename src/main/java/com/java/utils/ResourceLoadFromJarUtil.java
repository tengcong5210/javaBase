package com.java.utils;

import java.io.IOException; 
import java.io.InputStream; 
import java.net.JarURLConnection; 
import java.net.MalformedURLException; 
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile; 
  

  
public class ResourceLoadFromJarUtil { 
  
 /** 
  * @param args 
  * @throws IOException 
  */
 public static void main(String[] args) throws IOException { 
  
  /* 资源文件路径,不能以'/'字符字符开头 */ 
  String resourcePath = "struts-plugin.xml"; 
  
  /* 获取ClassPath下的所有jar路径 */ 
  String[] cps = System.getProperty("java.class.path").split(";");


  String cp="D:\\crm-web-0.0.1-SNAPSHOT.jar";
  resourcePath="META-INF/app.properties";
  InputStream in = loadResourceFromJarFile(cp, resourcePath);
  if (in != null) {
   Properties properties=new Properties();
   properties.load(in);
   System.out.println(properties.get("app.id"));
   in.close();
  }

  return;



  /* 读取本地Jar文件 *//*
  for (String cp : cps) { 
   if (!cp.endsWith(".jar")) { 
    continue; 
   } 
   InputStream in = loadResourceFromJarFile(cp, resourcePath); 
   if (in != null) { 
    //System.err.println(IOUtils.toString(in));
    in.close(); 
   } 
  } 
  
  *//* 读取本地Jar文件 *//*
  for (String cp : cps) { 
   if (!cp.endsWith(".jar")) { 
    continue; 
   }

  } 
  
  *//* 读取网络Jar文件 *//*
  InputStream in = loadResourceFromJarURL( 
    "http://localhost:8080/SpringStruts2Integration/struts2-spring-plugin-2.3.4.1.jar", resourcePath); 
  if (in != null) { 
   //System.err.println(IOUtils.toString(in));
   in.close(); 
  } */


 } 
  
 /** 
  * 读取Jar文件中的资源 
  * 
  * @param jarPath 
  *   本地jar文件路径 
  * @param resPath 
  *   资源文件所在jar中的路径(不能以'/'字符开头) 
  * @return 如果资源加载失败,返回null 
  */ 
 public static InputStream loadResourceFromJarFile(String jarPath, String resPath) { 
  if (!jarPath.endsWith(".jar")) { 
   return null; 
  } 
  try { 
   JarFile jarFile = new JarFile(jarPath);
   /*Enumeration<JarEntry> entries=jarFile.entries();
   while (entries.hasMoreElements()){
    JarEntry je=entries.nextElement();
    System.out.println("路径:"+je.getName());
   }*/

   JarEntry jarEntry = jarFile.getJarEntry(resPath); 
   if (jarEntry == null) { 
    return null; 
   } 
   return jarFile.getInputStream(jarEntry); 
  } catch (IOException e) { 
   e.printStackTrace(); 
   return null; 
  } 
 } 
  
 /** 
  * 读取Jar文件中的资源 
  * 
  * @param jarUrl 
  *   本地jar文件或网络上(ttp://host:port/subpath/jarfile.jar)jar文件路径 
  * @param resPath 
  *   资源文件所在jar中的路径(不能以'/'字符开头) 
  * @return 如果资源加载失败,返回null 
  */
 public static InputStream loadResourceFromJarURL(String jarUrl, String resPath) { 
  if (!jarUrl.endsWith(".jar")) { 
   return null; 
  } 
  URL url = null; 
  if (jarUrl.startsWith("http://")) { 
   try { 
    url = new URL("jar:" + jarUrl + "!/"); 
   } catch (MalformedURLException e) { 
    e.printStackTrace(); 
    return null; 
   } 
  } else { 
   try { 
    url = new URL("jar:file:/" + jarUrl + "!/"); 
   } catch (MalformedURLException e) { 
    e.printStackTrace(); 
    return null; 
   } 
  } 
  try { 
   JarURLConnection jarURLConnection; 
   jarURLConnection = (JarURLConnection) url.openConnection(); 
   JarFile jarFile = jarURLConnection.getJarFile(); 
   JarEntry jarEntry = jarFile.getJarEntry(resPath); 
   if (jarEntry == null) { 
    return null; 
   } 
   return jarFile.getInputStream(jarEntry); 
  } catch (IOException e) { 
   e.printStackTrace(); 
   return null; 
  } 
 } 
} 