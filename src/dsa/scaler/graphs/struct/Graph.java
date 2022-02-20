package dsa.scaler.graphs.struct;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph<T> {
    ArrayList<T>[] neighbors;
    public Graph(int totalNodes){
        neighbors = new ArrayList[totalNodes+1];
        Arrays.fill(neighbors,new ArrayList<>());
    }


}
