import java.util.Scanner;

public class leepYear {
    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        int year = ss.nextInt();
        ss.close();
        System.out.println((year % 400 == 0) ? "leep year ": (year % 100== 0 )? " not a leep year": (year % 4== 0 )? " leep year": " not a leep year" );        
    }
}
