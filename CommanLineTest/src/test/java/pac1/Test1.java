package pac1;

import org.testng.annotations.Test;

/**
 * Created by Admin on 17.10.2015.
 */
public class Test1 {
    @Test(groups = {"a"})
    public void T1(){
        String mname = "Meth1";
        System.out.println(mname);
    }
    @Test(groups = {"a", "mega"})
    public void T2(){
        String mname = "Meth2";
        System.out.println(mname);
    }
}
