import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ErsteTeilAufgabe {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new FileReader("WQU.txt"));
        int N = 0;
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();

        while (s.hasNext()) {
            l1.add(s.nextInt());
            l2.add(s.nextInt());
        }
        s.close();
        N = l1.size() + 1;
        WeightedQU wqu = new WeightedQU(N);
        StdOut.println("Anzahl der Elelmenten " + N);
        Stopwatch time = new Stopwatch();

        for (int i = 0; i < l1.size(); i++) {
            if (wqu.connected(l1.get(i), l2.get(i))) {
                StdOut.println(l1.get(i) + "," + l2.get(i) + " Verbunden");
            } else {
                wqu.union(l1.get(i), l2.get(i));
                StdOut.println(l1.get(i) + " , " + l2.get(i) + " jetzt verbunden");
            }
        }
        double results = time.elapsedTime();
        StdOut.println(results);
        FileWriter writer = new FileWriter("Results.TXT", true);
        writer.write("\n");
        writer.write(results + " Anzal der Elementen " + N);
        writer.close();
    }
}
