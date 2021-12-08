package com.ants.model;

import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public sealed interface Ant permits AntImp {
    Node startOnSomeRandomNode(Collection<Arc> arcs);
    void visitNextNodeRandomly();
    void dropPheremones(Arc arc);
}
