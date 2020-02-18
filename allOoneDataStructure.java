/**
* Implement a data structure supporting the following operations:
* Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. 
* Key is guaranteed to be a non-empty string.
*
* Dec(Key) - If Key's value is 1, remove it from the data structure. 
* Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. 
* Key is guaranteed to be a non-empty string.
*
* GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
*
* GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
*/

class allOoneDataStructure {

    TreeMap<String,Integer> map;
    TreeMap<Integer,ArrayList<String>> map2;
    /** Initialize your data structure here. */
    public AllOne() {
        
        map = new TreeMap<>();
        map2 = new TreeMap<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        
        if(map.containsKey(key))
        {
            map2.get(map.get(key)).remove(key);
                if(map2.get(map.get(key)).isEmpty())
                    map2.remove(map.get(key));
            map.put(key,map.get(key)+1);
            if(map2.containsKey(map.get(key)))
            {
                map2.get(map.get(key)).add(key);
            }
            else
            {
                map2.put(map.get(key),new ArrayList<>());
                map2.get(map.get(key)).add(key);
            }
        }
        else
        {
             map.put(key,1);
            if(map2.containsKey(1))
            {
                map2.get(1).add(key);
            }
            else
            {
                map2.put(1,new ArrayList<>());
                map2.get(1).add(key);
            }
        }
            
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        
        if(map.containsKey(key))
        {
            if(map.get(key)==1)
            {
                map.remove(key);
                map2.get(1).remove(key);
                  if(map2.get(1).isEmpty())
	                    map2.remove(1);
            }
            else
            {
                 map2.get(map.get(key)).remove(key);
                if(map2.get(map.get(key)).isEmpty())
                    map2.remove(map.get(key));
                 map.put(key,map.get(key)-1);
                 if(map2.containsKey(map.get(key)))
                 {
                    map2.get(map.get(key)).add(key);
                 }
                 else
                 {
                    map2.put(map.get(key),new ArrayList<>());
                    map2.get(map.get(key)).add(key);
                }
            }
                
        }
        
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        
        if(map.isEmpty())
            return "";
        else 
            return map2.get(map2.lastKey()).get(0);
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        
         if(map.isEmpty())
            return "";
        else 
            return map2.get(map2.firstKey()).get(0);
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
