package main.math_evaluator.Parser;

import main.math_evaluator.Expression.Expression;
import main.math_evaluator.Expression.Number;
import main.math_evaluator.Expression.Operand;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExpressionParser {

  public Operand parse(String expression) {
    expression = expression.replaceAll("log", "1!").replaceAll("ln", "1@");

    return buildExpressionTree(convertToPostfixExpression(expression));
  }

  private String convertToPostfixExpression(String inputExpression) {
    Deque<Character> operatorStack = new ArrayDeque<>();
    StringBuilder postfixBuilder = new StringBuilder();
    char[] expressionChars = inputExpression.toCharArray();

    for (char character : expressionChars) {
      if (Character.isWhitespace(character)) continue;

      if (Character.isLetterOrDigit(character) || character == '.') {
        postfixBuilder.append(character);
      } else if (character == '(') {
        operatorStack.push(character);
      } else if (character == ')') {
        while (operatorStack.peek() != '(') {
          postfixBuilder.append(' ').append(operatorStack.pop());
        }
        operatorStack.pop();
      } else {
        while (!operatorStack.isEmpty() &&
                (getPrecedence(character) <= getPrecedence(operatorStack.peek())))
        {
          postfixBuilder.append(' ').append(operatorStack.pop());
        }
        operatorStack.push(character);
        postfixBuilder.append(' ');
      }
    }

    while (!operatorStack.isEmpty()) {
      postfixBuilder.append(' ').append(operatorStack.pop());
    }
    return postfixBuilder.toString();
  }

  private int getPrecedence(char operator) {
    return switch (operator) {
      case '^', '\u221A', '!', '@' -> 3;
      case '*', '/' -> 2;
      case '+', '-' -> 1;
      default -> throw new IllegalArgumentException("Invalid operator: " + operator);
    };
  }

  private Operand buildExpressionTree(String postfixExpression) {
    Deque<Operand> operandStack = new ArrayDeque<>();
    String[] tokens = postfixExpression.trim().split("\\s+");

    for (String token : tokens) {
      if (isNumber(token)) {
        operandStack.push(new Number(Double.parseDouble(token)));
      } else if (isOperator(token)) {
        Expression expr = new Expression(token.charAt(0));
        expr.setRightOperand(operandStack.pop());
        expr.setLeftOperand(operandStack.pop());
        operandStack.push(expr);
      } else {
        throw new IllegalArgumentException("Invalid token: " + token);
      }
    }

    return operandStack.pop();
  }

  private boolean isNumber(String token) {
    try {
      Double.parseDouble(token);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private boolean isOperator(String token) {
    final String operators = "+-*/^\u221A!@";
    return token.length() == 1 && operators.indexOf(token.charAt(0)) != -1;
  }
}
