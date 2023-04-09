public class Assignment1 {

    public static void main(String[] args) {}


    public static int getMin(int[] arr, int len,int currentIndex, int min) {

        if (currentIndex == len) {
            return min;
        }


        if (arr[currentIndex] < min) {
            min = arr[currentIndex];
        }

        return getMin(arr,len,currentIndex+1,min);






    }

    private static double getAverageRecursive(int[] arr, int n, int currentIndex, int currentSum) {
        if (currentIndex == n) {
            return (double) currentSum / n;
        }

        currentSum += arr[currentIndex];
        return getAverageRecursive(arr, n, currentIndex + 1, currentSum);
    }
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        return isPrimeHelper(n, 2);
    }

    private static boolean isPrimeHelper(int n, int divisor) {
        if (divisor * divisor > n) {
            return true;
        }

        if (n % divisor == 0) {
            return false;
        }

        return isPrimeHelper(n, divisor + 1);
    }



    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non negative");
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    private static int fib(int n) {
        if (n < 2)
            return n;

        return fib(n - 2) + fib(n - 1);
    }

    public static int powerRecursive(int a,int n){

        if(n == 0){
            return 1;
        }


        return a * powerRecursive(a,n-1);



    }




    public static boolean isAllDigits(String s,int currentIndex){

        if(currentIndex == s.length()){
            return true;
        }

        char currentChar = s.charAt(currentIndex);
        if (currentChar < '0' || currentChar > '9') {
            return false;
        }

        return isAllDigits(s,currentIndex+1);



    }

    public static void permutation(String input) {
        char[] arr = input.toCharArray();
        permutationRecursive(arr, 0);
    }

    private static void permutationRecursive(char[] arr, int i) {
        if (i == arr.length) {
            System.out.println(new String(arr));
            return;
        }

        for (int k = i; k < arr.length; k++) {
            swap(arr, i, k);
            permutationRecursive(arr, i + 1);
            swap(arr, i, k);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int binomialCoefficient(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    }
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}