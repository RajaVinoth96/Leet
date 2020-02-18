/**
* Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 - 1.
*/

class integerToEnglishWords {
    public String numberToWords(int num) {
        
        if(num==0)
            return "Zero";
        
        StringBuilder fin = new StringBuilder();
        
        String t = num+"";
        
        ArrayList<String> list = new ArrayList<>();
        
        list.add(""); 
        list.add("Thousand");
        list.add("Million");
        list.add("Billion"); 
        
        ArrayList<String> list2 = new ArrayList<>();
        
        list2.add("Zero");
        list2.add("One");list2.add("Two");list2.add("Three");
        list2.add("Four");list2.add("Five");list2.add("Six");
        list2.add("Seven");list2.add("Eight");list2.add("Nine");
        
        ArrayList<String> list3 = new ArrayList<>();
        
        list3.add("Ten");
        list3.add("Eleven");list3.add("Twelve");list3.add("Thirteen");
        list3.add("Fourteen");list3.add("Fifteen");list3.add("Sixteen");
        list3.add("Seventeen");list3.add("Eighteen");list3.add("Nineteen");
        
        ArrayList<String> list4 = new ArrayList<>();
        
        list4.add("ten");
        list4.add("ten");list4.add("Twenty");list4.add("Thirty");
        list4.add("Forty");list4.add("Fifty");list4.add("Sixty");
        list4.add("Seventy");list4.add("Eighty");list4.add("Ninety");
        
        int times = t.length()/3 + ((t.length()%3==0)?0:1);
        
        int j = t.length()-1;
        
        int tcount = 0;
        
        for(int i=times-1;i>=0;i--)
        {
            int count = 3;
            StringBuilder s = new StringBuilder();
            for(int k=j-2;k<=j;k++)
            {
                if(k<0)
                {
                    count--;
                    continue;
                }
                
                if(count==3)
                {
                    count--;
                    
                    if(t.charAt(k)=='0')
                        continue;
                    
                    s.append(list2.get(t.charAt(k)-'0'));
                    s.append(" ");
                    s.append("Hundred");
                    s.append(" ");
                }
                
                else if(count==2)
                {
                      count--;
                      if(t.charAt(k)=='0')
                        continue;
                      if(t.charAt(k)=='1')
                      {
                          k++;
                          s.append(list3.get(t.charAt(k)-'0'));
                          s.append(" ");
                      }
                      else
                      {
                          s.append(list4.get(t.charAt(k)-'0'));
                          s.append(" ");
                      }
                }
                
                else
                {
                    if(t.charAt(k)=='0')
                        continue;
                    s.append(list2.get(t.charAt(k)-'0'));
                    s.append(" ");
                }
            }
            
            j = j-3;
            if(s.length()==0)
            {
                tcount++;
                continue;
            }
            
            s.append(list.get(tcount++));
            s.append(" ");
           
            fin.insert(0," ");
            fin.insert(0,s.toString().trim());
        }
        
        String sol = fin.toString();
        
        return sol.trim();
        
    }
}
