package com.ants.model;

import static com.ants.model.Arc.INITIAL;
import static com.ants.model.AntImp.DOLOP;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AntImpTest {
    public static final int DISTANCE = 5;
    @Autowired
    private AntImp antImp;

    @Test
    void startOnSomeRandomNode() {
        Arc arcOne = getArcOne();
        Node randomStartingNode = antImp.startOnSomeRandomNode(Lists.newArrayList(arcOne, getArcTwo()));
        assertTrue(randomStartingNode.getName().startsWith("from"));
        assertEquals(antImp.getDistanceTravelled(), DISTANCE);

    }

    @Test
    void dropPheremonesHappyPath() {
        Arc arcOne = getArcOne();
        antImp.dropPheremones(arcOne);
        assertEquals(INITIAL+DOLOP, arcOne.getPheromoneLevel());


    }
    private Arc getArcOne() {
        return new Arc(new Node("fromA"),new Node("toA"), DISTANCE);
    }
    private Arc getArcTwo() {
        return new Arc(new Node("fromB"),new Node("toB"), DISTANCE);
    }

}