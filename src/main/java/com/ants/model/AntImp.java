package com.ants.model;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Getter
@Slf4j
@Service
public final class AntImp implements Ant {
    protected static final double DOLOP = 1;
    Node[] visited = new Node[6];
    private double distanceTravelled = 0;

    @Override
    public Node startOnSomeRandomNode(Collection<Arc> arcs) {
        int randomIndex = new Random().nextInt(arcs.size());
        Arc randomArc = new ArrayList<Arc>(arcs).get(randomIndex);
        Node started = randomArc.getFrom();
        visited[0] = started;
        distanceTravelled += randomArc.getDistance();
        log.info("starting on {}", started.getName());
        return started;

    }

    @Override
    public void visitNextNodeRandomly() {

    }

    @Override
    public void dropPheremones(Arc arc) {
        arc.addPheremones(DOLOP);

    }
}
