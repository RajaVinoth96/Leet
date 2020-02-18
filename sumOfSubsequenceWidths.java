/**
* Given an array of integers A, consider all non-empty subsequences of A.
*
* For any sequence S, let the width of S be the difference between the maximum and minimum element of S.
*
* Return the sum of the widths of all subsequences of A. 
*
* As the answer may be very large, return the answer modulo 10^9 + 7.
*/

class sumOfSubsequenceWidths {
 
    long mod = 1000000007;
    
    public int sumSubseqWidths(int[] A) {
    
         Arrays.sort(A);
       
        long ans = 0;
        long c = 1;
        
        for(int i=0;i<A.length;i++,c=(c<<1)% mod)
            ans = (ans + A[i]*c - A[A.length-1-i]*c)%mod;
        
        return (int)((ans+mod)%mod);    
    }
}
