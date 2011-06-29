package net.homeip.yusuke.waraji;
import java.util.zip.ZipEntry;
import java.util.List;
import java.io.File;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
/**
 * <p>Title: Samurai</p>
 * <p>Description: a thread dump analyzing tool</p>
 * <p>Copyright: Copyright (c) 2003,2004</p>
 * <p> </p>
 * @author Yusuke Yamamoto
 * @version 1.0
 */

public class ZipEntries {
  private List list = new LinkedList();
  private Map map = new HashMap();
  public ZipEntries() {
  }

  public void add(ZipEntry entry,File owner){
    String name = entry.toString();
    if(null != map.get(name)){

    }
  }

}