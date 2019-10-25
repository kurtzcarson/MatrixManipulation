

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
  public static void determinantLarge(Matrix matrix) {

    if (matrix.numCols() == 2 && matrix.numRows() == 2){
      determinantSmall(matrix);
    } else {
      // expansion();
    }
  }

  // does cofactor expansion of matrix
  public static void expansion(Matrix matrix) {

  }

  //calculates the determinant of a 2 x 2 matrix
  public static float determinantSmall(Matrix matrix) {

    float[] vectorOne = matrix.getCol(0);
    float[] vectorTwo = matrix.getCol(1);

    float determinant = (vectorOne[0]*vectorTwo[1]) - (vectorTwo[0]*vectorOne[1]);

    return determinant;

  }
}
