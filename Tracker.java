
// Writen by Shivank Kapoor
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;


public class Tracker extends JFrame {
    
    
    public static ArrayList<Assignment> track = new ArrayList<Assignment>();
    private static String fileName = "save_data.tmp";

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        GUI x = new GUI();
        Scanner scan = new Scanner(System.in);
        boolean run = true;

        File f = new File(fileName);
        if (f.exists() && !f.isDirectory()) {
            openAndRun();
        }
    }

    public static void printTableFormated() {
        clearScreen();
        sort(track);
        ArrayList<Integer> completed = new ArrayList<Integer>();
        ArrayList<Integer> incompleted = new ArrayList<Integer>();
        for (int i = 0; i < track.size(); i++) {
            Assignment Cur = track.get(i);
            if (Cur.getCompleted()) {
                completed.add(i);
            } else {
                incompleted.add(i);
            }
        }
        printHeader();
        printTable(incompleted);
        if (completed.size() > 0) {
            System.out.println("--------------------------------------------------Completed--------------------------------------------------");
            printTable(completed);
        }
    }

    private static void printTable(ArrayList<Integer> x) {
        int size = x.size();
        for (int i = 0; i < size; i++) {
            Assignment Current = track.get(x.get(i));
            String name = Current.getName();
            String course = Current.getCourse();
            String type = Current.getTypeString();
            String date = Current.getDate().toString();
            String status = Current.CompletedToString();
            System.out.printf("| %-5s | %-25s | %-25s | %-8s | %-12s | %-12s |%n", x.get(i), name, course, type, date, status);
        }
        System.out.println();
    }

    private static void printHeader() {
        System.out.printf("| %-5s | %-25s | %-25s | %-8s | %-12s | %-12s |%n", "I.D #", "NAME", "COURSE", "TYPE",
                "DUE DATE", "STATUS");
        System.out.println("------------------------------------------------------------------------------------------------------------");
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
        for (int i = 0; i < 50; ++i) System.out.println();
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}