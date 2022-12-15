public class b {

    public static void main(String[] args) {
        System.out.println(addiction(5, 5));
        System.out.println(subtraction(5, 5));

    }

    public static Integer addiction(Integer m, Integer n) {
        if (n == 1) {
            return m;
        }
        return m + addiction(m, n - 1);
    }

    public static Integer subtraction(Integer m, Integer n) {
        if (n == 0)
            return 0;
        n--;
        return m + subtraction(m, n);
    }
}
