package TaskThree;

import java.util.ArrayList;

public class Box <T extends Fruit>{
    ArrayList<T> ArrList = new ArrayList<T>();


    public  void addFruit(T fruit){
        this.ArrList.add(fruit);
    }


    public float getWeight(){
       int num = this.ArrList.size();

       if (num != 0){
           float weight = this.ArrList.get(0).getWeight();
           float result =num*weight;
           return result;
       }
       return 0;
    }


    public void compare(Box box){
       if (this.getWeight() == box.getWeight()){
           System.out.println("true");
       }else{System.out.println("false");}
    }


    public void moveTo(Box box){
        for (int i = 0; i < this.ArrList.size() ; i++) {
         box.addFruit(this.ArrList.get(i));
        }
        this.ArrList.clear();
    }
}
