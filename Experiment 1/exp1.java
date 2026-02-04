import java.util.Scanner;

abstract class Evaluation {
    boolean att;
    int[] a = new int[10];
    int t = 0;
    int l = 0;
    int fm = 0;
    Evaluation(boolean att) {
        this.att = att;
    }
    final void collect() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter theory marks:");
        for (int i = 0; i < 5; i++) {
            a[i] = sc.nextInt();
            t = t + a[i];
        }
        System.out.println("Enter lab marks:");
        for (int i = 5; i < 10; i++) {
            a[i] = sc.nextInt();
            l = l + a[i];
        }
    }
    final void eval() {
        collect();
        rule();
        show();
    }
    abstract void rule();
    final void show() {
        System.out.println("Theory total = " + t);
        System.out.println("Lab total = " + l);
        System.out.println("Final = " + fm);
        if (fm >= 75)
            System.out.println("Grade A");
        else if (fm >= 60)
            System.out.println("Grade B");
        else if (fm >= 50)
            System.out.println("Grade C");
        else
            System.out.println("Grade F");
    }
}

class BTech extends Evaluation {
    BTech(boolean att) {
        super(att);
    }
    void rule() {
        int ta = t / 5;
        int la = l / 5;
        fm = (ta * 60 / 100) + (la * 35 / 100);
        if (att)
            fm = fm + 5;
    }
}
class MCA extends Evaluation {
    MCA(boolean att) {
        super(att);
    }
    void rule() {
        int ta = t / 5;
        int la = l / 5;
        fm = (ta * 70 / 100) + (la * 20 / 100);
        if (att)
            fm = fm + 10;
    }
}

class PhD extends Evaluation {
    PhD(boolean att) {
        super(att);
    }
    void rule() {
        int ta = t / 5;
        int la = l / 5;
        fm = (ta * 50 / 100) + (la * 40 / 100);
        if (att)
            fm = fm + 10;
    }
}
public class exp1 {
    public static void main(String[] args) {
        System.out.println("BTech");
        Evaluation x = new BTech(true);
        x.eval();
        System.out.println("\nMCA");
        Evaluation y = new MCA(true);
        y.eval();
        System.out.println("\nPhD");
        Evaluation z = new PhD(false);
        z.eval();
    }
}
