import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class a {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String g = in.nextLine();
        System.out.println(getPalavraRecursiva(g));
    }

    public static String getPalavraRecursiva(String str) {
        if (str.isEmpty())
            return str;
        return getPalavraRecursiva(str.substring(1)) + str.charAt(0);
    }

 /*   public static void getPalavra(String palavra) {
        LinkedList<Character> list = new LinkedList();
        if (palavra == null) {
            System.out.println("Insira uma Palavra");
        }
        char[] p = palavra.toCharArray();
        for (char c : p) {
            list.add(c);
        }
        Collections.reverse(list);

        for (Character g : list) {
            System.out.print(g);
        }
    }*/


}
