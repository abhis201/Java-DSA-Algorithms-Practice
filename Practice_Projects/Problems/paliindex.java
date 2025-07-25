package Problems;
import java.util.ArrayList;

public class paliindex {
    public static int palindromeIndex(String s) {
        // Write your code here
            int n = s.length();
            String test = s;
            StringBuffer sbr = new StringBuffer(test);
            sbr.reverse();
            String store = "";
            ArrayList<Integer> storeindex = new ArrayList<>(2);
        
            if(test.equals(sbr.toString())){
                return -1;
            }
        
            for(int i=0;i<n;i++){
                char a = test.charAt(i);
                char b = sbr.charAt(i);
                if(a!=b){
                    store +=a;
                    storeindex.add(i);
                }
            }

            if(store.length()>2){
                return -1;
            }
            int res = 0;

            char a = sbr.charAt(storeindex.get(0));
            sbr.deleteCharAt(storeindex.get(0));
            System.out.println(sbr);
            StringBuffer palicheck1 = new StringBuffer(sbr);
            palicheck1.reverse();
            System.out.println(palicheck1);
            //System.out.println(palicheck1.toString().equals(sbr.toString()));
            if(palicheck1.toString().equals(sbr.toString())){
                res = n-1-storeindex.get(0);
                return res;
            }
            int index = storeindex.get(0);
            sbr.insert(index,a);
            sbr.deleteCharAt(storeindex.get(1));
            System.out.println(sbr);
            StringBuffer palicheck2 = new StringBuffer(sbr);
            palicheck2.reverse();
            System.out.println(palicheck2);

            if(palicheck2.toString().equals(sbr.toString())){
                res = n-1-storeindex.get(1);
                return res;
            }
            else{
                return -1;
            }
        }

        public static void main(String[] args){
            int a = palindromeIndex("aaab");
            System.out.println(a);
            //wykkttfghdvbyxbxefnltpnbdkkdbnptlnfexbxybvdhgfttkkyw
            //oladkyolbdmqwlkejjeklwmdbloykdalo
            //kbkseyyvccgpqtqterkrrkretqtqpgccvyyskbk
        }
}
