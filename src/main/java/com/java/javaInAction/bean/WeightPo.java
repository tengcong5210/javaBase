package com.java.javaInAction.bean;

import java.io.Serializable;

/**
 * @author tengcc
 * @date 2019/5/14
 */
public class WeightPo implements Serializable {

    private static final long serialVersionUID = 8575452383036595298L;
    /**
     * 权重
     */
    private int weight;
    /**
     * 得分
     */
    private int score;

    public WeightPo(int weight, int score) {
        this.weight = weight;
        this.score = score;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}