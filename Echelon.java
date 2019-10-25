/*
*
* The current implementation of the Echelon class is only equipped to handle
* linearly independent matrices that form a basis for some space R^n. I am still
* working to create functions that create upper triangluar matrices properly so
* that my free and basic variables are accurately defined.
*
*/

public class Echelon {

  public static void echelonForm(Matrix matrix) {

    /* creates an upper triangular matrix by row reduction functionality
    implemented in the Matrix class */
    matrix.leadingZero();
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
  }



}

//If first row has leading zero vector need to flip with another row
