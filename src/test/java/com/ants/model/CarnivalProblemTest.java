package com.ants.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;

/**
 *
 */
class CarnivalProblemTest {

    @Test
    void findUsableArcsSortedByLengthAscending() {
        AntImp ant = new AntImp();
        Node testNode = new Node("circus");   //visited
        ant.visit(testNode);                        //visited
        Collection<Arc> arcs = CarnivalProblem.findUsableArcsSortedByLengthAscending(ant, "balloon");
        arcs.stream().map(Arc::getDesc).forEach(System.out::println);
        Assertions.assertEquals(4, arcs.size());
    }
}