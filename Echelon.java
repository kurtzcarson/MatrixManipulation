import java.util.Scanner;

public class Echelon {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    Matrix matrix = new Matrix(4, 5);

    float[] vector1 = {3,2,3,8};
    float[] vector2 = {4,5,6,2};
    float[] vector3 = {7,8,9,6};
    float[] vector4 = {1,4,9,2};
    float[] vector5 = {3,6,3,5};
    float[] vector6 = {7,8,8,4};

    matrix.add(vector1);
    matrix.add(vector2);
    matrix.add(vector3);
    matrix.add(vector4);
    matrix.add(vector5);
    matrix.add(vector6);


    System.out.println("\n");
    matrix.vectors();
    System.out.println("\n");

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

    //******WILL BE DESIGNED FOR USER INPUT*******

    // System.out.print("\n Please enter the length of your vector (i.e the space it lies in)   ");
    // int rows = in.nextInt();
    //
    // System.out.print("\n Please enter the number of vectors in your matrix.   ");
    // int cols = in.nextInt();

    // Matrix matrix = new Matrix(rows, cols);

    // int count = 0;
    // while (count < rows) { // perform a "do while loop" ?
    //
    //   System.out.println(" \n Please write out your " + (count + 1)  + " vector with it's elements separated by a space.");
    //   String line = in.next(); //.nextInt() reads in the next token as an int value/ if cannot be read as int, then will throw an exception
    //   String[] lineArray = line.split(" ");
    //
    //   //Assert
    //
    //   int[] vector = new int[lineArray.length];
    //
    //   for (int i = 0; i < lineArray.length; i++) {
    //     vector[i] = Integer.valueOf(lineArray[i]);
    //   }
    //   for (int i: vector) {
    //     System.out.println(i);
    //   }
    //   matrix.add(vector);
    //   count ++;
    // }
    //
    // matrix.vectors();


  }
}
