package com.java.javaInAction.bean;

import java.io.Serializable;

/**
 * @author tengcc
 * @date 2019/5/14
 */
public class WeightPo implements Serializable {

    private static final long serialVersionUID = 8575452383036595298L;
    /**
     * 供应商Id
     */
    private String spId;
    /**
     * 权重
     */
    private int weight;
    /**
     * 得分
     */
    private int score;

    public WeightPo(String spId,int weight, int score) {
        this.spId=spId;
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

    public String getSpId() {
        return spId;
    }

    public void setSpId(String spId) {
        this.spId = spId;
    }
}