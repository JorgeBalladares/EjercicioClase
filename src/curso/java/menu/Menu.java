package curso.java.menu;

public class Menu {

    public static void drawMenu(String menu) {
        System.out.println(menu);
    }

    public static void drawMenu() {
        drawMenu("""
                \n1. Insert a student in class:\040
                2. Find a student:\040
                3. Drop a student:\040
                4. Show students by classroom:\040
                5. Show all students:\040
                6. Show free places of classroom:\040
                7. Goodbye!
                """);
    }





}
