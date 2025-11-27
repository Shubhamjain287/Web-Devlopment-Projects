import java.util.*;
public class arraylist1 {
    public static void main(String[] args) {
        LinkedList<Integer> al1 = new LinkedList<Integer>();
        al1.add(34);
        al1.add( 123);
        al1.add( 42);
        al1.add( 135);
        al1.add( 133);
        al1.add( 1287);
        al1.add( 1098);
        al1.remove(3);
        System.out.println( al1.contains(122));
        System.out.println(al1.indexOf(1287));
        System.out.println(al1.get(5));
        al1.add(3, 56);
        System.out.println(al1);
        System.out.println("raja ");
            }
    
}
