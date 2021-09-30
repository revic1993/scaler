package dsa.math;

public class FindTiles {

    public static void main(String[] args) {
        System.out.println(solve(87,5,39));
    }

    public static int solve(int A, int B, int C) {
        int smaller = A < B ? A : B;
        int larger = B >= A ? B : A;

        int tilesRequiredForSmaller = smaller%C == 0 ? smaller/C : (int)(Math.floor(smaller/C)+1);
        int areaLeftToCover = larger - C;

        if(areaLeftToCover < 0){
            return tilesRequiredForSmaller;
        }

        int tilesRequiredForRest = areaLeftToCover%C == 0 ? areaLeftToCover/C : (int)(Math.floor(areaLeftToCover/C)+1);
        return tilesRequiredForSmaller * (tilesRequiredForRest+1);
    }
}
