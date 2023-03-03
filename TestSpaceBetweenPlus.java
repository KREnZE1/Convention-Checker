import static org.junit.Assert.*;

import org.junit.Test;

public class TestSpaceBetweenPlus {

    static SpaceBetweenPlus rule = new SpaceBetweenPlus();

    @Test
    public void noPlus() {
        String testString = "Hallo";
        String expectedResult = "Hallo";
        String actualResult = rule.applyRule(testString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void correctPlus() {
        String testString = "hello + world";
        String expectedResult = "hello + world";
        String actualResult = rule.applyRule(testString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void missingSpaceBefore() {
        String testString = "hello+ world";
        String expectedResult = "hello + world";
        String actualResult = rule.applyRule(testString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void missingSpaceAfter() {
        String testString = "hello +world";
        String expectedResult = "hello + world";
        String actualResult = rule.applyRule(testString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void missingSpaceOnBothSides() {
        String testString = "hello+world";
        String expectedResult = "hello + world";
        String actualResult = rule.applyRule(testString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void plusAtEnd() {
        String testString = "hello+";
        String expectedResult = "hello +";
        String actualResult = rule.applyRule(testString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void plusplusOperatoratEnd() {
        String testString = "hello++";
        String expectedResult = "hello++";
        String actualResult = rule.applyRule(testString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void plusPlusOperatorMiddle() {
        String testString = "hell++o";
        String expectedResult = "hell++o";
        String actualResult = rule.applyRule(testString);
        assertEquals(expectedResult, actualResult);
    }

    //TODO: Create more testcases for the SpaceBetweenPlus-rule
    //TODO: Create testcases for any future rules (maybe some modular?)
}
