public class Longestcollatzdiff {
    public static void main(String[] args) {
      int n = 0;
      int totalChanges = 0;
      int largestChange = 0;
      int largestChangeNum = 0;
       for (int i = 1; i <= 13; i++){
        if (totalChanges > largestChange){
            largestChange = totalChanges;
            largestChangeNum = i - 1;
        }
        totalChanges = 0;
         n = i;
         while (n != 1){
           if (n % 2 == 0){
             n = n / 2;
           } else {
             n = 3 * n + 1;
           }
           System.out.println(n);
           totalChanges++;
         }
         //System.out.println(totalChanges);
         //System.out.println(largestChange + largestChangeNum);
       }
       System.out.println(largestChange + " is the biggest amount of change and " 
       + largestChangeNum + " is the number that goes along with it");
    }
}