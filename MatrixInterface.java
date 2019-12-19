/*
*
* Provides interface for any current or future Matrix classes
*
*/


public interface MatrixInterface {

  public void addCol(float[] v);

  public int numRows();

  public int numCols();

  public void removeCol(int i);

  public float[] getCol(int location);

  public void setCol(int location, float[] v);

  public void vectors();

}
