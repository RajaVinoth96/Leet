/**
* A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. 
* write a program to output the skyline formed by these buildings collectively
*
* Buildings Skyline Contour
* The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively,
* and Hi is its height. 
* It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0.
* You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
* 
* The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] 
* that uniquely defines a skyline.
* A key point is the left endpoint of a horizontal line segment.
* Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, 
* and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
*
* Notes:
* The number of buildings in any input list is guaranteed to be in the range [0, 10000].
* The input list is already sorted in ascending order by the left x position Li.
* The output list must be sorted by the x position.
* There must be no consecutive horizontal lines of equal height in the output skyline. 
* For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; 
* the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
*/

class theSkylineProblem {

   class Mycomp implements Comparator<int[]>
   {
	   
	  public int compare(int[] a , int[] b)
	   {
		   return b[2]-a[2];
	   }
   }
   
   PriorityQueue<int[]>  pq = new PriorityQueue<>(new Mycomp());
   TreeMap<Integer,Integer>  map = new TreeMap<>();
   List<int[]> sol = new ArrayList<>();
    
    public List<int[]> getSkyline(int[][] buildings) {
        
        
        if(buildings.length==0)
            return sol;
  
        if(buildings.length==1)
        {
            sol.add(new int[]{buildings[0][0],buildings[0][2]});
            sol.add(new int[]{buildings[0][1],0});
            return sol;
        }
     
	   int ep = buildings[0][1];
	  int st = buildings[0][2];
	  
	  map.put(buildings[0][0], st);
	  pq.add(buildings[0]);
	  
	  
	  int[] t = buildings[0];
	  
	  for(int i=1;i<buildings.length;i++)
	  {
		 if(ep<buildings[i][0])
		 {
			 while(!pq.isEmpty())
			 {
				 t = pq.poll();
				 if(t[1]<=ep)
					 continue;
				 if(t[1]>=buildings[i][0])
				 {
					 if(ep<buildings[i][0])
					 {
						 map.put(ep, t[2]);
						 ep = t[1];
						 st = t[2];
					 }
					 else if(t[2]>buildings[i][2])
					 {
						 map.put(ep, t[2]);
						 st = t[2];
						 ep = t[1];
					 }
					 else if(t[2]==buildings[i][2])
					 {
						 ep = 	Math.max(t[1], buildings[i][1]);
					 }	 
					 pq.add(t);
					 break;
				 }
				 if(t[2]==st)
					 ep = Math.max(ep, t[1]);
				 else
				 {
					 map.put(ep, t[2]);
					 ep = t[1];
					 st = t[2];
				 }
			 }
			 
			 if(ep<buildings[i][0])
			 {
				 map.put(ep, 0);
				 st = 0;
			 }
			 
		 }
		 
	
		 if(st<buildings[i][2])
		 {
			 map.put(buildings[i][0], buildings[i][2]);
			 ep = buildings[i][1];
			 st = buildings[i][2];
			 
		 }
		 
		 if(st == buildings[i][2])
			 ep = Math.max(ep, buildings[i][1]);
		 
			 pq.add(buildings[i]);
	  }
	  
	  while(!pq.isEmpty())
		 {
		
			 t = pq.poll();
			 if(t[1]<=ep)
				 continue;
			 if(t[2]==st)
				 ep = Math.max(ep, t[1]);
			 else
			 {
				 map.put(ep, t[2]);
				 ep = t[1];
				 st = t[2];
			 }
		 }
	  map.put(ep, 0);
        
        
        Iterator i = map.keySet().iterator();
        while(i.hasNext())
        {
            int key = (int)i.next();
            int val = map.get(key);
            sol.add(new int[]{key,val});
        }
        
        return sol;
        
    }
}
