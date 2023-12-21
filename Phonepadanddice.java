import java.util.*;
public class Phonepadanddice {
    public static void main(String[] args){
        System.out.println(customdiceret("",5,7));
    }
    public static void phone(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        //  this will convert the character into an integer
        for(int i= (digit-1) * 3 ; i < digit * 3; i++){
            char ch = (char) ('a' + i);
            phone(p +ch, up.substring(1));
        }

    }
    //  returning the answers in an arraylist
    public static ArrayList<String> phonearraylist (String p, String up){
        if(up.isEmpty()){
            ArrayList <String> list = new ArrayList <>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0';
        ArrayList <String> ans = new ArrayList <>();
        for(int i=(digit-1) * 3; i < digit * 3 ;i++){
            char ch = (char) ('a' + i);
            ans.addAll(phonearraylist(p + ch,up.substring(1)));
        }
        return ans;
    }
    //  returning the count of the number of elements 
    public static int countele(String p,String up){
        if(up.isEmpty()){
            return 1;
        }
        int digit = up.charAt(0) - '0';
        int count = 0;
        for(int i=(digit-1)*3;i<digit * 3;i++){
            char ch = (char) ('a' + i);
            count += countele(p + ch,up.substring(1));

        }
        return count;
    }
    // how many ways it is possible in a dice to have  a traget sum
    public static void dicesum(String p, int target){
        if(target == 0){
            System.out.println(p);
            return;
        }
        //  abhi yaha loop jo hoga woh 1 to 6 main run hoga
        for(int i=1;i<=6 && i <= target;i++){
            dicesum(p + i, target - i);
        }
    }
    //  returning all these anwers as an arraylist
    public static ArrayList <String> dicearraylist(String p, int target){
        if(target == 0){
            ArrayList<String> list = new ArrayList <>();
            list.add(p);
            return list;
        }
        ArrayList <String> ans = new ArrayList <>();
        for(int i=1;i<=6 && i<=target;i++){
            ans.addAll(dicearraylist(p + i,target - i));
        }
        return ans;
    }
    //  if there is a die with custom faces
    public static void customdice(String p, int target,int faces){
        if(target == 0){
            System.out.println(p);
            return;
        }
        for(int i=1;i<=faces && i<=target;i++){
            //  dekho phir agar target se bada hoga i like if target is 4 and i is 5 so sont take it
            customdice(p + i,target - i,faces);
        }
    }
    //  returning the answer in an arraylist
    public static ArrayList<String> customdiceret(String p,int target,int faces){
        if(target == 0){
            ArrayList <String> list = new ArrayList <>();
            list.add(p);
            return list;
        }
        ArrayList <String> ans = new ArrayList <>();
        for(int i=1;i<=faces && i<=target;i++){
            ans.addAll(customdiceret(p + i,target-i,faces));
        }
        return ans;
    }
}
