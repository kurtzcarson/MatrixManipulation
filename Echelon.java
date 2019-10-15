import java.util.Scanner;

public class Echelon {

  //Realized that this method is obsolete
  public static void leadingOne(Matrix matrix) {

    //checks if first row already begins with 1
    if (matrix.get(0)[0] == 1) return;

    //trys to find a row that begins with 1 and swaps it
    for (int i = 1; i < matrix.get(0).length; i++ ) {
      if (matrix.get(0)[i] == 1){
        matrix.interchange(0, i);
        break;
      }
    } return;
  }

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    Matrix matrix = new Matrix(3, 3);

    int[] vector1 = {2,1,3};
    int[] vector2 = {4,5,6};
    int[] vector3 = {7,8,9};

    matrix.add(vector1);
    matrix.add(vector2);
    matrix.add(vector3);

    leadingOne(matrix);
    matrix.vectors();

    int vectorPos = 0;
    int columns = matrix.numCols();

    int[] vector = matrix.get(vectorPos);

    while (vectorPos < columns ) {

      // makes all values below the pivot position equal zero to begin to
      // get into Echelon form
      for (int i = vectorPos + 1; i < vector.length; i++) {
        if (vector[i] != 0) {
          matrix.replace(0, i, -vector[i]);
        }
      } vectorPos ++;
    }

    matrix.vectors();


      // figure put by what factor to combine things to make zero
      //then performing replace with rows and scalar (remember row2 is the
      // one being replaced )

    //   rows --;
    // }

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
