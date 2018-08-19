import java.util.ArrayList;

public class TaskTwo {
    public static void main(String[] args) {
        Integer[] arrInt = {1,2,3,4,5,6,7,8,9};
        String[] arrStr = {"one ","two ","three ","four ","five ","six ","seven ","eight ","nine "};
        toArrList(arrInt);
        toArrList(arrStr);
    }
    public  static <T> void toArrList (T...  o) {
        ArrayList<T> al = new ArrayList<T>(o.length);
        for (int i = 0; i < o.length ; i++) {
            al.add(o[i]);
        }
        System.out.println(al);
    }
}
