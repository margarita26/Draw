import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class DrawFrame extends JFrame implements ActionListener,IDraw {

  private JButton restart;
  private JButton choose;
  private JTextField colors;
  private DrawPanel panel;
  private Color currentColor;

  public DrawFrame() {

    this.setLayout(new BorderLayout());
    this.setTitle("Draw Panel");
    this.setSize(700, 700);

    panel = new DrawPanel();
    this.add(panel);
    currentColor = Color.BLACK;

    JPanel buttonpanel = new JPanel();

    this.add(buttonpanel);
    restart = new JButton("Erase");
    buttonpanel.add(restart);
    choose = new JButton("Choose Color:");
    buttonpanel.add(choose);
    colors = new JTextField(6);
    buttonpanel.add(colors);




    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }
  @Override
  public void actionPerformed(ActionEvent e) {

  }

  public void go() {
    this.setVisible(true);
  }
}
