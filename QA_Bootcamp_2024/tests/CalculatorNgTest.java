import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CalculatorNgTest {

    Calculator c;
    final String additionFailMessage = "Addition failed.";
    ExtentReports extent = new ExtentReports();;
    ITestContext testContext;

    @DataProvider
    public Object[][] calculatorDataProviderClassic() {
        return new Object[][] {
                {100, 20, 80, "+", additionFailMessage},
                {1000, 555, 445, "+", additionFailMessage},
                { 1, 1 , 0 , "+", additionFailMessage}
        };
    }

    @DataProvider
    public Iterator<Object[]> calculatorDataProvider() {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new Object[] {100, 20, 80, "+", additionFailMessage});
        dp.add(new Object[] {1000, 555, 445, "+", additionFailMessage});
        dp.add(new Object[] {1, 1 , 0 , "+", additionFailMessage});
        return dp.iterator();
    }

    private void setupGeneric() {
        c = new Calculator();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/report.html");
        extent.attachReporter(sparkReporter);
    }

    @BeforeSuite
    public void setUpSuite() {
        setupGeneric();
    }

    @BeforeClass
    public void setUpClass() {
        setupGeneric();
    }

    @BeforeMethod
    public void setUp() {

    }

    @BeforeGroups(groups = {"addition", "calculator"})
    public void setUpGroups() {
        setupGeneric();
    }

    @BeforeTest
    public void setUpTest(final ITestContext testContext) {
        this.testContext = testContext;
    }

    @Test(testName = "AdditionPositive", groups = {"addition", "calculator"})
    public void test01(Method method) {
//        setupGeneric();
        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName()); // java reflection - get name of the current method
        ExtentTest mytest = extent.createTest(method.getName());
        Assert.assertEquals(37, c.compute(24, 13, "+"), "Addition failed");
        mytest.log(Status.PASS, "test finished");
//        cleanUpGeneric();
    }

    @Test(testName = "AdditionNegatives", groups = {"addition", "calculator"})
    public void test03() {
        ExtentTest mytest = extent.createTest("AdditionNegatives");
        Assert.assertEquals(-23, c.compute(-11, -12, "+"), "Addition failed.");
        mytest.log(Status.PASS, "test finished");
        mytest.pass("finished");
    }

    @Test(testName = "AdditionParameters", groups = {"addition", "calculator"})
    @Parameters({"exp", "d1", "d2", "op", "errMess"})
    public void test04(String exp, String d1, String d2, String op, String errMess) {
        ExtentTest mytest = extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName());
        Assert.assertEquals(Double.parseDouble(exp), c.compute(Double.parseDouble(d1), Double.parseDouble(d2), op), errMess);
        mytest.pass("test finished");
    }

    @Test(testName = "AdditionDataProviderClassic", groups = {"addition", "calculator"}, dataProvider = "calculatorDataProviderClassic")
    public void test05(double exp, double d1, double d2, String op, String message) {
        ExtentTest mytest = extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName());
        Assert.assertEquals(exp, c.compute(d1, d2, op), message);
        mytest.pass("test finished");
    }

    @Test(testName = "AdditionDataProvider", groups = {"addition", "calculator"}, dataProvider = "calculatorDataProvider")
    public void test06(double exp, double d1, double d2, String op, String message) {
        ExtentTest mytest = extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName());
        Assert.assertEquals(exp, c.compute(d1, d2, op), message);
        mytest.pass("test finished");
    }

    private void cleanUpGeneric() {
        extent.flush();
    }

    @AfterSuite
    public void afterSuite() {
        cleanUpGeneric();
    }

    @AfterClass
    public void afterClass() {
        cleanUpGeneric();
    }

    @AfterGroups(groups = {"addition", "calculator"})
    public void afterGroups() {
        cleanUpGeneric();
    }

}