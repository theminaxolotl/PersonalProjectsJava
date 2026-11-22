// small tick tack toe project try by me :3

package PersonalProjects;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TickTackToe {

    // globale variablen
    public static String p = "X";

    public static void ausgabe(String[] f) {
        System.out.println();
        System.out.println("=====");
        System.out.println(f[0]+"|"+f[1]+"|"+f[2]);
        System.out.println("-----");
        System.out.println(f[3]+"|"+f[4]+"|"+f[5]);
        System.out.println("-----");
        System.out.println(f[6]+"|"+f[7]+"|"+f[8]);
        System.out.println("=====");
    }
    public static String[] felderzuweisen(String a,String[] f) {
        for (int i = 0;i<9;i++) {
            if (f[i].equals(a)) {
                f[i] = p;
                return f;
            }
        }
        return f;
    }
    public static boolean  win(String[] f) {
        return (f[0].equals(f[1]) && f[1].equals(f[2]) || f[3].equals(f[4]) && f[4].equals(f[5]) || f[6].equals(f[7]) && f[7].equals(f[8]) || f[0].equals(f[3]) && f[3].equals(f[6]) || f[1].equals(f[4]) && f[4].equals(f[7]) || f[2].equals(f[5]) && f[5].equals(f[8]) || f[0].equals(f[4]) && f[4].equals(f[8]) || f[2].equals(f[4]) && f[4].equals(f[6]));
    }
    public static void changePlayer() {
            if (p.equals("X")) {
                p = "O";
            }
            else if (p.equals("O")) {
                p = "X";
            }
    }
    public static boolean checkvalidinput(String[] f, String a) {
        try {
            int test = Integer.parseInt(a);
        }
        catch (NumberFormatException _) {
            System.out.println("Bitte eine zahl eingeben");
            return true;
        }
        if (Integer.parseInt(a)>9 || Integer.parseInt(a)<1 || f[Integer.parseInt(a)-1].equals("X") || f[Integer.parseInt(a)-1].equals("O")) {
            System.out.println("out of range bitte zahl von 1-9 und man darf keine zeichen replacen");
            return true;
        }
        return false;
    }
    public static int checkDraw(int turn, String[] f) {
        turn++;
        if (turn == 9) {
            ausgabe(f);
            System.out.println("Draw >:(");
            System.exit(0);
        }
        return turn;
    }
    public static void main() {
        Scanner scan = new Scanner(System.in);
        String[] f = {"1","2","3","4","5","6","7","8","9"};
        int turn = 0;

        while (true) { 
            ausgabe(f);
            System.out.print("Turn: "+p+": ");
            String a = scan.nextLine();
            if (checkvalidinput(f, a)) {
                continue;
            }
            f = felderzuweisen(a,f);
            boolean w = win(f);
            if (w) { 
                ausgabe(f);
                System.out.println("Player: "+p+" Won!!!");
                scan.close();
                System.exit(0);
            }
            turn = checkDraw(turn,f);
            changePlayer();
        }
    }
}