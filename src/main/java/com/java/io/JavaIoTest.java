package com.java.io;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

import org.junit.Test;

/**
 * java 文件操作
 * 
 * @author linco lee
 */
public class JavaIoTest {
	public static final String SEPARATOR=File.separator;
	/**
	 * 测试文件File类
	 * @throws Exception
	 */
	@Test
	public void testFile() throws Exception {
//		String path="D:\\javaIo\\hello.txt";
		String path="D:"+SEPARATOR+"javaIo"+SEPARATOR+"hello.txt";
		//创建文件
		File file=new File(path);
		file.createNewFile();
		
		//file类常量
		System.out.println(File.separator);
		System.out.println(File.pathSeparator);
		System.out.println(File.pathSeparatorChar);
        
		//file delete
		if(file.exists()){
			file.delete();
		}
	}
	/**
	 * 创建文件夹
	 * 注意：mkdir只会创建指定的目录.比如d:\javaIo\hello  父目录javaIo不存在，hello也不会被创建;只有当父目录javaIo存在，hello才会创建成功.
	 *     mkdirs 创建此抽象路径名指定的目录，包括所有必需但不存在的父目录
	 * @throws Exception
	 */
	@Test
	public void testCreateDir() throws Exception {
		String path="D:"+SEPARATOR+"javaIo"+SEPARATOR+"hello";
		File file=new File(path);
		file.mkdirs();
	}
	/**
	 * 列出所有文件（包括隐藏文件）
	 * @throws Exception
	 */
	@Test
	public void testFileList() throws Exception {
		String pathname="d:"+SEPARATOR;
		File file=new File(pathname);
		String[] list=file.list();
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
		
		File[] fileList=file.listFiles();
		for (File file2 : fileList) {
			System.out.println("AbsolutePath:"+file2.getAbsolutePath());
			System.out.println("name:"+file2.getName());
		}
	}
	/**
	 * 判断指定路径是不是目录
	 * @throws Exception
	 */
	@Test
	public void testIsDirectory() throws Exception {
		String pathname="d:"+SEPARATOR;
		File file=new File(pathname);
		if(file.isDirectory()){
			System.out.println("目录");
		}else{
			System.out.println("非目录");
		}
	}
	/**
	 * 搜索指定目录下的所有文件
	 * @throws Exception
	 */
	@Test
	public void testSearchAllFile() throws Exception {
		String pathname="d:"+SEPARATOR+"var";
		File file=new File(pathname);
		iterationFile(file);
	}
	
	/**
	 * 递归调用
	 * @param file
	 */
    private void iterationFile(File file) {
		if(null!=file){
			if(file.isDirectory()){
				File[] files=file.listFiles();
				for (File file2 : files) {
					System.out.println(file2);
					iterationFile(file2);
				}
			}else{
				System.out.println(file);
			}
		}
	}
   /**
    * RandomAccessFile写数据
    * @throws Exception
    */
    @Test
	public void testRandomAccessFile() throws Exception {
    	String pathname="d:"+SEPARATOR+"javaIo"+SEPARATOR+"randomAccessHello.txt";
    	RandomAccessFile raf=new RandomAccessFile(pathname, "rw");
    	raf.write("test".getBytes());
    	raf.write(127);
    	raf.writeBoolean(true);
    	raf.writeByte(1);
    	raf.writeBytes("ssss");
    	raf.writeChar('a');
    	raf.writeDouble(2.11);
    	raf.writeLong(222L);
    	raf.writeFloat(23F);
    	raf.close();
    	
    	
    	
	}
    /**
     * RandomAccessFile读数据
     * @throws Exception
     */
    @Test
	public void testReadFromRandomAccessFile() throws Exception {
    	String pathname="d:"+SEPARATOR+"javaIo"+SEPARATOR+"randomAccessHello.txt";
    	RandomAccessFile raf=new RandomAccessFile(pathname, "rw");
    	byte[] bytes=new byte["test".getBytes().length];
    	int len=raf.read(bytes);
    	System.out.println("read1:"+(new String(bytes)));
    	System.out.println("raf.readInt():"+raf.readInt());
    	System.out.println("raf.readBoolean():"+raf.readBoolean());
    	System.out.println("raf.readByte():"+raf.readByte());
    	raf.close();
	}
    
	/**
     * 文件输出流 FileOutputStream
     */
	@Test
    public void testFileOutputStream() {
		String pathname="d:"+SEPARATOR+"javaIo"+SEPARATOR+"fileOutputStream.txt";
		OutputStream out=null;
        try {
            out = new FileOutputStream(pathname);
            out.write("李四".getBytes("utf-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    }
	/**
	 * 文件读取 字节流
	 * @throws Exception
	 */
	@Test
	public void testFileInputStream() throws Exception {
		String pathname="d:"+SEPARATOR+"javaIo"+SEPARATOR+"fileOutputStream.txt";
		InputStream is=null;
		ByteArrayOutputStream byteOut=null;
		//方式一 单字节读取   此方式有两个问题 。1.字节数组长度根据文件大小定义，如果文件很大怎么办？ 2.当个字节进行读取效率太慢
		try {
			is=new FileInputStream(pathname);
			int len=0;
			byte[] b=new byte[(int)new File(pathname).length()];
			int temp=0;
			while(( len=is.read())!=-1){
				b[temp]=(byte)len;
				temp++;
			}
			is.close();
			System.out.println("testFileInputStream:"+new String(b, 0, b.length));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//方式二 一次读取指定字节大小的内容.
//		try {
//			is=new FileInputStream(pathname);
//			byteOut=new ByteArrayOutputStream();
//			byte[] b=new byte[1024];
//			int len=0;
//			int count=0;
//			while((len=is.read(b))!=-1){
//				byteOut.write(b, 0, len);
//				count++;
//			}
//			System.out.println("count:"+count+";str:"+new String(byteOut.toByteArray(),0,byteOut.toByteArray().length));
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			 if(is!=null){
//				 is.close();
//			 }
//			 if(byteOut!=null){
//				 byteOut.close();
//			 }
//			 
//		}
		
	}
	/**
	 * 将{source}目录下的文件拷贝到{dest}目录下。文件类型可以随便指定。可以说txt、jpg
	 * source 原目录 
	 * dest  目标目录 
	 * @throws Exception
	 */
	@Test
	public void testCopyFile() throws Exception {
		String source="d:"+SEPARATOR+"javaIo"+SEPARATOR+"source"+SEPARATOR;
		String dest="d:"+SEPARATOR+"javaIo"+SEPARATOR+"dest"+SEPARATOR;
		InputStream is=null;
		BufferedOutputStream os=null;
		try {
			File fileSrc=new File(source);
			//列出指定后缀名的文件信息
			File[] fileSrcList=fileSrc.listFiles(new FilenameFilter() {
				
				@Override
				public boolean accept(File dir, String name) {
					return name.endsWith(".png")||name.endsWith(".wmv");//指定文件后缀
				}
			});
			byte[] b=new byte[1024];
			int len=0;
			File destFile=new File(dest);
			if(!destFile.exists()){
				destFile.mkdirs();
			}
			String destpath=destFile.getAbsolutePath()+SEPARATOR;
			System.out.println("destpath:"+destpath);
			for (File file : fileSrcList) {
				is=new FileInputStream(source+file.getName());
				os=new BufferedOutputStream(new FileOutputStream(destpath+file.getName()));
				while((len=is.read(b))!=-1){
					os.write(b, 0, len);
					os.flush();
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(is!=null){
				is.close();
			}
			if(os!=null){
				os.close();
			}
		}
		System.out.println("文件复制成功");
	}
	

    
}
