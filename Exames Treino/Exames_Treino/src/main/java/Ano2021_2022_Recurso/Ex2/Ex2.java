package Ano2021_2022_Recurso.Ex2;

public class Ex2 {
    public static void main(String[] args) {

    }



    public static void complexity(int n) {
        long count = 0;
        for (int i = 1; i < n; i = i * 2) {
            for (int j = n; j > 0; j = j / 2) {
                count++;
            }
        }
    }
}
