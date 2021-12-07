package com.ants.model;

import java.util.Set;

public class CarnivalProblem {

    Set<Arc> arcs;

    public static void main(String[] args) {
        Arc circusBalloon = new Arc(new Node("circus"), new Node("balloon"), 5);
        Arc circusBumpers = new Arc(new Node("circus"), new Node("bumpers"), 7);
        Arc balloonBumpers = new Arc(new Node("balloon"), new Node("bumpers"),5);

    }
}
