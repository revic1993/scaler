package dsa.scaler.trees.segmented_tree;

public class RangeMinimumQuery {

    public static void main(String[] args) {

    }
    public int[] solve(int[] A, int[][] B) {
        int[] result = new int[B.length];
        int[] tree = new int[(2*A.length)+2];
        buildSegmentTree(0,0,A.length,A,tree);
        return result;
    }

    void buildSegmentTree(int index,int start,int end, int[] A,int[] tree){
        if(start == end){
            tree[index] = A[start];
            return;
        }

        int mid = (start+end) >> 1;
        int left = (index << 1) + 1;
        int right = left + 1;
        buildSegmentTree(left,start,mid-1,A,tree);
        buildSegmentTree(right,mid+1,end,A,tree);
        tree[index] = Math.min(tree[left],tree[right]);
    }

    int findMinQuery(int index,int start,int end, int L, int R, int[] tree){
        if(L <= start && R >= end){
            return tree[index];
        }

        if(L > end || R < start){
            return Integer.MAX_VALUE;
        }
        int mid = (start+end) >> 1;
        int left = (index << 1) + 1;
        int right = left + 1;
        int leftMin = findMinQuery(left,start,mid-1,L,R,tree);
        int rightMin = findMinQuery(right,mid+1,end,L,R,tree);
        return Math.min(leftMin,rightMin);
    }

    void updateAtIndex(int updateIndex,int[] tree){
        int left = (updateIndex << 1) + 1;
        int right = left + 1;
        tree[updateIndex] = Math.min(tree[left],tree[right]);
        if(updateIndex == 0){
            return;
        }
        int rootIndex = (updateIndex-1) >> 1;
        updateAtIndex(rootIndex,tree);
    }
}
