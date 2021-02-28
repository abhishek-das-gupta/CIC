package com.cic.graphs.deadlock;

import java.util.List;

public class GraphVertex {
    public enum Color  {WHITE,BLACK,GRAY};
    Color color;
    List<GraphVertex> edges;

}
