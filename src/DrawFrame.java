import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.*;

public class DrawFrame extends JFrame implements ActionListener,IDraw {

  private JButton restart;
  private JButton choose;
  private JTextField colors;
  private DrawPanel panel;
  private JPanel buttonpanel;

  protected DrawFrame() {

    this.setLayout(new BorderLayout());
    this.setTitle("Draw Panel");
    this.setSize(700, 700);

    panel = new DrawPanel();
    this.add(panel);
    setButtonPanel();

    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    pack();
  }

  private void setButtonPanel() {
    //make a panel
    buttonpanel = new JPanel();
    buttonpanel.setBorder(BorderFactory.createTitledBorder("Tools"));
    //set layout
    buttonpanel.setLayout(new GridBagLayout());
    GridBagConstraints left = new GridBagConstraints();
    left.anchor = GridBagConstraints.EAST;
    GridBagConstraints right = new GridBagConstraints();
    right.weightx = 2.0;
    right.fill = GridBagConstraints.HORIZONTAL;
    right.gridwidth = GridBagConstraints.REMAINDER;
    //add button panel to the frame
    this.add(buttonpanel, BorderLayout.NORTH);

    //button to erase the board
    restart = new JButton("Erase");
    restart.addActionListener((ActionEvent e) -> {
      panel.restart();
    });
    buttonpanel.add(restart);
    //restart.setAlignmentX(Component.CENTER_ALIGNMENT);
    //button to chose color of the drawing
    choose = new JButton("Choose Color:");
    choose.addActionListener((ActionEvent e) -> {
              panel.setColor(colors.getText());
              colors.setText("");
            }
    );
    buttonpanel.add(choose, left);
    //choose.setAlignmentX(Component.CENTER_ALIGNMENT);

    colors = new JTextField(5);
    buttonpanel.add(colors, right);


  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }

  public void go() {
    this.setVisible(true);
  }
}
