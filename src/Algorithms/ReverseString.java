package Algorithms;


public class ReverseString {
    public static void main(String[] args) {
        String s = "qwer";
        System.out.println(reverse(s));
    }

    private static String reverse(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return reverse(b) + reverse(a);
    }
}
