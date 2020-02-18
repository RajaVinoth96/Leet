/**
* (This problem is an interactive problem.)
* You may recall that an array A is a mountain array if and only if:
* A.length >= 3
* There exists some i with 0 < i < A.length - 1 such that:
* A[0] < A[1] < ... A[i-1] < A[i]
* A[i] > A[i+1] > ... > A[A.length - 1]
* Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target.  If such an index doesn't exist, return -1.
* You can't access the mountain array directly.  You may only access the array using a MountainArray interface:
* MountainArray.get(k) returns the element of the array at index k (0-indexed).
* MountainArray.length() returns the length of the array.
* Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
*/

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class findInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        int len = mountainArr.length();
        
        int mid = getInter(mountainArr,0,len-1);
        
        System.out.println("mid " + mid);
        
        int sl = getLeftIndex(mountainArr,0,mid,target);
        
         System.out.println("sl " + sl);
        
        int sr = getRightIndex(mountainArr,mid+1,len-1,target);    
        
        System.out.println("sr " + sr);
        
        if(sl==-1 && sr ==-1)
            return -1;
        
        if(sl==-1)
            return sr;
        
        if(sr==-1)
            return sl;
        
        return Math.min(sl,sr);
      
    }
    
    int getInter(MountainArray mountainArr,int st , int en)
    {   
       
        while(st<en)
        {
            int mid = (st+en)/2;
            int m = mountainArr.get(mid);
            int ms = mountainArr.get(mid-1);
            int me = mountainArr.get(mid+1);
            
            if(m>ms && m>me)
            {
                return mid;
            }
            else if(m>me)
            {
                en = mid;
            }
            else
            {
                st = mid;
            }
        }
        
        return -1;
    }
    
    int getLeftIndex(MountainArray mountainArr,int st , int en,int target)
    {
        // System.out.println("hereleft");
        

            if(mountainArr.get(st)==target)
            {
                return st;
            }
        
        if(mountainArr.get(en)==target)
            {
                return en;
            }
        
        
         while(st<en)
        {
            int mid = (st+en)/2;
            int m = mountainArr.get(mid);
            
            if(m==target)
            {
                return mid;
            }
            else if(m>target)
            {
                en = mid;
            }
            else
            {
                st = mid;
            }
             
             if(st==en-1)
                 break;
        }
        
        return -1;
    }
    
    int getRightIndex(MountainArray mountainArr,int st , int en,int target)
    {
       
        
         if(mountainArr.get(st)==target)
            {
                return st;
            }
        
        if(mountainArr.get(en)==target)
            {
                return en;
            }
        
         while(st<en)
        {
            int mid = (st+en)/2;
            int m = mountainArr.get(mid);
           
            
            if(m==target)
            {
                return mid;
            }
            else if(m>target)
            {
                en = mid;
            }
            else
            {
                st = mid;
            }
             
             if(st==en-1)
                 break;
        }
        
        return -1;
    }
}
