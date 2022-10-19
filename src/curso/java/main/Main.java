package curso.java.main;

import curso.java.menu.Menu;
import curso.java.produceValue.ProduceValue;

public class Main {
    public static void main(String[] args) {
        int close;
        String[][] value = generatedArr();

        do{
            Menu.drawMenu();
            close = Integer.parseInt(ProduceValue.getValue());
            switch (close){
                case 1:
                    addStudent(value);
                    break;
                case 2:
                    searchStudent(value);
                    break;
                case 3:
                    dropStudent(value);
                    break;
                case 4:
                    showStudents(value);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("GOODBYE!");
                    break;
                default:
                    System.out.println("Option not allowed");
            }
        }while(close!=7);
    }

    public static String[][] generatedArr() {
        int numberOfRoom = Integer.parseInt(ProduceValue.getValue("Insert the number of classroom: "));
        String[][] arrRoom = new String[numberOfRoom][0];

        for (int x = 0; x < numberOfRoom; x++) {
            int addNumberStudent = Integer.parseInt(ProduceValue.getValue("Insert the number of students belongs to classroom " + (x + 1) + ": "));
            arrRoom[x] = new String[addNumberStudent];
        }
        return arrRoom;
    }
    public static void addStudent(String[][] value){
        int nClass = Integer.parseInt(ProduceValue.getValue("Choose classroom: "));
        if (nClass<= value.length && nClass>=0){
            String[] chooseRoom = value[nClass];
            boolean fullClassroom = true;

            for(int i = 0; i < chooseRoom.length; i++){
                if (value[nClass][i] == null) {
                    chooseRoom[i] = ProduceValue.getValue("Insert the name of student " +(i+1)+": ");
                    fullClassroom = false;
                    break;
                }
            }
            if (fullClassroom) {
                System.out.println("Full classroom");
            }
        }else {
            System.out.println("This classroom doesn't exist");
        }
    }
    public static void searchStudent(String[][] value){

        String name = ProduceValue.getValue("Insert the name: ");
        int count = 0;
        boolean found = false;
        for (String[] classR : value){
           count++;
            for (String student : classR){
                if (student!=null){
                    if(student.equals(name)){
                        System.out.println("Student found it, belong to classroom nº "+count);
                        found = true;
                        break;
                    }
                }
            }
            if(found){
                break;
            }
        }
        if(!found){
            System.out.println("Student " +name+ " not found");
        }
        //TAMBIEN SE PUEDE CON ESTO, AL SER UNA MATRIZ IRREGULAR EN EL SEGUNDO FOR INDICAMOS LA FILA A RECORRER, SINO NO INDICAMOS EL [i]
        //for (int i = 0; i < value.length; i++){
        //for (int i = 0; i < value.length; i++){{

    }

    public static void dropStudent(String[][] value){
        String name = ProduceValue.getValue("Insert the name to erase: ");
        boolean found = false;
        for (int i = 0; i < value.length; i++){
            for (int j = 0; j < value.length; j++){
                String stud;
                if (value[i][j]!=null){
                    stud = value[i][j];
                    if(stud.equals(name)){
                        value[i][j] = null;
                        found = true;
                        System.out.println("Student have been dropped");
                        break;
                    }
                }
            }
            if(found){
                break;
            }
        }
        if(!found){
            System.out.println("Student " +name+ " not found to erase");
        }
    }


    public static void showStudents(String[][] value){
        int nClass = Integer.parseInt(ProduceValue.getValue("Choose classroom: "));
        if (nClass<= value.length && nClass>=0){
            String[] chooseRoom = value[nClass];
            boolean fullClassroom = true;

            for(int i = 0; i < chooseRoom.length; i++){
                if (value[nClass][i]!=null) {
                    System.out.println(chooseRoom[i]);
                    fullClassroom = false;
                }
            }
            if (fullClassroom) {
                System.out.println("Classroom empty");
            }
        }else {
            System.out.println("This classroom doesn't exist");
        }

    }


}

