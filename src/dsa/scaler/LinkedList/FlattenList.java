package dsa.scaler.LinkedList;


import java.util.List;

public class FlattenList {
    public static void main(String[] args) {
        int[] nums = {3,4,20,20,30};
        int[][] dataSet = {
                {7,7,8},
                {11},
                {22},
                {20,28,39},
                {30,31,39}
        };
        RightDownListNod testData = populateRight(nums,dataSet);
        FlattenList fl = new FlattenList();
        print(fl.flatten(testData));
    }

    RightDownListNod flatten(RightDownListNod root) {
        RightDownListNod current = root;
        while(current.right != null ){
            RightDownListNod rr = current.right.right;
            current = mergeTwoLists(current,current.right);
            current.right = rr;
        }
        return root;
    }

    public RightDownListNod mergeTwoLists(RightDownListNod A, RightDownListNod B) {
        if(A == null){
            return B;
        }

        if(B == null){
            return A;
        }
        A.right = null;

        RightDownListNod head;
        RightDownListNod secondaryList; // 14->15
        RightDownListNod primaryList; // 4 -> 5 ->  8 -> 11 -> 20
        if(A.val > B.val){
            head = B;
            secondaryList = A;
        }else{
            head = A;
            secondaryList = B;
        }
        primaryList = head;
        while(secondaryList!=null){
            while(primaryList.down != null && primaryList.down.val < secondaryList.val){
                primaryList = primaryList.down;
            }

            if(primaryList.down == null){
                primaryList.down = secondaryList;
                return head;
            }
            RightDownListNod pNext = primaryList.down;
            RightDownListNod sNext = secondaryList.down;
            primaryList.down  = secondaryList;
            secondaryList.down = pNext;
            secondaryList = sNext;
            primaryList = primaryList.down;
        }


        return head;
    }

    static class RightDownListNod {
        int val;
        RightDownListNod right, down;
        RightDownListNod(int x) {
            val = x;
            right = down = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val).append(" -> ");
            if(right == null){
                sb.append("null");
            }else{
                sb.append(right.val);
            }
            RightDownListNod current = down;
            while(current!=null){
                sb.append("\n|\n").append(current.val);
                current = current.down;
            }

            return sb.toString();
        }
    }

    static RightDownListNod populateRight(int[] firstList,int[][] downList){
        RightDownListNod head = populateLL(firstList[0],downList[0]);
        RightDownListNod current = head;
        for(int i=1;i<firstList.length;i++){
            current.right = populateLL(firstList[i],downList[i]);
            current = current.right;
        }
        return head;
    }
    static RightDownListNod populateLL(int num, int[] data){
        RightDownListNod ln = new RightDownListNod(num);
        RightDownListNod current = ln;
        for(int i=0;i<data.length;i++){
            current.down = new RightDownListNod(data[i]);
            current = current.down;
        }
        return ln;
    }

    static void print(RightDownListNod ll){
        RightDownListNod current = ll;
        while(current!=null){
            System.out.println(current);
            current = current.right;
        }
    }
}
