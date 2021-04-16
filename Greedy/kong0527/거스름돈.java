public class Main {

    public static void main(String[] args) {
        System.out.println(solve(1260));
    }

    public static int solve (int n) {
        int[] money = {500, 100, 50, 10};
        int count = 0;

        for (int i = 0; i < money.length; i++) {
            int mod = n / money[i];
            n -= mod * money[i];
            count += mod;
        }

        return count;
    }
}
