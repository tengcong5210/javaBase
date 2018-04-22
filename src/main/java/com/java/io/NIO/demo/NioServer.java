package com.java.io.NIO.demo;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by ibm on 2017/9/16.
 */
public class NioServer {
  private int port=8080;
  private InetSocketAddress address=null;
  private Selector selector;

  public NioServer(int port){

    try {
     this.port=port;
     //创建套接字地址，其中 IP 地址为通配符地址，端口号为指定值。
     address=new InetSocketAddress(this.port);
     //打开大门
     ServerSocketChannel server= ServerSocketChannel.open();
     server.bind(address);
     //默认为阻塞，手动设置为足色
     server.configureBlocking(false);

     //开门营业啦
        selector=Selector.open();

        server.register(selector, SelectionKey.OP_ACCEPT);
        System.out.print("服务器准备就绪，监听端口是： "+this.port);

    }catch (Exception e){
        e.printStackTrace();
    }

  }

  public void listen(){
      try {
         while (true){
             int wait=this.selector.select();

             if(wait==0){
                 continue;
             }
             Set<SelectionKey> keys=this.selector.selectedKeys();

             Iterator<SelectionKey> iterator=keys.iterator();
             while (iterator.hasNext()){
                    SelectionKey key= iterator.next();
                    process(key);
                    iterator.remove();

             }
             continue;
         }

      }catch (Exception e){
          e.printStackTrace();
      }
  }

    private void process(SelectionKey key)throws Exception {
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        if(key.isAcceptable()){
            ServerSocketChannel server=(ServerSocketChannel) key.channel();
            SocketChannel client=server.accept();
            client.configureBlocking(false);
            client.register(selector,SelectionKey.OP_READ);
        }else if(key.isReadable()){
            SocketChannel client=(SocketChannel) key.channel();
            int len=client.read(buffer);
            if(len>0){
                buffer.flip();
                String content=new String(buffer.array(),0,len);

                client.register(selector,SelectionKey.OP_WRITE);
                buffer.clear();
            }
        }
    }

    public static void main(String[] args){
            new NioServer(8080).listen();
    }
}
