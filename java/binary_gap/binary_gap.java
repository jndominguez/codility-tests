// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    String binStr;
    
    public char shiftStr() {
        char poppedChar = this.binStr.charAt(0);
        if (this.binStr.length() == 1)
            this.binStr = "";
        else
            this.binStr = this.binStr.substring(1,this.binStr.length());
        return poppedChar;
    }
    
    public int solution(int N) {
        // write your code in Java SE 8
        binStr = Integer.toBinaryString(N);
        int zeroCount = 0;
        int zeroCountTmp = 0;
        char popChar;
        System.out.println("Binary: " + binStr);
        
        // find left One
        char leftOne = 'N';
        while (leftOne != '1' && binStr.length() > 0)
            leftOne = shiftStr();
            
        while (binStr.length() > 0) {
            popChar = shiftStr();
            if(popChar == '0')
                zeroCountTmp++;
            else {
                if (zeroCountTmp > zeroCount) 
                    zeroCount = zeroCountTmp;
                zeroCountTmp = 0;
            }
        }
            
        return zeroCount;
    }

}

class Test {
    public static void main (String[] args) {
      int number = 9;
      Solution mySolution = new Solution();
      System.out.println("Input: " + number);
      System.out.println("Result: " + mySolution.solution(number));
    }
}
