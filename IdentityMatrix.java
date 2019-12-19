import structure5.*;

public class IdentityMatrix extends SquareMatrix {

  public IdentityMatrix(int vectorLength, int size) {

    super(vectorLength, size);
    buildIdentityMatrix();
  }

  public void buildIdentityMatrix() {
    //post: builds an identity matrix that can be used in various applications

    for ( int i = 0; i < vectorLength; i++ ) {
      float[] vector = new float[vectorLength];
      for ( int pos = 0; pos < vector.length; pos ++ ) {
        vector[pos] = 0;
      }
      vector[i] = 1;
      matrix.add(vector);
    }

  }

  public static void main(String[] args) {

    IdentityMatrix I = new IdentityMatrix(3,3);
    I.vectors();
  }
}
