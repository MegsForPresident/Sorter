import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

public class Sort {
    private static String path;
    private static LinkedList<String> filePaths = new LinkedList<String>();
    private static LinkedList<String> exe = new LinkedList<String>();
    private static LinkedList<String> files = new LinkedList<String>();

    public static void main(String[] args) throws IOException {
        ask();
        list();
        createFile();
        move();
        // System.out.println(to);
    }

    static void move() throws IOException {
        for (int c = 0; c < filePaths.size(); c++) {
            for (int v = 0; v < exe.size(); v++) {
                if (filePaths.get(c).endsWith(exe.get(v))) {
                    File a = new File(filePaths.get(c));
                    a.renameTo(new File(path + "\\" + exe.get(v) + "\\" + files.get(c)));
                }
            }
        }
    }

    static void list() {
        File a = new File(path);
        String[] h = a.list();
        for (String j : h) {
            if (j.contains(".")) {
                files.add(j);
                filePaths.add(path + "\\" + j);
                String g = j.substring(lastIndex(j, '.'));
                if (!exe.contains(g)) {
                    exe.add(g);
                }
            }
        }
    }

    static int lastIndex(String g, char h) {
        return g.length() - reverse(g).indexOf(".");
    }

    static String reverse(String a) {
        String h = "";
        for (int c = a.length() - 1; c > -1; c--) {
            h = h + a.charAt(c);
        }
        return h;
    }

    static void createFile() {
        for (int c = 0; c < exe.size(); c++) {
            File a = new File(path + "\\" + exe.get(c));
            a.mkdir();
        }
    }

    static void ask() {
        System.out.print("Folder Path(from the root): ");
        path = new Scanner(System.in).nextLine();
    }

}