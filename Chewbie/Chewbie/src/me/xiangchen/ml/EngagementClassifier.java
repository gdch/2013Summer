package me.xiangchen.ml;

public class EngagementClassifier {

  public static double classify(Object[] i) throws Exception {
    double [] sums = new double [3];
    sums[(int) EngagementClassifier_0.classify(i)] += 4.875197323201151;
    sums[(int) EngagementClassifier_1.classify(i)] += 5.564520407322698;
    sums[(int) EngagementClassifier_2.classify(i)] += 4.638604962074329;
    sums[(int) EngagementClassifier_3.classify(i)] += 3.0008213430614616;
    sums[(int) EngagementClassifier_4.classify(i)] += 4.200097707663136;
    sums[(int) EngagementClassifier_5.classify(i)] += 3.6275601113393403;
    sums[(int) EngagementClassifier_6.classify(i)] += 3.8893889133620885;
    sums[(int) EngagementClassifier_7.classify(i)] += 4.704499507693915;
    sums[(int) EngagementClassifier_8.classify(i)] += 4.714551460471129;
    sums[(int) EngagementClassifier_9.classify(i)] += 4.715258504518093;
    double maxV = sums[0];
    int maxI = 0;
    for (int j = 1; j < 3; j++) {
      if (sums[j] > maxV) { maxV = sums[j]; maxI = j; }
    }
    return (double) maxI;
  }
}
class EngagementClassifier_0 {

  public static double classify(Object[] i)
    throws Exception {

    double p = Double.NaN;
    p = EngagementClassifier_0.N5f3fde6e0(i);
    return p;
  }
  static double N5f3fde6e0(Object []i) {
    double p = Double.NaN;
    if (i[13] == null) {
      p = 1;
    } else if (((Double) i[13]).doubleValue() <= 3.06) {
    p = EngagementClassifier_0.N5a24389c1(i);
    } else if (((Double) i[13]).doubleValue() > 3.06) {
      p = 0;
    } 
    return p;
  }
  static double N5a24389c1(Object []i) {
    double p = Double.NaN;
    if (i[11] == null) {
      p = 2;
    } else if (((Double) i[11]).doubleValue() <= 7.66) {
      p = 2;
    } else if (((Double) i[11]).doubleValue() > 7.66) {
      p = 1;
    } 
    return p;
  }
}
class EngagementClassifier_1 {

  public static double classify(Object[] i)
    throws Exception {

    double p = Double.NaN;
    p = EngagementClassifier_1.Nb8002(i);
    return p;
  }
  static double Nb8002(Object []i) {
    double p = Double.NaN;
    if (i[1] == null) {
      p = 1;
    } else if (((Double) i[1]).doubleValue() <= 2.91) {
    p = EngagementClassifier_1.N2f3008003(i);
    } else if (((Double) i[1]).doubleValue() > 2.91) {
      p = 0;
    } 
    return p;
  }
  static double N2f3008003(Object []i) {
    double p = Double.NaN;
    if (i[11] == null) {
      p = 2;
    } else if (((Double) i[11]).doubleValue() <= 7.66) {
      p = 2;
    } else if (((Double) i[11]).doubleValue() > 7.66) {
      p = 1;
    } 
    return p;
  }
}
class EngagementClassifier_2 {

  public static double classify(Object[] i)
    throws Exception {

    double p = Double.NaN;
    p = EngagementClassifier_2.N7a5d50334(i);
    return p;
  }
  static double N7a5d50334(Object []i) {
    double p = Double.NaN;
    if (i[13] == null) {
      p = 1;
    } else if (((Double) i[13]).doubleValue() <= 0.0) {
    p = EngagementClassifier_2.N43c83085(i);
    } else if (((Double) i[13]).doubleValue() > 0.0) {
      p = 0;
    } 
    return p;
  }
  static double N43c83085(Object []i) {
    double p = Double.NaN;
    if (i[11] == null) {
      p = 2;
    } else if (((Double) i[11]).doubleValue() <= 7.66) {
      p = 2;
    } else if (((Double) i[11]).doubleValue() > 7.66) {
      p = 1;
    } 
    return p;
  }
}
class EngagementClassifier_3 {

  public static double classify(Object[] i)
    throws Exception {

    double p = Double.NaN;
    p = EngagementClassifier_3.N20be84646(i);
    return p;
  }
  static double N20be84646(Object []i) {
    double p = Double.NaN;
    if (i[20] == null) {
      p = 2;
    } else if (((Double) i[20]).doubleValue() <= 5.52) {
      p = 2;
    } else if (((Double) i[20]).doubleValue() > 5.52) {
      p = 0;
    } 
    return p;
  }
}
class EngagementClassifier_4 {

  public static double classify(Object[] i)
    throws Exception {

    double p = Double.NaN;
    p = EngagementClassifier_4.N3be5d2077(i);
    return p;
  }
  static double N3be5d2077(Object []i) {
    double p = Double.NaN;
    if (i[14] == null) {
      p = 2;
    } else if (((Double) i[14]).doubleValue() <= 7.35) {
      p = 2;
    } else if (((Double) i[14]).doubleValue() > 7.35) {
    p = EngagementClassifier_4.N6d3fe8498(i);
    } 
    return p;
  }
  static double N6d3fe8498(Object []i) {
    double p = Double.NaN;
    if (i[16] == null) {
      p = 1;
    } else if (((Double) i[16]).doubleValue() <= 0.15) {
      p = 1;
    } else if (((Double) i[16]).doubleValue() > 0.15) {
      p = 0;
    } 
    return p;
  }
}
class EngagementClassifier_5 {

  public static double classify(Object[] i)
    throws Exception {

    double p = Double.NaN;
    p = EngagementClassifier_5.N7eab48a79(i);
    return p;
  }
  static double N7eab48a79(Object []i) {
    double p = Double.NaN;
    if (i[16] == null) {
      p = 1;
    } else if (((Double) i[16]).doubleValue() <= 0.15) {
    p = EngagementClassifier_5.N1f2f0ce910(i);
    } else if (((Double) i[16]).doubleValue() > 0.15) {
    p = EngagementClassifier_5.N49f8a4fd11(i);
    } 
    return p;
  }
  static double N1f2f0ce910(Object []i) {
    double p = Double.NaN;
    if (i[2] == null) {
      p = 2;
    } else if (((Double) i[2]).doubleValue() <= 7.97) {
      p = 2;
    } else if (((Double) i[2]).doubleValue() > 7.97) {
      p = 1;
    } 
    return p;
  }
  static double N49f8a4fd11(Object []i) {
    double p = Double.NaN;
    if (i[12] == null) {
      p = 0;
    } else if (((Double) i[12]).doubleValue() <= 3.83) {
      p = 0;
    } else if (((Double) i[12]).doubleValue() > 3.83) {
      p = 2;
    } 
    return p;
  }
}
class EngagementClassifier_6 {

  public static double classify(Object[] i)
    throws Exception {

    double p = Double.NaN;
    p = EngagementClassifier_6.N631803fb12(i);
    return p;
  }
  static double N631803fb12(Object []i) {
    double p = Double.NaN;
    if (i[13] == null) {
      p = 1;
    } else if (((Double) i[13]).doubleValue() <= 0.0) {
      p = 1;
    } else if (((Double) i[13]).doubleValue() > 0.0) {
    p = EngagementClassifier_6.N3dad869013(i);
    } 
    return p;
  }
  static double N3dad869013(Object []i) {
    double p = Double.NaN;
    if (i[18] == null) {
      p = 0;
    } else if (((Double) i[18]).doubleValue() <= 4.29) {
      p = 0;
    } else if (((Double) i[18]).doubleValue() > 4.29) {
      p = 2;
    } 
    return p;
  }
}
class EngagementClassifier_7 {

  public static double classify(Object[] i)
    throws Exception {

    double p = Double.NaN;
    p = EngagementClassifier_7.N4b5d779214(i);
    return p;
  }
  static double N4b5d779214(Object []i) {
    double p = Double.NaN;
    if (i[4] == null) {
      p = 2;
    } else if (((Double) i[4]).doubleValue() <= 3.06) {
    p = EngagementClassifier_7.N655538e515(i);
    } else if (((Double) i[4]).doubleValue() > 3.06) {
      p = 0;
    } 
    return p;
  }
  static double N655538e515(Object []i) {
    double p = Double.NaN;
    if (i[11] == null) {
      p = 2;
    } else if (((Double) i[11]).doubleValue() <= 7.66) {
      p = 2;
    } else if (((Double) i[11]).doubleValue() > 7.66) {
      p = 1;
    } 
    return p;
  }
}
class EngagementClassifier_8 {

  public static double classify(Object[] i)
    throws Exception {

    double p = Double.NaN;
    p = EngagementClassifier_8.N3e0a765c16(i);
    return p;
  }
  static double N3e0a765c16(Object []i) {
    double p = Double.NaN;
    if (i[1] == null) {
      p = 2;
    } else if (((Double) i[1]).doubleValue() <= 2.91) {
    p = EngagementClassifier_8.N20e0b1d617(i);
    } else if (((Double) i[1]).doubleValue() > 2.91) {
      p = 0;
    } 
    return p;
  }
  static double N20e0b1d617(Object []i) {
    double p = Double.NaN;
    if (i[11] == null) {
      p = 2;
    } else if (((Double) i[11]).doubleValue() <= 7.66) {
      p = 2;
    } else if (((Double) i[11]).doubleValue() > 7.66) {
      p = 1;
    } 
    return p;
  }
}
class EngagementClassifier_9 {

  public static double classify(Object[] i)
    throws Exception {

    double p = Double.NaN;
    p = EngagementClassifier_9.N7fbb697618(i);
    return p;
  }
  static double N7fbb697618(Object []i) {
    double p = Double.NaN;
    if (i[16] == null) {
      p = 2;
    } else if (((Double) i[16]).doubleValue() <= 0.15) {
    p = EngagementClassifier_9.N6909037d19(i);
    } else if (((Double) i[16]).doubleValue() > 0.15) {
      p = 0;
    } 
    return p;
  }
  static double N6909037d19(Object []i) {
    double p = Double.NaN;
    if (i[11] == null) {
      p = 2;
    } else if (((Double) i[11]).doubleValue() <= 7.66) {
      p = 2;
    } else if (((Double) i[11]).doubleValue() > 7.66) {
      p = 1;
    } 
    return p;
  }
}
