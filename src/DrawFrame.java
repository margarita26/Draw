import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Class represents the frame with two panels: one to draw on and one to change color/erase.
 */
public class DrawFrame extends JFrame implements ActionListener,IDraw {

  private JButton restart;
  private JButton choose;
  private JTextField colors;
  private DrawPanel panel;
  private JPanel buttonpanel;

  protected DrawFrame() {

    this.setLayout(new BorderLayout());
    this.setTitle("Draw Panel");
    this.setSize(600, 600);

    panel = new DrawPanel();
    this.add(panel);
    setButtonPanel();
    JScrollPane scrolling = new JScrollPane(panel);
    this.setPreferredSize(new Dimension(10, 40));
    this.add(scrolling, BorderLayout.CENTER);

    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

  }

  /**
   * Create a button panel with the tools.
   */
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

    //button to chose color of the drawing
    choose = new JButton("Choose Color:");
    choose.addActionListener((ActionEvent e) -> {
              panel.setColor(colors.getText());
              colors.setText("");
            }
    );
    buttonpanel.add(choose, left);

    //field to chose color
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
