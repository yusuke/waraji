package net.homeip.yusuke.common;

import javax.swing.JFrame;
import javax.swing.UIManager;
/**
 * <p>Title: Samurai</p>
 * <p>Description: a thread dump analyzing tool</p>
 * <p>Copyright: Copyright (c) 2003,2004</p>
 * <p> </p>
 * @author Yusuke Yamamoto
 * @version 1.0
 */

public class GUILauncher {
  public static void launch(String className){
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      JFrame frame = (JFrame) Class.forName(className).newInstance();
      frame.validate();
      frame.setVisible(true);
    }
    catch(Exception e) {
      e.printStackTrace();
    }

  }
}