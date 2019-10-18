import java.util.Scanner;

public class Echelon {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    // Matrix matrix = new Matrix(4, 5);
    //
    // float[] vector1 = {3,2,3,8};
    // float[] vector2 = {4,5,6,2};
    // float[] vector3 = {7,8,9,6};
    // float[] vector4 = {1,4,9,2};
    // float[] vector5 = {3,6,3,5};
    // float[] vector6 = {7,8,8,4};
    //
    // matrix.add(vector1);
    // matrix.add(vector2);
    // matrix.add(vector3);
    // matrix.add(vector4);
    // matrix.add(vector5);
    // matrix.add(vector6);

    //******WILL BE DESIGNED FOR USER INPUT*******

    System.out.print("\n Please enter the length of your vector (i.e the space it lies in)   ");
    int rows = in.nextInt();

    System.out.print("\n Please enter the number of vectors in your matrix.   ");
    int cols = in.nextInt();

    Matrix matrix = new Matrix(rows, cols);

    int count = 0;
    while (count < cols) {

      System.out.println(" \n Please write out the elements of vector " + (count + 1) + " with each of its elements on a new line.");

      //reads in an extra number when constructing the vectors...why?
      int i = 0;
      float[] vector = new float[rows];
      while (i < 3) { //ctrl d to stop hasNext()
        if(in.hasNextInt()) {
          vector[i] = Float.valueOf(in.nextInt());
          i++;
        }
      }

      matrix.add(vector);
      count ++;
    }

    System.out.println();
    matrix.vectors();
    System.out.println();

    /* creates an upper triangular matrix by row reduction functionality
    implemented in the Matrix class */
    int vectorPos = 0;
    int columns = matrix.numCols();
    while (vectorPos < columns ) {

      matrix.leadingOne(vectorPos);
      float[] vector = matrix.getCol(vectorPos);

      for (int i = vectorPos + 1; i < matrix.numRows(); i++) {
        if (vector[i] != 0) {
          matrix.replace(vectorPos, i, -vector[i]);
        }
      } vectorPos ++;
    }

    matrix.vectors();
    System.out.println("\n");
  }
}
