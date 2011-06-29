package net.homeip.yusuke.common;
/**
 * an interface that indicate a object which needs to be notified the application's configuration is changed
 * <p>Title: Samurai</p>
 * <p>Description: a thread dump analyzing tool</p>
 * <p>Copyright: Copyright (c) 2003,2004</p>
 * <p> </p>
 * @author Yusuke Yamamoto
 * @version 1.0
 */

public interface ConfigurationListener {
  void onConfigurationChanged(Configuration config);
}