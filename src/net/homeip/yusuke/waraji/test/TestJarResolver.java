package net.homeip.yusuke.waraji.test;

import junit.framework.*;
import junit.textui.TestRunner;
import net.homeip.yusuke.waraji.*;
import java.io.File;
public class TestJarResolver extends TestCase {

  protected void setUp() throws Exception {
    super.setUp();
    /**@todo verify the constructors*/
//    jarResolver = new JarResolver();
  }

  protected void tearDown() throws Exception {
    super.tearDown();
  }

  public void testJarResolver() throws Exception{
    JarResolver tree = new JarResolver();
    tree.add(new File("samurai.jar"));
  }
  public static void main(String args[]){
    TestRunner.run(TestJarResolver.class);
  }

}
