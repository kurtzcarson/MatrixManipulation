
//library I frequently use in my class
import structure5.*;

import java.util.Arrays;

public class Matrix {

  int vectorLength;
  Vector<int[]> matrix;

  // Constructor that intializes matrix of n x m matrix
  public Matrix(int vectorLength, int size) {
    matrix = new Vector<int[]>(size);
    this.vectorLength = vectorLength;
  }

  //adds a vector v to the matrix
  public void add(int[] v) {

    Assert.pre(v.length == vectorLength, "Invalid vector length for matrix of " + vectorLength + " space.");

    matrix.add(v);
  }

  // returns the number of rows (i.e the space the vectors lie in)
  public int numRows() {
    return this.vectorLength;
  }

  // returns the number of columns or vectors in the matrix
  public int numCols() {
    return matrix.size();
  }

  //removes a particular matrix specified by column
  public void remove(int i) {
    matrix.remove(i);
  }

  //returns the vector at the specified location in the matrix
  public int[] get(int location) {
    return matrix.get(location);
  }

  //sets the vector at a location in the matrix
  public void set(int location, int[] v) {
    matrix.set(location, v);
  }

  //swaps row 1 with row 2 (elementary row opereation)
  public void interchange(int row1, int row2) {

    for (int i = 0; i < matrix.size(); i++) {
      int temp = matrix.get(i)[row1];
      matrix.get(i)[row1] = matrix.get(i)[row2];
      matrix.get(i)[row2] = temp;
    }

  }

  //scales a particular row by a scalar (elementary row operation)
  public void scale(int row, int scalar) {

    for (int i = 0; i < matrix.size(); i++) {
      matrix.get(i)[row] *= scalar;
    }
  }

  //replaces row2 by the sum of itself an a multiple of row1
  public void replace(int row1, int row2, int scalar) {

    for (int i = 0; i < matrix.size(); i++) {
      matrix.get(i)[row2] = (matrix.get(i)[row1]*scalar) + matrix.get(i)[row2];
    }
  }

  //prints matrix in a legible format scene in linear algebra
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

    // just testing the code
    Matrix matrix = new Matrix(3,3);

    int[] vector1 = {1,2,3};
    int[] vector2 = {4,5,6};
    int[] vector3 = {7,8,9};

    matrix.add(vector1);
    matrix.add(vector2);
    matrix.add(vector3);

    matrix.interchange(0, 1);
    matrix.scale(1, -1);
    matrix.replace(1,2,-1);

    matrix.vectors();

  }
}
