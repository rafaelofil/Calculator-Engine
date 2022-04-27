import java.util.Scanner;

public class Calculate {
  static char operationCodes[] = {'a', 's', 'm', 'd'};

  public static void main(String[] args) {
    double[] leftValues = {100.0d, 25.0d, 225.0d, 11.0d};
    double[] rightValues = {50.0d, 92.0d, 17.0d, 3.0d};
    double[] results = new double[operationCodes.length];

    if(args.length == 0) {
      for (int i = 0; i < operationCodes.length; i++) {
        results[i] = execute(operationCodes[i], leftValues[i], rightValues[i]);
      }
      for (double currentResult : results)
        System.out.println(currentResult);
    } else if (args.length == 1 && args[0].equals("interactive"))
        executeInteractively();
    else if (args.length == 3)
      handleCommandLine(args);
    else
      System.out.println("Please provide an operation code and 2 numeric values");
  }

  static void executeInteractively() {
    System.out.println("Enter an operation and two numbers:");
    Scanner scanner = new Scanner(System.in);
    String userInput = scanner.nextLine();
    String[] parts = userInput.split(" ");
//    performOperation(parts);
  }

  static double execute(char operationCode, double leftValue, double rightValue) {
    double result;
    switch (operationCode) {
      case 'a':
        result = leftValue + rightValue;
        break;
      case 's':
        result = leftValue - rightValue;
        break;
      case 'm':
        result = leftValue * rightValue;
        break;
      case 'd':
        result = rightValue != 0 ? leftValue / rightValue : 0.0d;
        break;
      default:
        result = 0.0d;
        break;
    }

    return result;
  }

  static char opCodeFromString(String operationName) {
    char opCode = operationName.charAt(0);
    return opCode;
  }

  double valueFromWord(String word) {
    String[] numberWords = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
    };

    double value = 0d;

    for(int i = 0; i < numberWords.length; i++) {
      if(word.equals(numberWords[i]))
        value = i;
        break;
    }

    return value;
  }

  private static void handleCommandLine(String[] args) {
    char operationCode = args[0].charAt(0);
    double leftValue = Double.parseDouble(args[1]);
    double rightValue = Double.parseDouble(args[2]);
    double result = execute(operationCode, leftValue, rightValue);

    System.out.println(result);
  }

  private static void performOperation(String[] parts) {
    char opCode = opCodeFromString(parts[0]);
    double leftValue = valueFromWord(parts[1]);
    double rightValue = valueFromWord(parts[2]);
    double result = execute(opCode, leftValue, rightValue);

    System.out.println(result);
  }

  private static char symbolFromOpCode(char opCode) {
    char[] symbols = {'+', '-', '*', '/'};
    char symbol = ' ';

    for(int i = 0; i < operationCodes.length; i++) {
      if(opCode == operationCodes[i]) {
        if(opCode == operationCodes[i]) {
          symbol = symbols[i];
          break;
        }
      }
    }

    return symbol;
  }
}
