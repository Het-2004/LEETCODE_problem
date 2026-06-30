class Solution {
    public double myPow(double x, int n) {

        long N = n;          // Convert int to long first

        if (N < 0) {
            x = 1.0 / x;
            N = -N;
        }

        double ans = 1.0;

        while (N > 0) {

            if ((N & 1) == 1) {   // If exponent is odd
                ans *= x;
            }

            x *= x;               // Square the base
            N >>= 1;              // Divide exponent by 2
        }

        return ans;
    }
}