import org.testng.annotations.Test;

/**
 * Created by Admin on 17.10.2015.
 */
public class Test2 {
    @Test(groups = {"a", "mega"})
    public void T1(){
        String mname = "Meth3";
        System.out.println(mname);
    }
    @Test
    public void T2(){
        String mname = "Meth4";
        System.out.println(mname);
    }
}
