package Ano2018_2019.Ex2;

public class Ex2 {
    public static void main(String[] args) {
        int[] a= {3,1,4,1,5,9,2};
        System.out.println(mistery(a));
    }
    //TODO::O(n^2)
    public static int mistery(int[] a) {
        int max = a[1] - a[0];
        for (int j = 2; j < a.length; j++) {
            for (int i = 0; i < j; i++) {
                if (a[j] - a[i] > max) {
                    max = a[j] - a[i];
                }
            }
        }
        return max;
    }


}
