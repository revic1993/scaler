package dsa.scaler.hashmap;

import java.util.*;

public class PointsOnSameLine {
    public static void main(String[] args) {
        PointsOnSameLine posl = new PointsOnSameLine();
        System.out.println(posl.solve(new ArrayList<>(List.of(6, -5, 3, -6, 3, -9, -8, -7)),new ArrayList<>(List.of(5, 0, -8, 1, -1, 6, 3, -3))));
    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int max = Integer.MIN_VALUE;

        for(int i=0;i<A.size();i++){
            int fx = A.get(i);
            int fy = B.get(i);
            int horizontalMax = 1;
            int verticalMax = 1;
            FreqMap<String> slopeMap = new FreqMap<>();
            int dup = 1;
            for(int j=i+1;j<A.size();j++){
                int sx = A.get(j);
                int sy = B.get(j);
                if(sx == fx && sy == fy){
                    dup++;
                    continue;
                }

                if(sx == fx || sy == fy){
                    horizontalMax += sx == fx ? 1 : 0;
                    verticalMax += sy == fy ? 1 : 0;
                    continue;
                }

                int dx = fx-sx;
                int dy = fy-sy;
                String neg = dx >= 0 && dy >= 0 || dx <= 0 && dy <=0 ? "" : "-";
                int gcd = findGCD(Math.abs(dx),Math.abs(dy));
                slopeMap.add(neg+(Math.abs(dx)/gcd)+"_"+(Math.abs(dy)/gcd));
            }
            max = Math.max(dup,max);
            max = Math.max(max,horizontalMax);
            max = Math.max(max,verticalMax);
            for(String key : slopeMap.keys()){
                max = Math.max(max,slopeMap.getFreq(key)+dup);
            }
        }

        return max;
    }

    int findGCD(int A, int B){
        if(A==0 || B==0){
            return A == 0 ? B : A;
        }

        if(A==1 || B==1){
            return 1;
        }

        if(A > B){
            int temp = A;
            A = B;
            B = temp;
        }

        while(A > 0){
            int t = B%A;
            B = A;
            A = t;
        }

        return A == 0 ? B : A;
    }

    class FreqMap<T>{
        HashMap<T,Integer> freqMap;

        public FreqMap(){
            this.freqMap = new HashMap<>();
        }

        public HashMap<T,Integer> getMap(){
            return this.freqMap;
        }

        public void addAll(List<T> A){
            for(T a : A){
                this.add(a);
            }
        }

        public void add(T key){
            if(freqMap.containsKey(key)){
                freqMap.put(key,freqMap.get(key)+1);
                return;
            }
            freqMap.put(key,1);
        }

        public void remove(T key,int deleteVal){
            if(!freqMap.containsKey(key)){
                return;
            }

            if(freqMap.get(key)-1 == deleteVal){
                freqMap.remove(key);
                return;
            }
            freqMap.put(key, freqMap.get(key)-1);
        }

        public int getFreq(T key){
            if(!freqMap.containsKey(key)){
                return -1;
            }
            return freqMap.get(key);
        }

        public Set<T> keys(){
            return freqMap.keySet();
        }

        public void remove(T key){
            if(!freqMap.containsKey(key)){
                return;
            }

            freqMap.put(key, freqMap.get(key)-1);
        }

        @Override
        public String toString() {
            return freqMap.toString();
        }
    }
}
