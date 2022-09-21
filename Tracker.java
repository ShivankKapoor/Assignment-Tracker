import java.util.ArrayList;
import java.util.Scanner;

public class Tracker {
   private static ArrayList<Assignment> track = new ArrayList<Assignment>();

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Menu Choices: ");
            System.out.println("0. Quit");
            System.out.println("1.Print Table");
            System.out.println("2.Add Assignment");
            System.out.println("3.Remove Assignment");
            System.out.println("4. Toggle Status");
            int menuChoice = scan.nextInt();
            switch (menuChoice) {
                case 0:
                    run=false;
                    break;
                case 1:
                    printTable();
                    break;
                case 2:
                    addAssignment();
                    break;
                case 3:
                    removeAssignment();
                    break;
                case 4:
                    changeStatus();
                    break;
                default:
                    continue;
            }
        }
    }

    private static void printTable() {
        System.out.println();
        int size = track.size();
        for(int i=0;i<size;i++){
            Assignment Current = track.get(i);
            System.out.println(i+".     "+Current.getName()+"       "+Current.getCourse()+"     "+Current.getDate().dateToString()+"        "+Current.CompletedToString());
        }
        System.out.println();
    }

    private static void addAssignment() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Assignment Name: ");
        String name = scan.nextLine();

        System.out.print("Is it 1.A Test 2.Homework 3.A Quiz: ");
        int intType = scan.nextInt();
        scan.nextLine();

        System.out.print("\nCourse ID: ");
        String courseID = scan.nextLine();

        System.out.println("\nEnter Month: ");
        int month = scan.nextInt();
        System.out.println("\nEnter Day: ");
        int day = scan.nextInt();
        System.out.println("\nEnter Year: ");
        int year = scan.nextInt();

        System.out.println("\nOn a scale from 1-5 how hard is this going to be: ");
        int dif = scan.nextInt();

        Date dueDate = new Date(month,day,year);
        track.add(new Assignment(name,courseID,dueDate,intType,dif));
    }

    private static void removeAssignment() {

    }

    private static void changeStatus(){
        System.out.println("Enter Assignment Number: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();
        if(id>track.size()){
            System.out.println("ID not valid");
        }else{
            track.get(id).toggleCompleted();
        }
    }
}