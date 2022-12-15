package Ano2019_2020_Recurso.Ex2;

public class Main {
    public static void main(String[] args) {

        Integer array[] = {1, 2, 4, 6, 8, 10, 12, 14};
        System.out.println(mistery(array,array.length,10));
    }


    public static int mistery(Integer[] a, int n, Integer x) {

        if (a[n - 1] < x)
            return n;//se o ultimo membro de a for menor que x damos return ao tamanho do array

        if (a[0] >= x)//se o primeiro membro do array for maior ou igual a x retorna-se 0
            return 0;

        int l = 0, u = n - 1;//u é igual ao tamanho do array menos 1(indice da ultima posição do array)

        while (l < u) {//enquanto que l for maior que u
            int m = (l + u) / 2;
            if (a[m] < x)
                l = m + 1;
            else
                u = m;
        }
        return l;
    }
}
