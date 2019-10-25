import java.lang.Math;

public class Helper {

  public static float round(float num) {
    //round floats to the hundredth place

    float result = Math.round(num * 100);
    return result/100;
  }
}
