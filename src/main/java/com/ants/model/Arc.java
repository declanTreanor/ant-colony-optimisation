package com.ants.model;

import lombok.Getter;

@Getter
public class Arc {
    private Node from;
    private Node to;
    private int distance;
    private double pheromoneLevel;

    public Arc(Node from, Node to, int distance) {
        this.from = from;
        this.to = to;
        this.pheromoneLevel = 1.0D;
        this.distance = distance;
    }

    public void addPheremones(double amt) {
        this.pheromoneLevel = this.pheromoneLevel + amt;
    }

    public void evaporatePheremones(double amt) {
        this.pheromoneLevel = this.pheromoneLevel - amt;
    }
}
