package com.ants.model;

import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public sealed interface Ant permits AntImp {
    Node startOnSomeRandomNode(Collection<Arc> arcs);
    Node findMostEligableNode();
    void visitNextNodeRandomly();
    void dropPheremones(Arc arc);
    void visit(Node node);
}
