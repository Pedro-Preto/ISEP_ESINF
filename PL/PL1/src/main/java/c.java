public class c {

    public static void main(String[] args) {
        System.out.println(minimumDC(48,30));
    }

    public static int minimumDC(int m, int n) {
        if ( n == 0 )
            return m;
        else if ( m >= n && n > 0)
            return minimumDC ( n , m % n );
        else return minimumDC ( n , m );
    }
}
