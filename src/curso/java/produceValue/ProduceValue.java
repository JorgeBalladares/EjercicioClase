package curso.java.produceValue;

import java.util.Scanner;

public class ProduceValue {

    public static String getValue(String text) {
        System.out.print(text);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static String getValue() {
        return getValue("Insert a option: ");
    }

}
