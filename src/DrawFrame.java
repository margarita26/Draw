import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.*;

public class DrawFrame extends JFrame implements ActionListener,IDraw {

  private JButton restart;
  private JButton choose;
  private JTextField colorsBox;
  private DrawPanel panel;
  private JPanel buttonpanel;
  private Color current;

  public DrawFrame() {

    this.setLayout(new BorderLayout());
    this.setTitle("Draw Panel");
    this.setSize(700, 700);

    panel = new DrawPanel();
    this.add(panel);

    buttonpanel = new JPanel();
    buttonpanel.setPreferredSize(new Dimension(30,70));
    buttonpanel.setBorder(BorderFactory.createTitledBorder("Tools"));
    this.add(buttonpanel, BorderLayout.NORTH);

    restart = new JButton("Erase");
    buttonpanel.add(restart);
    choose = new JButton("Choose Color:");
    buttonpanel.add(choose);
    colorsBox = new JTextField(6);
    buttonpanel.add(colorsBox);

    //extract color that you want to paint with
    choose.addActionListener((ActionEvent e ) -> {
      if (colorsBox.getText() != null) {
        this.setColor(colorsBox.getText());
        colorsBox.setText("");
      }
      }
    );
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    pack();
  }

  /**
   * Sets current color based on the input.
   * @param s string of the color
   */
  protected void setColor(String s) {
    Color c;
    try {
      Field field = Color.class.getField(s);
      c = (Color)field.get(null);
    } catch (Exception e) {
      c = null;
    }
    this.current = c;
  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }

  public void go() {
    this.setVisible(true);
  }
}
