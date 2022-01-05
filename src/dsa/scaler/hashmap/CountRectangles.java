package dsa.scaler.hashmap;

import java.util.HashSet;

public class CountRectangles {

    public static void main(String[] args) {
        CountRectangles cr = new CountRectangles();
        System.out.println(cr.solve(
                new int[]{38, 36, 48, 42, 36, 56, 38, 48, 40, 24, 48, 32, 22, 54, 22, 42, 34, 54, 52, 36, 52, 38, 36, 30, 30, 44, 46, 58, 56, 52, 48, 34, 36, 42, 50, 34, 28, 44, 44, 60, 56, 32, 48, 22, 56, 38, 42},
                new int[]{58, 42, 30, 60, 50, 42, 40, 24, 54, 28, 52, 54, 28, 32, 42, 54, 38, 38, 54, 24, 30, 60, 44, 40, 26, 56, 28, 60, 34, 50, 48, 28, 56, 34, 48, 26, 30, 22, 52, 36, 24, 50, 42, 58, 54, 54, 48})
        );
    }

    public int solve(int[] A,int[] B){
        HashSet<String> coordinates = new HashSet<>();
        HashSet<String> resultSet = new HashSet<>();
        for(int i=0;i<A.length;i++){
            coordinates.add(A[i]+"_"+B[i]);
        }
        for(int i=0;i<A.length-3;i++){
            int fX = A[i];
            int fY = B[i];
            for(int j=i+1;j<A.length;j++){
                int sX = A[j];
                int sY = B[j];
                if(sX == fX || sY == fY){
                    continue;
                }

                String firstInt = fX+"_"+sY;
                String secondInt = sX+"_"+fY;
                if(coordinates.contains(firstInt) && coordinates.contains(secondInt)){
                    System.out.println("found "+firstInt+" and "+secondInt + " for "+ fX+","+fY +" and "+sX+","+sY);
                    StringBuilder result = new StringBuilder();
                    if(sY > fY){
                            result.append(fX).append("_").append(fY).append("_")
                                    .append(fX).append("_").append(sY).append("_")
                                    .append(sX).append("_").append(sY).append("_")
                                    .append(sX).append("_").append(fY);
                    }else {
                        result.append(fX).append("_").append(sY).append("_")
                                .append(fX).append("_").append(fY).append("_")
                                .append(sX).append("_").append(fY).append("_")
                                .append(sX).append("_").append(sY);
                    }
                    resultSet.add(result.toString());
                }
            }
            coordinates.remove(fX+"_"+fY);
        }
        return resultSet.size();
    }
}
