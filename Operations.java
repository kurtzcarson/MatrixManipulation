

import structure5.*;


public class Operations {

    /*
    *
    * pre: passed non-empty Matrix object
    * post: returns true if linearly indepenedent
    *
    */
  public static boolean linearlyIndependent(Matrix matrix) {

    Assert.condition(matrix.numCols() > 0, "Matrix needs to contain at least one vector");

    for (int i = 0; i < matrix.numCols(); i++) {
      if (matrix.getCol(i)[i] == 0) {
        return false;
      }
    } return true;
  }

  /*
  *
  * pre: passed non-empty Matrix object
  * post: returns true if linearly depenedent
  *
  */
  public static boolean linearlyDependent(Matrix matrix) {

    return !linearlyIndependent(matrix);
  }

  //needs to be a recursive call on the matrix to determine determinant
  public static void determinant(Matrix matrix) {

  //   //recursively call expansions on matrices
  //   if (matrix.numCols() == 2 && matrix.numRows() == 2){
  //     determinantHelper(matrix);
  //
  //   } else {
  //
  //     float determinant = 0;
  //     Echelon.echelonForm(matrix);
  //
  //     for (int i = 0; i < matrix.numCols(); i++) {
  //
  //     }
  //   }
  // }

  // does cofactor expansion of linearly independent matrix
  public static void cofactorExpansion(Matrix matrix, int row, int col) {

      //gets the proper element in matrix for cofactor expansion
      float element = matrix.get(col)[row];

      //checks to see if cofactor needs to be multipled by -1
      if ( (row + col)%2 != 0 ) {
        element *= -1;
      }

      //call removeRow(row)
      //call removeCol(col)
      //determinant(matrix)


  }

  //calculates the determinant of a 2 x 2 matrix
  public static float determinantHelper(Matrix matrix) {

    float[] vectorOne = matrix.getCol(0);
    float[] vectorTwo = matrix.getCol(1);

    float determinant = (vectorOne[0]*vectorTwo[1]) - (vectorTwo[0]*vectorOne[1]);

    return determinant;

  }
}
