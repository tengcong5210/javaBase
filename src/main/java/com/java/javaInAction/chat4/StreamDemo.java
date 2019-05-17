package com.java.javaInAction.chat4;


import com.alibaba.fastjson.JSON;
import com.java.javaInAction.bean.WeightPo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @创建人 tengcc
 * @创建时间 2019/4/29
 * @描述
 */
public class StreamDemo {

    public static void main(String[] args) {

        List<Dish> menu= Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)

        );

        List<Dish> result=menu.stream()
                .filter(d->d.getType()==Dish.Type.MEAT)
                .filter(d->d.getCalories()>700)
                .limit(12)
                .collect(toList());

        result.stream().forEach(o->{System.out.println("结果："+JSON.toJSONString(o));});
        //1.需求 赛选出热量大于300的前三个菜品
        List<String> threeHighCaloricDishNames=menu.stream()
                .filter((Dish d)->d.getCalories()>300)
                .map((Dish d)->d.getName())
                .limit(3)
                .collect(toList());

        //2、再简洁的写法
        List<String> threeHighCaloricDishNames2=menu.stream()
                //从流中排除某些元素
                .filter(d->d.getCalories()>300)
                //将元素换行成其他形式或提取信息
                .map(Dish::getName)
                //截断流，使其元素不超过给定数量
                .limit(3)
                //将流转换成其他形式
                .collect(toList());

        System.out.println("赛选结果:"+ JSON.toJSONString(threeHighCaloricDishNames));

        //3.注意：流只能被消费一次
        List<String> strings=Arrays.asList("java","str","xxxx");
        Stream<String> strs=strings.stream();
        strs.forEach(System.out::println);
        //再次消费则会报错
        //strs.forEach(System.out::println);

        //4. 筛选素菜
        List<Dish> vegetarian=menu.stream().filter(Dish::isVegetarian).collect(toList());


        //5. 筛选出下列集合中的所有偶数，并确保没有重复  distinct 去重
        List<Integer> numbers=Arrays.asList(1,2,5,9,2,5,8,7);
        numbers.stream()
                .filter(i-> i%2==0)
                .distinct()
                .forEach(System.out::println);
        //5.1 计算numbers集合之和
        int sum=numbers.stream().reduce(Integer::sum).orElse(0);
        System.out.println("计算集合之和:"+sum);


        //6. 跳过超过300卡路里的头两道菜.
        menu.stream()
                .filter(d->d.getCalories()>300)
                .skip(2)
                .forEach(System.out::println);

        // 赛选前两个荤菜
        List<Dish> meatList=menu.stream()
                .filter(d->d.getType()==Dish.Type.MEAT)
                .limit(2)
                .collect(toList());


        //7、计算集合中的值相加
        List<WeightPo> weightPos=Arrays.asList(new WeightPo("aaa",0,6),
                new WeightPo("bbb",0,5),
                new WeightPo("ccc",30,2),
                new WeightPo("ddd",40,1));
        //A60 B100 C60 D40
        //A0 B0 C30 D40
        // A60 B160 C220 D260
        //[0,0] [0,0],[0,30],[30,70]
        List<Integer> ss=weightPos.stream().map(o->o.getWeight()).collect(toList());
        //System.out.println("计算集合中的值相加2222:"+ss.stream().reduce(Integer::sum));
        int weightSum=ss.stream().reduce(Integer::sum).orElse(0);
        int raNumber=new Random().ints(1,1,weightSum).findFirst().getAsInt();
        System.out.println("weightSum="+weightSum+";raNumber="+raNumber);
        int min=0;
        for(WeightPo po:weightPos){
            int max=min+po.getWeight();
            if(raNumber>=min&&raNumber<=max){
                System.out.println("得到权重里的数据："+po.getSpId()+";ranumer:"+raNumber+";min="+min+";max:"+max);
            }
            min=max+1;
        }
        //10 5 4 1
        Integer sums=weightPos.stream().map(o->o.getWeight()*o.getScore()).reduce(Integer::sum).orElse(0);
        System.out.println("计算集合中的值相加:"+sums);
    }


}

