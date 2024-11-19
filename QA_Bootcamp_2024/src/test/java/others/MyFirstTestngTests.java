package Others;

import org.testng.annotations.*;

public class MyFirstTestngTests {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Running the code before suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Running the code before class");
    }

    @BeforeGroups(groups = {"print"})
    public void beforeGroups() {
        System.out.println("Running before groups");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Running the code before each test");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Running before method");
    }

    @Test(testName = "MyFirstTest", description = "This is my first TestNG test", groups = {"basicTest"}, priority = 2)
    public void test01() {
        System.out.println("My first testng test");
    }

    @Test(groups = {"print"})
    public void test02() {
        printSomething("test02");
    }

    @Test(groups = {"print"}, enabled = false, priority = 0)
    public void test03() {
        printSomething("test03");
    }

    private void printSomething(String something) {
        System.out.println("Printing something: " + something);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Running code after the method.");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Running the code after the test.");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("Running code after groups");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Running code after class.");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Running code after suite.");
    }


}