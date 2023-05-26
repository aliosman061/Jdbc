import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JunitTest01 {

   @Test
  public void test01(){
     assertEquals(1,1);//Bu methodun parantez içindeki paramtereleri eşitse PASS olur değilse FAIL olur
     assertTrue("hello".contains("e"));//Bu methodun parantez içi 'true' ise PASS olur değilse FAIL olur
   }

}
