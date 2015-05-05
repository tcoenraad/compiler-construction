package pp.block2.cc.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pp.block2.cc.antlr.Calculator;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setup() {
        this.calculator = new Calculator();
    }

    @Test
    public void testParenthesis() {
        Assert.assertEquals(35, calculator.evaluate("(2+3)*7").intValue());
        Assert.assertEquals(23, calculator.evaluate("2+(3*7)").intValue());
        Assert.assertEquals(23, calculator.evaluate("2+3*7").intValue());
        Assert.assertEquals(35, calculator.evaluate("(35)").intValue());
        Assert.assertEquals(35, calculator.evaluate("((35))").intValue());

        Assert.assertEquals(null, calculator.evaluate("2+3*7)"));
        Assert.assertEquals(null, calculator.evaluate("2+(3*7"));
        Assert.assertEquals(null, calculator.evaluate("("));
        Assert.assertEquals(null, calculator.evaluate(")"));
    }

    @Test
    public void testMinus() {
        Assert.assertEquals(-35, calculator.evaluate("-35").intValue());

        Assert.assertEquals(null, calculator.evaluate("35-"));
        Assert.assertEquals(null, calculator.evaluate("35--"));
        Assert.assertEquals(null, calculator.evaluate("-"));
    }

    @Test
    public void testPower() {
        Assert.assertEquals(8, calculator.evaluate("2^3").intValue());
        Assert.assertEquals(512, calculator.evaluate("2^3^2").intValue());
        Assert.assertEquals(512, calculator.evaluate("2^(3^2)").intValue());
        Assert.assertEquals(64, calculator.evaluate("(2^3)^2").intValue());

        Assert.assertEquals(null, calculator.evaluate("2^"));
        Assert.assertEquals(null, calculator.evaluate("2^^"));
        Assert.assertEquals(null, calculator.evaluate("^"));
    }

    @Test
    public void testMultiplication() {
        Assert.assertEquals(35, calculator.evaluate("5*7").intValue());
        Assert.assertEquals(35, calculator.evaluate("-5*-7").intValue());
        Assert.assertEquals(-35, calculator.evaluate("5*-7").intValue());
        Assert.assertEquals(-35, calculator.evaluate("-5*7").intValue());

        Assert.assertEquals(null, calculator.evaluate("35*"));
        Assert.assertEquals(null, calculator.evaluate("35**"));
        Assert.assertEquals(null, calculator.evaluate("*"));
    }

    @Test
    public void testAddition() {
        Assert.assertEquals(35, calculator.evaluate("30+5").intValue());

        Assert.assertEquals(null, calculator.evaluate("35+"));
        Assert.assertEquals(null, calculator.evaluate("35++"));
        Assert.assertEquals(null, calculator.evaluate("+"));
    }

    @Test
    public void testSubtraction() {
        Assert.assertEquals(35, calculator.evaluate("40-5").intValue());

        Assert.assertEquals(null, calculator.evaluate("35-"));
        Assert.assertEquals(null, calculator.evaluate("35--"));
        Assert.assertEquals(null, calculator.evaluate("-"));
    }

    @Test
    public void testNumber() {
        Assert.assertEquals(35, calculator.evaluate("35").intValue());
    }

    @Test
    public void testUnknownCharacters() {
        Assert.assertEquals(35, calculator.evaluate("35 ").intValue());

        Assert.assertEquals(null, calculator.evaluate("_"));
        Assert.assertEquals(null, calculator.evaluate("a"));
    }
}
