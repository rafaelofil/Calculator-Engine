public class Calculate {
  static char opCodes[] = {'d', 'a', 's', 'm'};

  public static void main(String[] args) {
    double[] leftValues = {100.0d, 25.0d, 225.0d, 11.0d};
    double[] rightValues = {50.0d, 92.0d, 17.0d, 3.0d};
    double[] results = new double[opCodes.length];

    if(args.length == 0) {
//      for (int i = 0; i < opCodes.length; i++) {
//        results[i] = execute(opCodes[i], leftValues[i], rightValues[i]);
//      }
      for (double currentResult : results)
        System.out.println(currentResult);
    }
//    else if (args.length == 3)
//      handleCommandLine(args);
    else
      System.out.println("Please provide an operation code and 2 numeric values");
  }
}
