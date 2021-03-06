package net.homeip.yusuke.waraji;

import java.util.Enumeration;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import javax.swing.tree.DefaultMutableTreeNode;
import net.homeip.yusuke.common.I18nizedResources;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Title: Samurai</p>
 * <p>Description: a thread dump analyzing tool</p>
 * <p>Copyright: Copyright (c) 2003,2004</p>
 * <p> </p>
 * @author Yusuke Yamamoto
 * @version 1.0
 */

public class JarResolver extends DefaultMutableTreeNode {
  I18nizedResources resources = I18nizedResources.getInstance();
  Map childs = new HashMap();
  ZipEntry zipEntry;
  FileLocations locations;

  File file;
  static Map files = new HashMap();
  static List duplicates = new LinkedList();
  public JarResolver() {
    super("root node");
    this.zipEntry = null;
  }
  private JarResolver(File file) throws ZipException, IOException {
    super(file.getName());
    this.file = file;
    this.zipEntry = null;
    this.locations = null;
    if (!file.exists() || file.isDirectory()) {
      return;
    }
    ZipFile zipFile = new ZipFile(file);
    Enumeration e = zipFile.entries();
    while (e.hasMoreElements()) {
      ZipEntry entry = (ZipEntry) e.nextElement();
      FileLocations locations = null;
      if(!entry.isDirectory()){
        locations = (FileLocations)files.get(entry.toString());
        if(null == locations){
          files.put(entry.toString(),locations = new FileLocations(entry.toString(),file,entry));
        }else{
          locations.addFile(file,entry);
          if (!entry.toString().startsWith("META-INF/")) {
            duplicates.add(locations);
          }
        }
      }
      String name = entry.getName();
      if (!entry.toString().startsWith("META-INF/")) {
        add(entry, locations, name);
      }else{
        add(entry,null, name);
      }
    }
    zipFile.close();
  }

  private JarResolver(ZipEntry zipEntry,FileLocations locations,String dir, String afterDir) {
    super(dir);
    this.file = null;
    add(zipEntry,locations,afterDir);
    if(this.isLeaf()){
      this.zipEntry = zipEntry;
      this.locations = locations;
    }else{
      this.zipEntry = null;
      this.locations = null;
    }
  }
  private JarResolver(ZipEntry zipEntry,FileLocations locations,String name) {
    super(name);

    this.file = null;
    if(this.isLeaf()){
      this.zipEntry = zipEntry;
      this.locations = locations;
    }else{
    this.zipEntry = null;
    this.locations = null;
    }
  }

  public void add(File file) {
    boolean alreadyExists = false;
    for (int i = 0; i < getChildCount(); i++) {
      JarResolver resolver = (JarResolver)getChildAt(i);
      if(resolver.file.equals(file)){
        alreadyExists = true;
        break;
      }
    }
    if(!alreadyExists){
      try {
        add(new JarResolver(file));
      } catch (IOException ex) {
        add(new DefaultMutableTreeNode(file.getName()));
      }
    }
  }

  public static FileLocations[] getDuplicatesArray(){
    return (FileLocations[]) duplicates.toArray(new FileLocations[0]);
  }



  boolean isDuplicated(){
    boolean isDuplicated = false;
    if(null != locations){
      isDuplicated =  locations.getEntries().length >1;
    }else{
      if(!isLeaf()){
        for (int i = 0; i < getChildCount(); i++) {
//          if(!"class net.homeip.yusuke.waraji.JarResolver".equals(getChildAt(i).getClass().toString())){
//            System.out.println(getChildAt(i).getClass());
//          }
          if(((JarResolver)getChildAt(i)).isDuplicated()){
            isDuplicated = true;
            break;
          }
        }
      }
    }
    return isDuplicated;
  }

  private void add(ZipEntry zipEntry,FileLocations locations,String name) {
    int dirIndex;

    if ( -1 != (dirIndex = name.indexOf("/"))) {
      String dir = name.substring(0, dirIndex);
      String afterDir = name.substring(dirIndex + 1);
      JarResolver resolver = (JarResolver) childs.get(dir);
      if (null == resolver) {
        if ("".equals(afterDir)) {
          //add directory
          resolver = new JarResolver(zipEntry,locations,dir);
        } else {
          //add nesting directory
          resolver = new JarResolver(zipEntry,locations,dir, afterDir);
        }
        add(resolver);
        childs.put(dir, resolver);
      } else {
        if (!"".equals(afterDir)) {
          resolver.add(zipEntry,locations,afterDir);
        }
      }
    } else {
      JarResolver resolver = new JarResolver(zipEntry,locations,name);
      add(resolver);
      childs.put(name, resolver);
    }
  }
  public String getMessage(){
    FileLocations[] locations = getDuplicatesArray();
    if (0 != locations.length) {
      SimpleDateFormat format = new SimpleDateFormat(resources.getMessage("dateFormat"));
      StringBuffer result = new StringBuffer(resources.getMessage("duplicated"));
      for (int i = 0; i < locations.length; i++) {
        result.append(locations[i].getPath()).append(":\n");
        File[] files = locations[i].getFiles();
        ZipEntry[] entries = locations[i].getEntries();
        for (int j = 0; j < files.length; j++) {
          if (0 == j) {
            result.append(" in ");
          } else {
            result.append("\n    ");
          }
          result.append(files[j].getName())
            .append("(").append(entries[j].getSize()).append("bytes,")
            .append(format.format(new Date(entries[j].getTime()))).append(")");
        }
        result.append("\n");

      }
      return result.toString();
    }else{
      if(this.getChildCount() > 1){
        return resources.getMessage("notDetected");
      }else{
        return resources.getMessage("result");
      }
    }
  }
}
