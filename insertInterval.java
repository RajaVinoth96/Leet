/**
* Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
* 
* You may assume that the intervals were initially sorted according to their start times.
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
class insertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    
        if(intervals.size() == 0)
        {
            List<Interval> sol = new ArrayList<>();
            sol.add(newInterval);
            return sol;
        }
        
        boolean flag = false;
        
        int a = newInterval.start;
        int b = newInterval.end;
        
        for(int i=0;i<intervals.size();i++)
        {
            int s = intervals.get(i).start;
            int e = intervals.get(i).end;
            
            if(!flag)
            {
                if((s>=a && s<=b) || (a>=s && a<=e))
                   {
                       Interval t= new Interval(Math.min(s,a),Math.max(b,e));
                       intervals.remove(intervals.get(i));
                       intervals.add(i,t);
                       flag = true;
                   }
                else if(b<s)
                {
                    intervals.add(i,newInterval);
                    flag = true;
                }
            }
            else
            {
                int s2 = intervals.get(i-1).start;
                int e2 = intervals.get(i-1).end;
                
                if((s>=s2 && s<=e2) || (s2>=s && s2<=e))
                   {
                       Interval t= new Interval(Math.min(s,s2),Math.max(e2,e));
                       intervals.remove(intervals.get(i));
                       intervals.remove(intervals.get(i-1));
                       intervals.add(i-1,t);
                       i--;
                   }
            }
        }
        
        if(!flag)
            intervals.add(newInterval);
        
        return intervals;
    }
}
