package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
@Test
    public void sumTest(){
    int sum = new Calculator().sum(1, 2);
    Assert.assertEquals(sum, 3);
}
    @Test
    public void multiplyTest(){
        int multiplyTest = new Calculator().multiply(1, 2);
        Assert.assertEquals(multiplyTest, 3);
    }
}
