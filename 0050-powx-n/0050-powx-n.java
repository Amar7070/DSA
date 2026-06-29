class Solution {
    double pow(double x,long n){
        if(n==0) return 1;
        double half = pow(x,n/2);
        double xn = half * half;
        if(n%2==1) xn*=x;
        return xn;
    }
    public double myPow(double x, int n) {
        long N = n;
        if(N<0){
            x = 1/x;
            N = -N;
        }
        return pow(x,N);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna