
public class Projecteuler {
    public static void main(String[] args) {
        boolean run = true;
        int x = 13000000;
        while (run) {
            int totalMultiples = 0;
            for (int i = 2; i <= 20; i++) {
                if (x % i != 0){
                  i++;
                  x++;
                  break;
                }
                if (x % i == 0) {
                    totalMultiples += 1;
                   // System.out.println(x + " " + i);
                } 
                
                if (totalMultiples == 19) {
                    System.out.println(x);
                    run = false;
                } 
              if (i == 20){
                x++;
              }
            }
            
        }
    }
}