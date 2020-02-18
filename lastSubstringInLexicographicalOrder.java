//Given a string s, return the last substring of s in lexicographical order.

class lastSubstringInLexicographicalOrder {
    
    public String lastSubstring(String s) {
        
       int len = s.length();
        if (len == 1) return s;
        char[] sc = s.toCharArray();
        char max = 'A';
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (sc[i] > max) {
                max = sc[i];
                idx = i;
            }
            else if (sc[i] == max) {
                int pre = idx;
                int cur = i;
                int last = -1;
                while (i < len && sc[i] == sc[pre]) {
                      if(sc[i]==max)
                        last = i;
                    i++; pre++;
                }
                if (i == len || sc[i] < sc[pre]) continue;
                if (sc[i] > sc[pre]) {
                    idx = cur;
                }
                if(last!=-1)
                    i = last;
                else 
                    i = cur;
            }
        }
        return s.substring(idx);
      }
}
