public class TaskOne <T extends Object> {
    public static void main(String[] args) {
        String[] arrStr = {"one", "two"};
        Integer[] arrInt = {1,2};
        Boolean[] arrBoo= {true,false};
        rotate(arrInt);
        rotate(arrStr);
        rotate(arrBoo);
    }

    public  static <T> void rotate (T...  o){

        T num = o[1];
        o[1] = o[0];
        o[0] = num;

        for (int i = 0; i < 2; i++) {
            System.out.print(o[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

}