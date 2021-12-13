package com.ants.model;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Slf4j
@Getter
public class Arc {
    protected static final double INITIAL = 1.0D;
    private Node nodeA;
    private Node nodeB;
    private int distance;
    private String desc;
    private double pheromoneLevel;

    public Arc(Node nodeA, Node NodeB, int distance) {
        this.nodeA = nodeA;
        this.nodeB = NodeB;
        this.pheromoneLevel = INITIAL;
        this.distance = distance;
        this.desc = new StringBuilder("NodeA ").append(this.nodeA.getName()).append(" NodeB ").append(this.nodeB.getName()).append(". distance: ").append(distance).toString();
        log.info(this.desc);
    }

    protected boolean isNodePresent(String nodeName){
        return nodeName != null && nodeA!=null && nodeB!=null && nodeA.getName().equals(nodeName) || nodeB.getName().equals(nodeName);

    }

    protected static List<String> getReachableNodeNames(String startingNodeName){
        List<Node> nodes = CarnivalProblem.ARCS.stream().map(Arc::getNodeA).toList();
        nodes.addAll(CarnivalProblem.ARCS.stream().map(Arc::getNodeB).toList());
        return nodes.stream().distinct().map(n->n.getName()).filter(name -> name.equals(startingNodeName)).toList();
    }

    public void addPheremones(double amt) {
        this.pheromoneLevel = this.pheromoneLevel + amt;
    }

    public void evaporatePheremones(double amt) {
        this.pheromoneLevel = this.pheromoneLevel - amt;
    }
}
