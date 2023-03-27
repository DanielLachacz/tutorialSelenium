package pl.testeroprogramowania;

import org.testng.annotations.Test;

public class ThirdTest {

    @Test(priority = 2)
    public void firstTest() {
        System.out.println("I am a first test");
    }

    @Test(priority = 0)
    public void secondTest() {
        System.out.println("I am a second test");
    }

    @Test(priority = 1)
    public void thirdTest() {
        System.out.println("I am a third test");
    }
}
