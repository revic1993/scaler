package dsa.scaler.math.prime;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;

public class LuckNumber {
    static HashMap<Integer,Divisor> numbers = new HashMap<>();
    public static void main(String[] args) {
        int[] testSet = new int[]{
                25,
                78
        };
        for(int testData : testSet){
            System.out.println(testData + " => "+solve(testData));
        }
    }

    public static int solve(int A) {
        for(int i=2;i<=A;i++){
            numbers.put(i,new Divisor(i));
        }

        for(int i=2;i<=A;i++){
            if(numbers.get(i).isPrimePower){
                continue;
            }
            int lastPrimePower = i*i;
            for(int j=i;j<=A;j+=i){
                if(i == j){
                    if(numbers.get(j).prime1 == 0){
                        numbers.get(j).prime1 = i;
                    }
                    continue;
                }

                if(j == lastPrimePower){
                    numbers.get(j).addDivisor(i);
                    numbers.get(j).isPrimePower = true;
                    lastPrimePower *= i;
                    continue;
                }

                numbers.get(j).addDivisor(i);
            }
        }
        numbers.entrySet().removeIf(integerDivisorEntry -> integerDivisorEntry.getValue().isDeletable());
        System.out.println(new JSONObject(numbers));

        return numbers.size();
    }

    static class Divisor{
        int prime1;
        int prime2;
        int prime3;
        boolean isPrimePower;
        int num;
        Divisor(int num){
            this.num = num;
        }

        boolean isDeletable(){
            return !(prime1!= 0 && prime2!=0 && prime3==0);
        }

        public void addDivisor(int number){
            Divisor divisor = numbers.get(number);
            updateDivisor(divisor.prime1);
            updateDivisor(divisor.prime2);
            updateDivisor(divisor.prime3);
        }

        public void updateDivisor(int number){
            if(this.isPrimePower || number == 0){
                return;
            }
            if(prime1 == 0 || number == prime1){
                prime1 = number;
                return;
            }


            if( prime2 == 0 || number == prime2){
                prime2 = number;
                return;
            }

            if(prime3 == 0){
                prime3 = number;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Divisor divisor = (Divisor) o;
            return this.num == divisor.num;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num);
        }

        @Override
        public String toString() {
            return "{" +
                    "prime1:" + prime1 +
                    ", prime2:" + prime2 +
                    ", prime3:" + prime3 +
                    ", isPrimePower : " + isPrimePower +
                    '}';
        }

    }
}
