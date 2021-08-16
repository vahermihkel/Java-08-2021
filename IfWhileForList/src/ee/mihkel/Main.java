package ee.mihkel;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String s6nalineMuutuja = "dadasdas";
        char ykst2ht = 's';
        boolean trueV6iFalse = true;
        int kaksMiljardit = 123123;
        long miljardmiljardit = 3123122312L;

//        System.out.println("töötab");
//        System.out.println(s6nalineMuutuja);
//        System.out.println(kaksMiljardit + miljardmiljardit);
//        System.out.println(kaksMiljardit + miljardmiljardit + s6nalineMuutuja);
//        System.out.println(s6nalineMuutuja + kaksMiljardit + miljardmiljardit);

//        int i = 1;

        if (trueV6iFalse) {
            System.out.println("läksin if-i sisse");
        } else if (kaksMiljardit < 132132) {
            System.out.println("LÄKSIN KESKMISESSE");
        } else if (kaksMiljardit < 13213) {
            System.out.println("LÄKSIN KESKMISESSE");
        } else {
            System.out.println("läksin else-i");
        }
//        System.out.println(i);

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        int i = 0;
        while (i < 5) {
            System.out.println(i);
            i++;
        }

        List massiiv = new ArrayList();
        massiiv.add("adsa");
        massiiv.add("dasd");
        massiiv.add("gfdd");
        massiiv.add("qwer");
        massiiv.remove("dasd");
        massiiv.remove(2);

        for (int j = 0; j < massiiv.size(); j++) {
            System.out.println(massiiv.get(j));
            System.out.println(massiiv.size());
            System.out.println(massiiv.isEmpty());
            System.out.println(massiiv.remove(1));
            massiiv.clear();
            System.out.println(massiiv);
        }

    }
}
