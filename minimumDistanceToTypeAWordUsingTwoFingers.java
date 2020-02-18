/**
* You have a keyboard layout in the XY plane, where each English uppercase letter is located at some coordinate,
* for example, the letter A is located at coordinate (0,0), the letter B is located at coordinate (0,1),
* the letter P is located at coordinate (2,3) and the letter Z is located at coordinate (4,1).
* Given the string word, return the minimum total distance to type such string using only two fingers.
* The distance between coordinates (x1,y1) and (x2,y2) is |x1 - x2| + |y1 - y2|. 
* Note that the initial positions of your two fingers are considered free so don't count towards your total distance,
* also your two fingers do not have to start at the first letter or the first two letters.
*/

class minimumDistanceToTypeAWordUsingTwoFingers {
    
    int[][] oord;
    
    char[] arr;
    
    HashMap<String,Integer> map;
    
    public int minimumDistance(String word) {
        
        oord = new int[26][2];
        arr = word.toCharArray();
        map = new HashMap<>();
        
        for(char c ='A';c<='Z';c++)
        {
            int num = c-'A';
            
            oord[num][0] = num/6;
            oord[num][1] = num%6;
        }
        
        return helper(arr[0],'#',1);
    }
    
    public int helper(char a , char b , int l)
    {
        if(l>=arr.length)
            return 0;
        
        String key = ""+a+b+l;
        
        if(map.containsKey(key))
            return map.get(key);
        
        if(b=='#')
        {
            map.put(key,Math.min(helper(a,arr[l],l+1),dist(arr[l],a) + helper(arr[l],b,l+1)));
            
            return map.get(key);
        }
        
        map.put(key,Math.min(dist(arr[l],a) + helper(arr[l],b,l+1) , dist(arr[l],b) + helper(a,arr[l],l+1)));
        
        return map.get(key);
    }
    
    public int dist(char to , char from)
    {
        return Math.abs(oord[to-'A'][0]-oord[from-'A'][0]) + Math.abs(oord[to-'A'][1]-oord[from-'A'][1]);
    }
}
 
