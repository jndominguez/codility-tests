import java.util.Arrays;

class Solution {
    
    public void rotateArray(int[] array) {
        int lastItem = array[array.length-1];
        for(int i=array.length-1; i > 0; i--)
            array[i] = array[i-1];
        array[0] = lastItem;
    }
    
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        if (A != null)
          if (A.length > 0)
              for(int i=0; i < K; i++)
                  rotateArray(A);
        return A;
    }
}

class Test {
  public static void main(String[] args) {
    int[] inputArray = {1, 2, 3, 4, 5};
    Solution mySolution = new Solution();

    System.out.println("Input: " + Arrays.toString(inputArray));
    int[] b = mySolution.solution(inputArray,3);
    System.out.println("Rotated: " + Arrays.toString(mySolution.solution(inputArray,3)) );
  }
}
