import structure5.*;
import java.util.Arrays;

public class Matrix {

  int vectorLength;
  Vector<int[]> matrix;

  // Constructor that intializes matrix of i vectors
  public Matrix(int vectorLength, int size) {
    matrix = new Vector<int[]>(size);
    this.vectorLength = vectorLength;
  }

  public void add(int[] v) {

    Assert.pre(v.length == vectorLength, "Invalid vector length for matrix of " + vectorLength + " space.");

    matrix.add(v);
  }

  public int numRows() {
    return this.vectorLength;
  }

  public int numCols() {
    return matrix.size();
  }

  public void remove(int i) {
    matrix.remove(i);
  }

  public int[] get(int location) {
    return matrix.get(location);
  }

  public void set(int location, int[] v) {
    matrix.set(location, v);
  }

  public void swap(int row1, int row2) {

    for (int i = 0; i < matrix.size(); i++) {
      int temp = matrix.get(i)[row1];
      matrix.get(i)[row1] = matrix.get(i)[row2];
      matrix.get(i)[row2] = temp;
    }

  }

  public void scale(int row, int scalar) {

    for (int i = 0; i < matrix.size(); i++) {
      matrix.get(i)[row] *= scalar;
    }
  }

  public void reduce(int row1, int row2, int scalar) {

    for (int i = 0; i < matrix.size(); i++) {
      matrix.get(i)[row2] = (matrix.get(i)[row1]*scalar) + matrix.get(i)[row2];
    }
  }

  //maybe need to make this a toString() method
  public void vectors() {

    for (int i = 0; i < matrix.size(); i++) {
      Vector<Integer> display = new Vector<Integer>(matrix.size());
      for (int e = 0; e <matrix.size(); e++) {
        display.add(matrix.get(e)[i]);
      }
      System.out.println(display.toString());
    }
  }

  public static void main(String[] args) {

    Matrix matrix = new Matrix(3,3);

    int[] vector1 = {1,2,3};
    int[] vector2 = {4,5,6};
    int[] vector3 = {7,8,9};

    matrix.add(vector1);
    matrix.add(vector2);
    matrix.add(vector3);

    matrix.swap(0, 1);
    matrix.scale(1, -1);
    matrix.reduce(1,2,-1);
    // swap(matrix[0], matrix[1]);

    matrix.vectors();

  }
}
