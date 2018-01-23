import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.*;

public class DrawFrame extends JFrame implements ActionListener,IDraw {

  private JButton restart;
  private JButton choose;
  private JList colors;
  private DrawPanel panel;
  private JPanel buttonpanel;
  private Color current;

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

    buttonpanel = new JPanel();
    buttonpanel.setBorder(BorderFactory.createTitledBorder("Tools"));
    buttonpanel.setLayout(new BoxLayout(buttonpanel,BoxLayout.PAGE_AXIS));
    buttonpanel.add(Box.createRigidArea(new Dimension(5,5)));
    this.add(buttonpanel, BorderLayout.WEST);

    restart = new JButton("Erase");
    restart.addActionListener((ActionEvent e) -> {
      panel.restart();
    });
    buttonpanel.add(restart);
    restart.setAlignmentX(Component.CENTER_ALIGNMENT);

    choose = new JButton("Choose Color:");
    choose.addActionListener((ActionEvent e) -> {
              panel.setColor((String)colors.getSelectedValue());
            }
    );
    buttonpanel.add(choose);
    choose.setAlignmentX(Component.CENTER_ALIGNMENT);


    String[] c = {"Yellow", "Blue", "Black", "Gray", "Orange", "Purple"};
    colors = new JList(c);
    colors.setFixedCellWidth(colors.getFixedCellWidth() + 50);

    JScrollPane listScroller = new JScrollPane(colors);
    listScroller.setPreferredSize(new Dimension(80, 80));
    colors.setLayoutOrientation(JList.VERTICAL);
    buttonpanel.add(colors);
    colors.setAlignmentX(Component.CENTER_ALIGNMENT);

  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }

  public void go() {
    this.setVisible(true);
  }
}
