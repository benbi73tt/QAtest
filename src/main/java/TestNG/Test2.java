package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 {

    @Test(groups = {"smokeTest","testRetry"}, retryAnalyzer = Retry.class)
    public void test2(){
        System.out.println("test2");
        Assert.fail();
    }


    @Test(groups = {"smokeTest", "regress"})
    public void test22(){
        System.out.println("test22");
    }

    @Test(groups = {"regress"})
    public void test222(){
        System.out.println("test222");
    }
}
