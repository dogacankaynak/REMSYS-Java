import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
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

public class testgui {

    public static void main(String[] args) {
        new testgui();
    }

    public testgui() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JPanel panel = new JPanel(new BorderLayout());

               
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
                panel.add(listScroller);

                JFrame frame = new JFrame("Testing");
                frame.setSize(500, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(panel);
        
                
                frame.setVisible(true);
            }
        });
    }

}