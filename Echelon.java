import java.util.Scanner;

public class Echelon {



  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    System.out.println("\n\n Please enter the dimensions of your matrix in n x m form separated by a space \n where 'n' is the number of rows and 'n' is the number of columns. ");

    int rows = in.nextInt();
    int cols = in.nextInt();
    // Matrix matrix = new Matrix(in.nextInt(), in.nextInt());
    Matrix matrix = new Matrix(rows, cols);
    System.out.print(matrix.numRows());
    System.out.println(matrix.numCols());



  }
}
