public class Longestcollatzdiff {
    public static void main(String[] args) {
        long n = 0;
        int totalChanges = 0;
        long largestChange = 0;
        long largestChangeNum = 0;
        for (long i = 1; i <= 1000000; i++) {
            if (totalChanges > largestChange) {
                largestChange = totalChanges;
                largestChangeNum = i - 1;
            }
            totalChanges = 0;
            n = i;
            while (n != 1) {
                if (n % 2 == 0) {
                    n = n / 2;
                } else {
                    n = 3 * n + 1;
                }
                // System.out.println(n);
                totalChanges++;
            }
            // System.out.println(totalChanges);
            // System.out.println(largestChange + largestChangeNum);
        }
        System.out.println(largestChange + " is the biggest amount of change and "
                + largestChangeNum + " is the number that goes along with it");
    }
}