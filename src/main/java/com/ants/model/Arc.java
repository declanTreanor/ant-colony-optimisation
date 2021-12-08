package com.ants.model;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Arc {
    protected static final double INITIAL = 1.0D;
    private Node from;
    private Node to;
    private int distance;
    private String desc;
    private double pheromoneLevel;

    public Arc(Node from, Node to, int distance) {
        this.from = from;
        this.to = to;
        this.pheromoneLevel = INITIAL;
        this.distance = distance;
        this.desc = new StringBuilder("from ").append(this.from.getName()).append(" to ").append(this.to.getName()).toString();
        log.info(this.desc);
    }

    public void addPheremones(double amt) {
        this.pheromoneLevel = this.pheromoneLevel + amt;
    }

    public void evaporatePheremones(double amt) {
        this.pheromoneLevel = this.pheromoneLevel - amt;
    }
}
