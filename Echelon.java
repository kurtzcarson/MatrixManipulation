import java.util.Scanner;

public class Echelon {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    System.out.println("\n Please enter the length of your vector (i.e the space it lies in)");
    int rows = in.nextInt();

    System.out.println("\n Please enter the number of vectors in your matrix.");
    int cols = in.nextInt();

    Matrix matrix = new Matrix(rows, cols);

    while (0 < rows) {

      System.out.println("Please write out your " + rows + " vector with it's elements separated by a space.");
      String line = in.nextLine();
      String[] lineArray = line.split(" ");
      int[] vector = new int[lineArray.length];

      for (int i = 0; i < lineArray.length; i++) {
        vector[i] = Integer.parseInt(lineArray[i]);
      }
      rows --;

    }



  }
}
