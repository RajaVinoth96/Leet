/**
* Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.
*
* If there is no non-empty subarray with sum at least K, return -1.
*/

class shortestSubarrayWithSumAtLeastK {
    public int shortestSubarray(int[] A, int K) {
     
        int[] sum = new int[A.length+1];
        
        PriorityQueue<Integer> p = new PriorityQueue<Integer>((a,b)->(sum[a]-sum[b]));
        
        int min = Integer.MAX_VALUE;
        
        int i=0,start=0;
        
        while(i<A.length && A[i]<0)
        {
            p.add(i++);
        }
        
        sum[i] = A[i];
        
        if(sum[i]==K)
            return 1;
        
        p.add(i);
        
        i++;
        
        while(i<A.length)
        {
            sum[i] = sum[i-1] + A[i];
          
            if(sum[i]<0)
            {
                sum[i]=0;
                p.add(i++);
                continue;
            }
            
            if(sum[i]>=K)
            {
                min = Math.min(min,i+1);
               
                while(p.size()>0)
                {
                    if(sum[i]-sum[p.peek()]<K)
                        break;
                    min = Math.min(min,i-p.poll());
                }
                
            }
            
            p.add(i);
            i++;
        }
        
        return (min==Integer.MAX_VALUE)?-1:min;
    }
}
