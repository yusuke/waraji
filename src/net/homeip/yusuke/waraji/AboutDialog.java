package net.homeip.yusuke.waraji;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * <p>Title: Samurai</p>
 * <p>Description: a thread dump analyzing tool</p>
 * <p>Copyright: Copyright (c) 2003,2004</p>
 * <p> </p>
 * @author Yusuke Yamamoto
 * @version 1.0
 */

public class AboutDialog extends JDialog implements ActionListener {

  public JButton button1 = new JButton();
  JLabel imageLabel = new JLabel();
  public JLabel versionLabel = new JLabel();
  public JLabel copyrightLabel = new JLabel();
  ImageIcon image1 = new ImageIcon(MainFrame.class.getResource("waraji.png"));
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JScrollPane jScrollPane1 = new JScrollPane();
  public JTextArea releaseNote = new JTextArea();
  public AboutDialog(Frame parent) {
    super(parent);
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //Component initialization
  private void jbInit() throws Exception {
    imageLabel.setMaximumSize(new Dimension(64, 64));
    imageLabel.setMinimumSize(new Dimension(64, 64));
    imageLabel.setPreferredSize(new Dimension(64, 64));
    imageLabel.setIcon(image1);
    this.setModal(true);
    this.setTitle("*AboutDialog.title*");
    this.getContentPane().setLayout(gridBagLayout1);
    versionLabel.setRequestFocusEnabled(true);
    versionLabel.setText("*AboutDialog.version*");
    copyrightLabel.setText("*AboutDialog.copyright*");
    button1.setSelected(true);
    button1.setText("Ok");
    button1.addActionListener(this);
    releaseNote.setEditable(false);
    releaseNote.setText("*AboutDialog.releaseNote*");
    releaseNote.select(0, 0);
    releaseNote.setLineWrap(true);
    jScrollPane1.setMinimumSize(new Dimension(400, 500));
    jScrollPane1.setPreferredSize(new Dimension(390, 200));
    this.getContentPane().add(imageLabel,
                              new GridBagConstraints(0, 0, 1, 3, 0.0, 0.0
      , GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
      new Insets(10, 10, 10, 0), 0, 0));
    this.getContentPane().add(versionLabel,
                              new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
      , GridBagConstraints.WEST, GridBagConstraints.NONE,
      new Insets(10, 10, 0, 10), 0, 0));
    this.getContentPane().add(copyrightLabel,
                              new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
      , GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
      new Insets(5, 10, 0, 10), 0, 0));
    this.getContentPane().add(button1,
                              new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0
      , GridBagConstraints.EAST, GridBagConstraints.NONE,
      new Insets(5, 0, 10, 5), 0, 0));
    this.getContentPane().add(jScrollPane1,
                              new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0
      , GridBagConstraints.CENTER, GridBagConstraints.BOTH,
      new Insets(5, 5, 5, 5), 0, 0));
    jScrollPane1.getViewport().add(releaseNote, null);
    setResizable(false);
  }

  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e) {
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      cancel();
    }
    super.processWindowEvent(e);
  }

  //Close the dialog
  void cancel() {
    dispose();
  }

  //Close the dialog on a button event
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button1) {
      cancel();
    }
  }
}
