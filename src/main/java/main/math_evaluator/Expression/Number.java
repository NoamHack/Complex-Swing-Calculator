package main.math_evaluator.Expression;

/**
 * Represents a numerical operand in an expression.
 */
public class Number implements Operand {

  /**
   * Value of the number.
   */
  private final double value;

  /**
   * Constructs a new {@code Number} instance with the specified value.
   *
   * @param value The numeric value this object should represent.
   */
  public Number(double value) {
    this.value = value;
  }

  /**
   * Evaluates the numeric value of this operand.
   *
   * @return The value of this {@code Number}.
   */
  @Override
  public double evaluate() {
    return value;
  }
}
