import java.util.Scanner;

public class Ness_Connor_A1 {
    public static void main(String[] args) {

        // setup variables
        Scanner input = new Scanner(System.in);
        int totr, tott;
        totr = tott = 0;
        int[][] years;
        years = new int[5][3];
        years[0][0] = 1974;
        years[1][0] = 1975;
        years[2][0] = 1978;
        years[3][0] = 1979;
        years[4][0] = 2013;

        for(int i = 0; i < 5; i++) {
            System.out.println("Enter the distance Diana Nyad Swam in " + years[i][0] + ": ");
            years[i][1] = input.nextInt();
            System.out.println("How many hours did it take Nyad to swim the distance?");
            years[i][2] = input.nextInt();
            totr += years[i][1];
            tott += years[i][2];
        }

        System.out.println("+----------------------------------------------------------+");
        System.out.println("| Year  | Distance (miles)  | Time (hours)  | Speed (mph)  |");
        System.out.println("+----------------------------------------------------------+");
        for(int i = 0; i < 5; i++) {
            System.out.println(" " + years[i][0] + " | " + years[i][1] + " miles   | " + years[i][2] + " hours  | " + (years[i][1] / years[i][2]));
        }

        System.out.println("Diana Nyad's average speed is: " + (totr / tott));

    }
}
