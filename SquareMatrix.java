
import structure5.*;

public class SquareMatrix extends Matrix {
  /*
  *
  * All methods below this line provide fundamental operations of matrices to
  * determine their fundamental properties
  *
  */

  public SquareMatrix(int vectorLength, int size) {
    //constructs 'matrix' with the vector class provided by structure5.*

    super(vectorLength, size);
    Assert.condition(vectorLength == size, "Matrix must be square. Check dimesions. ");


  }

  public int dimension() {
    return matrix.size();
  }

  public void echelonForm() {

    /* creates an upper triangular matrix by row reduction functionality
    implemented in the Matrix class */
    leadingZero();
    int vectorPos = 0;
    int columns = matrix.size();
    while (vectorPos < columns ) {

      leadingOne(vectorPos);
      float[] vector = matrix.get(vectorPos);

      for (int i = vectorPos + 1; i < numRows(); i++) {
        if (vector[i] != 0) {
          replace(vectorPos, i, -vector[i]);
        }
      } vectorPos ++;
    }
  }


  public boolean linearlyIndependent() {
    // pre: called on non-empty Matrix object
    // post: returns true if linearly indepenedent

    Assert.condition(matrix.size() > 0, "Matrix needs to contain at least one vector");

    if (matrix.size() > matrix.get(0).length) return false;

    echelonForm();

    for (int i = 0; i < matrix.size(); i++) {
      if (matrix.get(i)[i] == 0) {
        return false;
      }
    } return true;
  }

  public boolean linearlyDependent() {
    // pre: called on non-empty SquareMatrix object
    // post: returns true if linearly depenedent

    return !linearlyIndependent();
  }

  public boolean isInvertible() {
    // pre: called on non-empty SquareMatrix object
    // post: returns true if linearly indepenedent

    return linearlyIndependent();
  }

  public SquareMatrix inverse() {
    //pre: giveen a non-empty 2 x 2 matrix (maybe can extend if change to reverse row reducing I)
    // post: return it's inverse if exists

    Assert.condition(isInvertible(), "INVALID. Matrix must be invertible");

    if (dimension() == 2) {
      float inverseFraction = (1 / determinant());
      float[] vector1 = {(inverseFraction*matrix.get(1)[1]), -(inverseFraction*matrix.get(0)[1])};
      float[] vector2 = {-(inverseFraction*matrix.get(1)[0]), (inverseFraction*matrix.get(0)[0])};

      //should p
      SquareMatrix inverseMatrix = new SquareMatrix(2,2);
      inverseMatrix.addCol(vector1);
      inverseMatrix.addCol(vector2);

      return inverseMatrix;
    }

    return new SquareMatrix(0, 0);


  }

  private float determinant() {
    //pre: passed a non-empty SquareMatrix
    //post: return the determinant

    if (dimension() == 2) {
      float determinant = ((matrix.get(0)[0] * matrix.get(1)[1]) - matrix.get(0)[1]*matrix.get(1)[0]);
      return determinant;
    }
    return -1;

    //need implementation for larger square matrices
  }

  public int size() {
    return matrix.size();
  }


public static void main(String[] args) {

  SquareMatrix myMatrix = new SquareMatrix(3,3);
  System.out.println("MatrixSizeBefore: " + myMatrix.size());
  float[] v1 = {6, 4, 2};
  float[] v2 = {3, 2, 0};
  float[] v3 = {3, 2, 1};

  myMatrix.addCol(v1);
  myMatrix.addCol(v2);
  myMatrix.addCol(v3);

  System.out.println("Matrix Size Now: " + myMatrix.size());

  System.out.println(myMatrix.linearlyIndependent());
  System.out.println(myMatrix.linearlyDependent());

  }
}
