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
        Assert.assertEquals(23, calculator.evaluate("2+3*7").intValue());
    }

    @Test
    public void testUnary() {
        Assert.assertEquals(-35, calculator.evaluate("-35").intValue());
    }

    @Test
    public void testPower() {
        Assert.assertEquals(35, calculator.evaluate("5*7").intValue());
        Assert.assertEquals(35, calculator.evaluate("-5*-7").intValue());
    }

    @Test
    public void testPlus() {
        Assert.assertEquals(35, calculator.evaluate("30+5").intValue());
    }

    @Test
    public void testMinus() {
        Assert.assertEquals(35, calculator.evaluate("40-5").intValue());
    }
}
