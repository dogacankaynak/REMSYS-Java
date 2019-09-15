import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

public class remove {
	JFrame frame = new JFrame("Testing");
	private JTextField textField;
    public static void main(String[] args) {
        new remove();
    }

    /**
     * @wbp.parser.entryPoint
     */
    public remove() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JPanel panel = new JPanel();

               
                DefaultListModel model = new DefaultListModel();
                JList listArea = new JList(model);
                try {
					for (int i = 0; i < FileHandler.randomEstate().size(); i++) {
					    try {
							model.add(i, FileHandler.randomEstate().get(i).toString());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					  }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                listArea.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                listArea.setFont(new Font("Serif", Font.ITALIC, 14));
                JScrollPane listScroller = new JScrollPane();
                listScroller.setViewportView(listArea);
                
                listArea.setLayoutOrientation(JList.VERTICAL);

                
                frame.setSize(555, 560);
                frame.getContentPane().add(panel);
                GroupLayout gl_panel = new GroupLayout(panel);
                gl_panel.setHorizontalGroup(
                	gl_panel.createParallelGroup(Alignment.LEADING)
                		.addComponent(listScroller, GroupLayout.PREFERRED_SIZE, 539, GroupLayout.PREFERRED_SIZE)
                );
                gl_panel.setVerticalGroup(
                	gl_panel.createParallelGroup(Alignment.LEADING)
                		.addComponent(listScroller, GroupLayout.PREFERRED_SIZE, 522, GroupLayout.PREFERRED_SIZE)
                );
                
                textField = new JTextField();
                listScroller.setColumnHeaderView(textField);
                textField.setColumns(10);
                panel.setLayout(gl_panel);
                frame.setVisible(true);
            }
        });
    }

}