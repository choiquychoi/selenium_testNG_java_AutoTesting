package testng;

import org.testng.annotations.*;

public class Topic_01_Annotation {
    @BeforeSuite
    public void BeforeSuite() {
        System.out.println("Đây là BeforeSuite");
    }

    @AfterSuite
    public void AfterSuite() {
        System.out.println("Đây là AfterSuite");
    }

    @BeforeTest
    public void BeforeTest() {
        System.out.println("Đây là BeforeTest");
    }

    @AfterTest
    public void AfterTest() {
        System.out.println("Đây là AfterTest");
    }

    @BeforeClass
    public void BeforeClass() {
        System.out.println("Đây là BeforeClass");
    }

    @AfterClass
    public void AfterClass() {
        System.out.println("Đây là AfterClass");
    }

    @BeforeMethod
    public void BeforeMethod() {
        System.out.println("Đây là BeforeMethod");
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("Đây là AfterMethod");
    }

    @Test
    public void TestCase() {
        System.out.println("Đây là TestCase");
    }

}
