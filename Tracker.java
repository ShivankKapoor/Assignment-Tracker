
// Writen by Shivank Kapoor
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Tracker {
    private static ArrayList<Assignment> track = new ArrayList<Assignment>();
    private static String fileName = "save_data.tmp";

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        boolean run = true;

        File f = new File(fileName);
        if (f.exists() && !f.isDirectory()) {
            openAndRun();
        }
        while (run) {
            System.out.println("Menu Choices: ");
            System.out.println("0.  Quit");
            System.out.println("1.  Print Table");
            System.out.println("2.  Add Assignment");
            System.out.println("3.  Remove Assignment");
            System.out.println("4.  Toggle Status");
            System.out.println("5.  Clear Screen");
            int menuChoice = scan.nextInt();
            switch (menuChoice) {
                case 0:
                    run = false;
                    saveAndQuit();
                    break;
                case 1:
                    printHeader();
                    printTable(track);
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
                case 5:
                    clearScreen();
                    break;
                default:
                    continue;
            }
        }
    }

    private static void printTable(ArrayList<Assignment> x) {
        sort(x);
        int size = x.size();
        for (int i = 0; i < size; i++) {
            Assignment Current = x.get(i);
            String name = Current.getName();
            String course = Current.getCourse();
            String type = Current.getTypeString();
            String date = Current.getDate().dateToString();
            String status = Current.CompletedToString();
            System.out.printf("| %-5s | %-20s | %-12s | %-8s | %-9s | %-12s |%n", i, name, course, type, date, status);
        }
        System.out.println();
    }

    private static void printHeader() {
        System.out.printf("| %-5s | %-20s | %-12s | %-8s | %-9s | %-12s |%n", "INDEX", "NAME", "COURSE", "TYPE",
                "DUE DATE", "STATUS");
        System.out.println("-------------------------------------------------------------------------------------");
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

        Date dueDate = new Date(month, day, year);
        track.add(new Assignment(name, courseID, dueDate, intType, dif));
    }

    private static void removeAssignment() {
        System.out.println("Enter Assignment Number to remove (-1 to Cancle): ");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice <= -1) {
        } else if (choice > track.size()) {
            System.out.println("Choice Invalid");
        } else {
            track.remove(choice);
        }
    }

    private static void changeStatus() {
        System.out.println("Enter Assignment Number (-1 to Cancle): ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();
        if (id > track.size()) {
            System.out.println("ID not valid");
        } else if (id == -1) {
        } else {
            track.get(id).toggleCompleted();
        }
    }

    private static void saveAndQuit() throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(track);
        oos.close();
    }

    private static void openAndRun() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        track = (ArrayList<Assignment>) ois.readObject();
        ois.close();
    }

    private static void sort(ArrayList<Assignment> x) {
        int n = x.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (x.get(j).getDate().getDateValueNum() > x.get(j + 1).getDate().getDateValueNum()) {
                    Assignment temp = x.get(j);
                    x.set(j, (x.get(j + 1)));
                    x.set(j + 1, temp);
                }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}