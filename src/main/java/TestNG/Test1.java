package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {

    @DataProvider(name = "testsData")
    public static Object[][] testData() {
        return new Object[][]{
                {"sql", 1},
                {"nosql", 5}
        };
    }

    @Parameters("tests")
    @Test(groups = {"smokeTest", "regress", "testing"}, dataProvider = "testsData")
    public void test1(String test, int value) {
        System.out.println("test 1 " + test + " " + value);
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Подключение зависимостей, чтобы после только после одного теста выполнился другой
    @Test(groups = {"regress", "dependencies"})
    public void test11() {
        System.out.println("test11");
    }

    @Test(groups = {"regress", "dependencies"},
    dependsOnMethods = {"test11"},//зависимость от теста test11(пока не выполнится test11, не выполнится и данный тест)
    alwaysRun = true) //в любом случае выполнить тест
    public void test111() {
        System.out.println("test111");
    }
}
