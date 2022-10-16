
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
    
    
    private static ArrayList<Assignment> track = new ArrayList<Assignment>();
    private static String fileName = "save_data.tmp";
    private static GUI x;

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        File f = new File(fileName);
        if (f.exists() && !f.isDirectory()) {
            openAndRun();
        }
        x = new GUI();
    }

    public static void refresh(){
        x.setVisible(false);
        x.dispose();
        x = new GUI();
    }

    public static void saveAndQuit() throws IOException {
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

    public static void addAssignment(Assignment what){
        track.add(what);
        sort(track);
    }

    public static String[][] toStringArray(){
        String[][] r = new String[track.size()][7];
        for(int i =0;i<track.size();i++){
            System.out.println(track.get(i).toString());
            r[i][0] = i+"";
            r[i][1]= track.get(i).getName();
            r[i][2]= track.get(i).getCourse();
            r[i][3]= track.get(i).getTypeString();
            r[i][4]= track.get(i).getDate().toString();
            r[i][5]= track.get(i).CompletedToString();
            r[i][6]= track.get(i).getDifficultlyString();
        }
        return r;
    }
}