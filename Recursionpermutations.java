
import java.util.*;
public class Recursionpermutations {
    public static void main(String[] args){
        
    }
    public static void permutations(String processed, String unprocessed){
        if(unprocessed.length() == 0){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        for(int i=0;i<= processed.length();i++){
            String first = processed.substring(0,i);
            String second = processed.substring(i,processed.length());
            permutations(first+ch+second,unprocessed.substring(1));
            
        }
    }
    public static ArrayList<String> permutationsArrayList(String processed,String unprocessed){
        if(unprocessed.length() == 0){
            ArrayList <String> list = new ArrayList <>();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        ArrayList <String> ans = new ArrayList <>();
        for(int i=0;i<= processed.length();i++){
            String first = processed.substring(0,i);
            String second = processed.substring(i,processed.length());
            ans.addAll(permutationsArrayList(first+ch+second,unprocessed.substring(1)));
           
        }
        return ans;
    }
    public static ArrayList<String> permutationsArrayList2(String processed,String unprocessed){
        if(unprocessed.length() == 0){
            ArrayList <String> list = new ArrayList <>();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        ArrayList <String> ans = new ArrayList <>();
        for(int i=0;i<= processed.length();i++){
            String first = processed.substring(0,i);
            String second = processed.substring(i,processed.length());
            ArrayList<String> list = (permutationsArrayList(first+ch+second,unprocessed.substring(1)));
            ans.addAll(list);
        }
        return ans;
    }
    //  returning the number of permutations possible 
    public static int permutationscount(String processed, String unprocessed){
        if(unprocessed.length() == 0){
           return 1;
        }
        int count = 0;
        char ch = unprocessed.charAt(0);
        for(int i=0;i<= processed.length();i++){
            String first = processed.substring(0,i);
            String second = processed.substring(i,processed.length());
            count = count + permutationscount(first+ch+second,unprocessed.substring(1));
            
        }
        return count;
    }
    
    
}
