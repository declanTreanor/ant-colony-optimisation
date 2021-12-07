package com.ants.model;

public sealed interface Ant permits AntImp {
    void dropPheremones();
}
