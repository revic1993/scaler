package dsa.scaler.graphs.struct;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {
        public int label;
        public List<UndirectedGraphNode> neighbors;
        public UndirectedGraphNode(int x) { this.label = x; this.neighbors = new ArrayList<>(); }

        @Override
        public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                for(UndirectedGraphNode neighbor : neighbors){
                        stringBuilder.append(neighbor.label+",");
                }
                return "{ label : "+this.label+", neighbors : "+stringBuilder+" }";
        }
}
