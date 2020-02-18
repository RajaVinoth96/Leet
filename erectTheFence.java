/**
* There are some trees, where each tree is represented by (x,y) coordinate in a two-dimensional garden. 
* Your job is to fence the entire garden using the minimum length of rope as it is expensive. 
* The garden is well fenced only if all the trees are enclosed.
* Your task is to help find the coordinates of trees which are exactly located on the fence perimeter.
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
 
 
class erectTheFence {
    
    List<Point> sol;
    public List<Point> outerTrees(Point[] points) {
        
        sol = new ArrayList<>();
        
        if(points.length<=3)
        {
            for(Point p : points)
                sol.add(p);
            
            return sol;
        }
        
        Arrays.sort(points, (a, b) -> (a.x==b.x)?a.y-b.y:a.x-b.x);
      
           
	       sol.add(points[0]);
	       sol.add(points[points.length-1]);
	        
	       helper_up(points[0] , points[points.length-1], points);
	       helper_down(points[0] , points[points.length-1] , points);
	       
	        return sol;     
    }
    
    
      void helper_up(Point a , Point b, Point[] points)
		 {
			  Point cur = a;
			  Point s = cur;
			  Point e = next(0,points);
			  double m , c;
			  if(s.x == e.x)
			  {
				  c = s.y;
				  m = 0;
			  }
			  else
			  {
				  m = (double)(e.y-s.y)/(e.x-s.x);
				  c= (double)(e.y - (m*e.x));
			  }
			  
			  int i = 1;
			  
			while(cur!=e && i<points.length-1)
			{
				cur = points[i];
				//System.out.println(cur.x + " " + cur.y  + " " + m + " " + c + " " + ((double)(m*cur.x + c)));
				if(cur.x == a.x)
				{
					if(!sol.contains(cur))
					sol.add(cur);
					s = cur;
					  if(s.x == e.x)
					  {
						  c = s.y;
						  m = 0;
					  }
					  else
					  {
						  m = (double)(e.y-s.y)/(e.x-s.x);
						  c= (double)(e.y - (m*e.x));
					  }
				}
				
				else if(cur.y>=(double)(m*cur.x + c))
				{
					  if(!(btwmax(s,e,cur,i,points)))
					  {
					  if(!sol.contains(cur))
							sol.add(cur);
						s = cur;
						  if(s.x == e.x)
						  {
							  c = s.y;
							  m = 0;
						  }
						  else
						  {
							  m = (double)(e.y-s.y)/(e.x-s.x);
							  c= (double)(e.y - (m*e.x));
						  }
					  }
				}
			
					i++;
			 }
			
			   s = e;
			   e = b;
			   
			  if(s.x == e.x)
			  {
				  c = s.y;
				  m = 0;
			  }
			  else
			  {
				  m = (double)(e.y-s.y)/(e.x-s.x);
				  c= (double)(e.y - (m*e.x));
			  }
			  
			  
			  while(i<points.length-1)
			  {
				 
				  cur = points[i];
				  
				  if(cur.y>=(double)(m*cur.x + c))
					{
					  
					  if(!(btwmax(s,e,cur,i,points)))
					  {
					  if(!sol.contains(cur))
							sol.add(cur);
						s = cur;
						  if(s.x == e.x)
						  {
							  c = s.y;
							  m = 0;
						  }
						  else
						  {
							  m = (double)(e.y-s.y)/(e.x-s.x);
							  c= (double)(e.y - (m*e.x));
						  }
					  }
						
					}
				  
				  
				  i++;
				  
			  }
		 }
		 
		 void helper_down(Point a , Point b , Point[] points)
		 {
			 Point cur = b;
			  Point s = cur;
			  Point e = nextm(points.length-1,points);
			  double m , c;
			  if(s.x == e.x)
			  {
				  c = s.y;
				  m = 0;
			  }
			  else
			  {
				  m = (double)(e.y-s.y)/(e.x-s.x);
				  c= (double)(e.y - (m*e.x));
			  }
			  
			  //System.out.println(e.x + " " + e.y + " " + m + " " + c);
			  int i = points.length-2;
			  
			while(cur!=e && i>=1)
			{
				cur = points[i];
				
				//System.out.println(cur.x + " " + cur.y  + " " + m + " " + c + " " + ((double)(m*cur.x + c)) + " " + (cur.y<=(double)(m*cur.x + c)));
				if(cur.x == b.x)
				{
					if(!sol.contains(cur))
					sol.add(cur);
					s = cur;
					  if(s.x == e.x)
					  {
						  c = s.y;
						  m = 0;
					  }
					  else
					  {
						  m = (double)(e.y-s.y)/(e.x-s.x);
						  c= (double)(e.y - (m*e.x));
					  }
				}
				
				
				else if(cur.y<=(double)(m*cur.x + c))
				{
					//System.out.println( cur.x + " " + cur.y + " " + btwmin(s,e,cur,i,points));
					if(!(btwmin(s,e,cur,i,points)))
					{
					if(!sol.contains(cur))
						sol.add(cur);
					
					s = cur;
					  if(s.x == e.x)
					  {
						  c = s.y;
						  m = 0;
					  }
					  else
					  {
						  m = (double)(e.y-s.y)/(e.x-s.x);
						  c= (double)(e.y - (m*e.x));
					  }
					}
				}
			
					i--;
			
			}
			
			
			s = e;
			e = a;
			  if(s.x == e.x)
			  {
				  c = s.y;
				  m = 0;
			  }
			  else
			  {
				  m = (double)(e.y-s.y)/(e.x-s.x);
				  c= (double)(e.y - (m*e.x));
			  }
			  
			  while(i>=1)
			  {
				  cur = points[i];
				  
				  if(cur.y<=(double)(m*cur.x + c))
					{
					  //System.out.println(btwmin(s,e,cur,i,points));
					  if(!(btwmin(s,e,cur,i,points)))
					  {
					  if(!sol.contains(cur))
							sol.add(cur);
						s = cur;
						  if(s.x == e.x)
						  {
							  c = s.y;
							  m = 0;
						  }
						  else
						  {
							  m = (double)(e.y-s.y)/(e.x-s.x);
							  c= (double)(e.y - (m*e.x));
						  }
					  }
					}
				  
				  
				  i--;
				  
			  }
			  
			 
		 }
		 
		 Point next(int i,Point[] points)
		 {
			 Point cur = points[i+1];
			 
			 for(int j=i+1;j<points.length;j++)
			 {
				 if(points[j].y>=cur.y)
				 {
					 cur = points[j];
				 }
			 }
			 
			 return cur;
		 }
		 
		 Point nextm(int i,Point[] points)
		 {
			 Point cur = points[i-1];
			 
			 for(int j=i-1;j>=0;j--)
			 {
				 if(points[j].y<=cur.y)
				 {
					 cur = points[j];
				 }
			 }
			 
			 return cur;
		 }
		 
		 boolean btwmin(Point s , Point e , Point cur , int i, Point[] points)
		 {
			
			  double m , c;
			  if(s.x == e.x)
			  {
				  c = s.y;
				  m = 0;
			  }
			  else
			  {
				  m = (double)(e.y-s.y)/(e.x-s.x);
				  c= (double)(e.y - (m*e.x));
			  }
			  
			  Point cu;
			  
			  for(int j=i-1;j>=0;j--)
			  {
				  cu = points[j];
				  
				  if(cu==e)
					  break;
				  if(cu.y<=(double)(m*cu.x + c))
				  {
					  Point te = cu;
					  
					  double tm , tc;
					  
					  if(s.x == te.x)
					  {
						  tc = s.y;
						  tm = 0;
					  }
					  else
					  {
						  tm = (double)(te.y-s.y)/(te.x-s.x);
						  tc= (double)(te.y - (tm*te.x));
					  }
					  
					 
					  if(cur.y>(double)(tm*cur.x + tc))
					  {
						  
						  return true;
					  }
					  
				  }
			  }
			 
			 return false;
		 }
	     
	
		 boolean btwmax(Point s , Point e , Point cur , int i, Point[] points)
		 {
			
			  double m , c;
			  if(s.x == e.x)
			  {
				  c = s.y;
				  m = 0;
			  }
			  else
			  {
				  m = (double)(e.y-s.y)/(e.x-s.x);
				  c= (double)(e.y - (m*e.x));
			  }
			  
			  Point cu;
			  
			  for(int j=i+1;j<points.length;j++)
			  {
				  cu = points[j];
				  
				  if(cu==e)
					  break;
				  if(cu.y>=(double)(m*cu.x + c))
				  {
					 // System.out.println("here in btwmin inside");
					  Point te = cu;
					  
					  double tm , tc;
					  
					  if(s.x == te.x)
					  {
						  tc = s.y;
						  tm = 0;
					  }
					  else
					  {
						  tm = (double)(te.y-s.y)/(te.x-s.x);
						  tc= (double)(te.y - (tm*te.x));
					  }
					  
					//  System.out.println(cur.y + " " + (double)(tm*cur.x + tc) );
					  if(cur.y<(double)(tm*cur.x + tc))
						  return true;
					  
				  }
			  }
			 
			 return false;
		 }
	 
}
