package TaskThree;

public class TaskThree {
    public static void main(String[] args) {
        System.out.println("\n \n Apple Test");
        AppleTest();

        System.out.println("\n \n Orange Test");
        OrangeTest();

        Box box1 = new Box();
        Apple apple = new Apple();
        Orange orange = new Orange();

        box1.addFruit(apple);
        box1.addFruit(orange); //не удалось сделать фильтрацию



    }
    public static void AppleTest(){
        Box box1 = new Box();
        Box box2 = new Box(); //создаём две коробки

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();   //создаём яблоки


        box1.addFruit(apple1);
        box1.addFruit(apple2);
        box2.addFruit(apple4);
        box2.addFruit(apple5); //кладём равное кол-во яблок

        System.out.println("weight comparing...");
        box1.compare(box2);

        System.out.println("Added Fruit to Box 2");


        box2.addFruit(apple3);
        System.out.println("weight comparing...");
        box1.compare(box2);   //делаем кол-во яблок неравным

        System.out.println("Box 1 weight");
        System.out.println(box1.getWeight());
        System.out.println("Box 2 weight");
        System.out.println(box2.getWeight());        //взвешиваем коробки





        box1.moveTo(box2);  //пересыпаем яблоки
        System.out.println("Moved Box 1 to Box 2");
        System.out.println("Box 1 weight");
        System.out.println(box1.getWeight());
        System.out.println("Box 2 weight");
        System.out.println(box2.getWeight());     //снова взвешиваем коробки
    }
    public static void OrangeTest(){
        Box box1 = new Box();
        Box box2 = new Box(); //создаём две коробки

        Orange orange1 = new Orange();//создаём апельсины
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();
        Orange orange5 = new Orange();



        box1.addFruit(orange1);
        box1.addFruit(orange2);
        box2.addFruit(orange4);
        box2.addFruit(orange5); //кладём равное кол-во апельсинов

        System.out.println("weight comparing...");
        box1.compare(box2);

        System.out.println("Added Fruit to Box 2");


        box2.addFruit(orange3);
        System.out.println("weight comparing...");
        box1.compare(box2);   //делаем кол-во апельсинов неравным

        System.out.println("Box 1 weight");
        System.out.println(box1.getWeight());
        System.out.println("Box 2 weight");
        System.out.println(box2.getWeight());        //взвешиваем коробки





        box1.moveTo(box2);  //пересыпаем яблоки
        System.out.println("Moved Box 1 to Box 2");
        System.out.println("Box 1 weight");
        System.out.println(box1.getWeight());
        System.out.println("Box 2 weight");
        System.out.println(box2.getWeight());     //снова взвешиваем коробки
    }
}
