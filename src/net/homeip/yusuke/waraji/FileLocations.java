package net.homeip.yusuke.waraji;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
/**
 * <p>Title: Samurai</p>
 * <p>Description: a thread dump analyzing tool</p>
 * <p>Copyright: Copyright (c) 2003,2004</p>
 * <p> </p>
 * @author Yusuke Yamamoto
 * @version 1.0
 */

public class FileLocations{
  private String path;
  private List files;
  private List zipEntries;
  /*package*/ FileLocations(String path,File file,ZipEntry entry){
    this.path = path;
    this.files = new ArrayList();
    this.zipEntries = new ArrayList();
    addFile(file,entry);
  }
  public void addFile(File file,ZipEntry entry){
    this.files.add(file);
    this.zipEntries.add(entry);
  }
  public String getPath(){
   return path;
  }
  public File[] getFiles(){
    return (File[])files.toArray(new File[0]);
  }
  public ZipEntry[] getEntries(){
    return (ZipEntry[])zipEntries.toArray(new ZipEntry[0]);
  }
}
