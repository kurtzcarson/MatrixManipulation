/*
*
* The Matrix class is composed of a Vector of Arrays that is utilized to
* represent the matrices often encountered in linear algebra. This class supports
* the addition of new vectors to a matrix in a specified space R, while providing
* elementary row operation functionality to reduce the matrix. The matrix
* is then designed to be printed to the console in the common matrix form encountered
* in linear algebra.
*
*/

import java.util.Arrays;
import structure5.*;
// package commonly used in my data structures course

public class Matrix implements MatrixInterface {

  protected int vectorLength;
  protected Vector<float[]> matrix;


  public Matrix(int vectorLength, int size) {
    //constructs 'matrix' with the vector class provided by structure5.*

    matrix = new Vector<float[]>(size);
    this.vectorLength = vectorLength;
  }

  public void add(float[] v) {
    /*
    * Adds a new 'vector' to the 'matrix'
    * Utilizes the Assert object provided by the structure5 class
    */
    Assert.pre(v.length == vectorLength, "Invalid vector length for matrix of " + vectorLength + " space.");
    matrix.add(v);
  }

  public int numRows() {
    //returns the number of rows in the matrix

    return this.vectorLength;
  }

  public int numCols() {
      // returns the number of columns(i.e vectors) in the matrix

    return matrix.size();
  }

  public void remove(int i) {
    //removes the specified vector based on index from the matrix

    matrix.remove(i);
  }

  public float[] getCol(int location) {
    // returns the vector at a specified location of the matrix

    return matrix.get(location);
  }

  public void setCol(int location, float[] v) {
    //sets the vector at a location in the matrix

    matrix.set(location, v);
  }

  public void interchange(int row1, int row2) {
      //swaps row 1 with row 2 (elementary row opereation)

    for (int i = 0; i < matrix.size(); i++) {
      float temp = matrix.get(i)[row1];
      matrix.get(i)[row1] = matrix.get(i)[row2];
      matrix.get(i)[row2] = temp;
    }
  }

  public void scale(int row, int scalar) {
    //scales a particular row by a scalar (elementary row operation)

    for (int i = 0; i < matrix.size(); i++) {
      matrix.get(i)[row] *= scalar;
    }
  }


  public void replace(int row1, int row2, float scalar) {
    //replaces row2 by the sum of itself an a multiple of row1

    for (int i = 0; i < matrix.size(); i++) {
      matrix.get(i)[row2] = (matrix.get(i)[row1]*scalar) + matrix.get(i)[row2];
    }
  }

  public void leadingOne(int row) {
    /*
    * Pre: pass an int of the row you want with a leading 1
    * Post: row reduces to produce a leading 1 in specified row
    */
      if (row < numRows()) {

        float diagonal = matrix.get(row)[row];

        for (int i = row; i < numCols(); i++) {
          matrix.get(i)[row] /= diagonal;
          matrix.get(i)[row] = Helper.round(matrix.get(i)[row]);
        }
      }
  }

  public void vectors() {
      //prints matrix in a intelligible format seen in linear algebra

    for (int i = 0; i < numRows(); i++) {
      Vector<Float> display = new Vector<Float>(matrix.size());
      for (int e = 0; e < numCols(); e++) {
        display.add(matrix.get(e)[i]);
      }
      System.out.println(display.toString());
    }
  }

}
