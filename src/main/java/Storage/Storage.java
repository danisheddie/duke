package Storage;

import model.Deadline;
import model.Events;
import model.Task;
import model.ToDos;

import java.io.*;
import java.util.ArrayList;


public class Storage {
    private ArrayList<Task> saveText;

    public Storage(ArrayList<Task> txt) {
        this.saveText = txt;
    }

    public void saveToFile(ArrayList<Task> saveText) {
        File file = new File("C:\\Users\\Dell\\Desktop\\duke\\dataTask.txt"); // Creating the textfile
        try {
            PrintWriter output = new PrintWriter(file);
            for (Task x : saveText) {
                output.println(x.getFormat());
            }
            output.close();
        } catch (IOException ex) {
            System.out.print("ERROR: Not Available");
        }
    }

    public void ReadFile(ArrayList<Task> arr) {
        BufferedReader br = null;
        String line;
        try {
            FileReader fr = new FileReader("C:\\Users\\Dell\\Desktop\\duke\\dataTask.txt");
            br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {

                String[] splitter = line.split("\\|");
                for (int i = 0; i < splitter.length; i++) {
                    splitter[i] = splitter[i].trim();
                }
                if (splitter[0].equals("D")) {
                    Deadline newD = new Deadline(splitter[2], splitter[3]);
                    if (splitter[1].equals("false")) {
                        newD.isDone = false;
                    } else if (splitter[1].equals("true")) {
                        newD.isDone = true;
                    }
                    arr.add(newD);
                } else if (splitter[0].equals("E")) {
                    Events newE = new Events(splitter[2], splitter[3]);
                    if (splitter[1].equals("false")) {
                        newE.isDone = false;
                    } else if (splitter[1].equals("true")) {
                        newE.isDone = true;
                    }
                    arr.add(newE);
                } else {
                    ToDos newT = new ToDos(splitter[2]);
                    if (splitter[1].equals("false")) {
                        newT.isDone = false;
                    } else if (splitter[1].equals("true")) {
                        newT.isDone = true;
                    }
                    arr.add(newT);
                }
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
