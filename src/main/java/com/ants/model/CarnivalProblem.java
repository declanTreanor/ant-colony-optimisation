package com.ants.model;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Predicate;

@Slf4j
public class CarnivalProblem {


    protected final static Arc CIRCUSBALLOON = new Arc(new Node("circus"), new Node("balloon"), 8);
    protected final static Arc CIRCUSBUMPERS = new Arc(new Node("circus"), new Node("bumpers"), 7);
    protected final static Arc CIRCUSFERRIS = new Arc(new Node("circus"), new Node("ferris"), 4);
    protected final static Arc CIRCUSSWINGS = new Arc(new Node("circus"), new Node("swings"), 6);
    protected final static Arc CIRCUSCAROUSEL = new Arc(new Node("circus"), new Node("carousel"), 4);

    protected final static Arc FERRISBALLOON = new Arc(new Node("ferris"), new Node("balloon"), 5);
    protected final static Arc FERRISBUMPERS = new Arc(new Node("ferris"), new Node("bumpers"), 7);
    protected final static Arc FERRISSWINGS = new Arc(new Node("ferris"), new Node("swings"), 6);
    protected final static Arc FERRISCAROUSEL = new Arc(new Node("ferris"), new Node("carousel"), 4);

    protected final static Arc BALLOONCAROUSEL = new Arc(new Node("balloon"), new Node("carousel"), 5);
    protected final static Arc BALLOONBUMPERS = new Arc(new Node("balloon"), new Node("bumpers"), 7);
    protected final static Arc BALLOONSWINGS = new Arc(new Node("balloon"), new Node("swings"), 6);

    protected final static Arc SWINGSBUMPERS = new Arc(new Node("swings"), new Node("bumpers"), 7);
    protected final static Arc SWINGSCAROUSEL = new Arc(new Node("swings"), new Node("carousel"), 6);

    protected final static Arc BUMPERSCAROUSEL = new Arc(new Node("bumpers"), new Node("carousel"), 7);

    protected final static Set<Arc> ARCS = Set.of(CIRCUSBALLOON, CIRCUSBUMPERS, CIRCUSFERRIS, CIRCUSSWINGS, CIRCUSCAROUSEL, FERRISBALLOON,
            FERRISBUMPERS, FERRISSWINGS, FERRISCAROUSEL, BALLOONCAROUSEL, BALLOONBUMPERS, BALLOONSWINGS, SWINGSBUMPERS,
            SWINGSCAROUSEL, BUMPERSCAROUSEL);

    /**
     * @param ant
     * @param startingNodeName
     * @return
     */
    protected static Collection<Arc> findUsableArcsSortedByLengthAscending(AntImp ant, String startingNodeName) {
//        Comparator<Arc> lengthComparator = (a1, a2) -> {
//            if (a1.getDistance() < a2.getDistance())
//                return a2.getDistance();
//            else
//                return a1.getDistance();
//        };
        Collection<Arc> allTraversable = findAllTraversableArcs(startingNodeName);
        log.info("about to blow up...allTraversable {}",allTraversable.stream().map(Arc::getDesc).toList());
        return ARCS.stream().filter(arc -> arc.isNodePresent(startingNodeName)).filter(
                snn -> ant.isNodeUntravelled(snn.getNodeA().getName())).filter(allTraversable::contains).sorted(Comparator.comparing(Arc::getDistance)).toList();
    }

    protected static Collection<Arc> findAllTraversableArcs(String startingNode) {
        Predicate<Arc> isNodeA = arc -> arc.getNodeA().getName().equals(startingNode);
        Predicate<Arc> isNodeB = arc -> arc.getNodeB().getName().equals(startingNode);

        return ARCS.stream().filter(isNodeA.or(isNodeB)).toList();
    }

}
