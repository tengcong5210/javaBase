package com.java.newFeatures;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @创建人 tengcc
 * @创建时间 2018/8/12
 * @描述
 */
public class ListStreamDemo {

    @Test
    public void testListStream(){
        ListStreamDTO streamDTO1=new ListStreamDTO(1,"张三");
        ListStreamDTO streamDTO2=new ListStreamDTO(2,"李四");
        ListStreamDTO streamDTO3=new ListStreamDTO(3,"王二");
        List<ListStreamDTO> list=new ArrayList<>();
        list.add(streamDTO1);
        list.add(streamDTO2);
        list.add(streamDTO3);
        Optional<ListStreamDTO> opt=list.stream().filter(dto->3==dto.getId()).findFirst();
        if(opt.isPresent()){
            ListStreamDTO xxx=opt.get();
            System.out.println("11111111:"+xxx);
        }else{
            System.out.println("xxxxx");
        }

    }

    @Test
    public void testStreamOf(){
        String ips="111111,22222";

        //step1: 分解Stream.of()方法



        List<DeployResult> deployResults = Stream.of(ips.split(",")).map(ip -> {
            DeployResult deployResult = new DeployResult();
            deployResult.setIp(ip);
            return deployResult;
        }).collect(Collectors.toList());

        System.out.println("添加list结果:"+ JSON.toJSONString(deployResults));
    }
}


class ListStreamDTO{
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ListStreamDTO(){

    }
    public ListStreamDTO(Integer id,String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString() {
        return "ListStreamDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class DeployResult{


    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}