package main.math_evaluator.Expression;

import javax.lang.model.type.NullType;

public class Expression implements Operand {
  private char operation;
  private Operand leftOperand, rightOperand;

  public Expression(char operation) {
    this.operation = operation;
  }

  public void setLeftOperand(Operand left) {
    this.leftOperand = left;
  }

  public void setRightOperand(Operand right) {
    this.rightOperand = right;
  }

  @Override
  public double evaluate() {
    double leftValue = leftOperand.evaluate();
    double rightValue = rightOperand.evaluate();
    return switch (operation) {
      case '#' -> leftValue * Math.sin(rightValue);
      case '&' -> leftValue * Math.cos(rightValue);
      case '_' -> leftValue * Math.tan(rightValue);
      case '@' -> leftValue * Math.log(rightValue);
      case '!' -> leftValue * Math.log10(rightValue);
      case '^' -> Math.pow(leftValue, rightValue);
      case '\u221A' -> Math.pow(rightValue, 1 / leftValue);
      case '*' -> leftValue * rightValue;
      case '/' -> leftValue / rightValue;
      case '+' -> leftValue + rightValue;
      case '-' -> leftValue - rightValue;
      default -> throw new IllegalStateException("Invalid operation: " + operation);
    };
  }
}