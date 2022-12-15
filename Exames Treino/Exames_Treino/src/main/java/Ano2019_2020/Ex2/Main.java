package Ano2019_2020.Ex2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<String> set=new HashSet<>();
        set.add("oi como estas");
        set.add("AQUI MESMO ");
        System.out.println(misterio(set));
    }
    public static List<Character> misterio(Set<String> set) {
        List<Character> l = new LinkedList<>();
        boolean flag = true;
        int i = 0;
        while (flag) {//enquanto que a flag for true
            flag = false;//coloca a flag a false para se i>=s.length() a função sair do while
            for (String s : set) {
                if (i < s.length()) {//se o i for menor que o tamanho da string
                    l.add(s.charAt(i));//adiciona o caracter com indice i de cada uma das strings que o Set de strings contém, à lista l
                    flag = true;//coloca a flag novamente a true para o ciclo continuar
                }
            }
            i++;//incrementa o i
        }
        return l; }

}
