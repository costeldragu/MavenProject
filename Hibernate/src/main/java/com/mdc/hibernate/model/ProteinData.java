package com.mdc.hibernate.model;

public class ProteinData {
    private int total;
    private int goal;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    @Override
    public String toString() {
        return "ProteinData{" +
                "total=" + total +
                ", goal=" + goal +
                '}';
    }
}
