package com.ants.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.rmi.UnexpectedException;
import java.util.*;

@Getter
@Slf4j
@Service
public final class AntImp implements Ant {
    protected static final double DOLOP = 1;
    @Setter
    private List<Node> visited = new ArrayList<>();
    private double distanceTravelled = 0;

    @Override
    public Node startOnSomeRandomNode(Collection<Arc> arcs) {
        int randomIndex = new Random().nextInt(arcs.size());
        Arc randomArc = new ArrayList<Arc>(arcs).get(randomIndex);
        Node started = randomArc.getNodeA();

        visited.add(started);
        distanceTravelled += randomArc.getDistance();
        log.info("starting on {}", started.getName());
        return started;

    }

    @Override
    public Node findMostEligableNode() {
//        List<Node> nodes = CarnivalProblem.ARCS.stream().map(Arc::getNodeA).toList();
//        nodes.addAll(CarnivalProblem.ARCS.stream().map(Arc::getNodeB).toList());
//        nodes = nodes.stream().distinct().filter(name -> name.equals(visited[visited.length-1].getName())).toList();
        return null;
    }

    protected boolean isNodeUntravelled(String nodeName){
//        return !Arrays.stream(this.getVisited()).anyMatch(node -> {
//            if(node == null)
//                try {
//                    throw new UnexpectedException("node is null, for comparing with "+nodeName);
//                } catch (UnexpectedException e) {
//                    e.printStackTrace();
//                }
//            return node.getName().equals(nodeName);
//
//        });
//        while (visitedArrayList.remove(null));
        for(Node node: visited) {
            if (node.getName().equals(nodeName))
                return false;
        }
        return true;
    }

    @Override
    public void visitNextNodeRandomly() {

    }

    @Override
    public void dropPheremones(Arc arc) {
        arc.addPheremones(DOLOP);

    }

    @Override
    public void visit(Node node) {

        visited.add(node);
        log.info("{} elements in this array",visited.size());

    }
}
