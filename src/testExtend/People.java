package testExtend;

/**
 * Created by Andrew on 2016/7/3.
 */
public class People {
    String name;
    public People() {  System.out.print(1); }
    public People(String name) {
        System.out.print(2);
        this.name = name;
    }
}
class Child extends People {
    People father;
    public Child(String name) {
        super(name);
        System.out.print(3);
        this.name = name;
        father = new People(name + ":F");
    }
    public Child(){ System.out.print(4); }
    public static void main (String args [ ]) {
        new Child("mike");
    }
}