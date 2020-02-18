/**
* Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
* find the area of largest rectangle in the histogram.
*/

class largestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
     
           int sum = 0;
           int i=0;
        
           Stack<Integer> s = new Stack<>();
        
           while(i<heights.length)
           {
               if(s.isEmpty()||heights[i]>=heights[s.peek()])
               {
                   s.add(i++);
               }
               else
               {
                   int j = s.pop();
                   
                   if(s.isEmpty())
                   {
                        //System.out.println(i*heights[j]);
                        sum = Math.max(sum, i*heights[j]);
                   }
                   else
                   {
                      //  System.out.println((j-s.peek())*heights[j]);
                        sum = Math.max(sum , (i-s.peek()-1)*heights[j]);   
                   }
               }
           }
        
        while(!s.isEmpty())
        {
             int j = s.pop();
                   
             if(s.isEmpty())
             {
                // System.out.println(i*heights[j]);
                 sum = Math.max(sum, i*heights[j]);
             }
             else
             { 
                // System.out.println((j-s.peek())*heights[j]);
                 sum = Math.max(sum , (i-s.peek()-1)*heights[j]);
             }
        }
        
        return sum;
    }
}
