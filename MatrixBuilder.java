import java.util.Scanner;

public class MatrixBuilder {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    //*****DESIGNED FOR USER INPUT*******

    System.out.print("\n Please enter the length of your vector (i.e the space it lies in)   ");
    int rows = in.nextInt();

    System.out.print("\n Please enter the number of vectors in your matrix.   ");
    int cols = in.nextInt();

    Matrix matrix = new Matrix(rows, cols);

    int count = 0;
    while (count < cols) {

      System.out.println(" \n Please write out the elements of vector " + (count + 1) + " with each of its elements on a new line.");

      int i = 0;
      float[] vector = new float[rows];
      while (i < rows) {
        if(in.hasNextInt()) {
          vector[i] = Float.valueOf(in.nextInt());
          i++;
        }
      }
      matrix.addCol(vector);
      count ++;
    }

    System.out.println();
    matrix.vectors();
    System.out.println();

    Echelon.echelonForm(matrix);

    matrix.vectors();
    System.out.println("\n");

  }
}
