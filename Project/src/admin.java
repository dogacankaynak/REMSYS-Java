

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

public class admin {
	String keyword;
	JFrame frame;
	private JTextField txtKeyword;
	String id;
	ArrayList<RealEstate> searchResult = new ArrayList<RealEstate>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin window = new admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public admin() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 647, 567);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblAdress = new JLabel("Adress");
		
		txtKeyword = new JTextField();
		txtKeyword.setText("keyword");
		txtKeyword.setColumns(10);
		
		JButton btnRemove = new JButton("Remove");
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(80, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblAdress, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtKeyword, GroupLayout.PREFERRED_SIZE, 477, GroupLayout.PREFERRED_SIZE))
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 539, GroupLayout.PREFERRED_SIZE))
							.addGap(68))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(217))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtKeyword, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAdress))
					.addGap(57)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnRemove)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.EAST);
		frame.getContentPane().setLayout(groupLayout);
		
		
		


         
		DefaultListModel model = new DefaultListModel();
		
		
		
		
		txtKeyword.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				txtKeyword.setText("");

			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				txtKeyword.setText("");
			}
		});
		txtKeyword.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	keyword = txtKeyword.getText();
		    	try {
					searchResult = FileHandler.searchByKeyWord(keyword.toLowerCase());
					for (int i = 0; i < searchResult.size(); i++) {
						
					    model.add(i, searchResult.get(i).toString());

					  }
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

		    	
	        }
	    
	});
		
		btnRemove.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) 
		    {
		    		
		     	try {
					FileHandler.removeEstateFromArray(id);

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
	        }
	    
	});	
		
        
        JList listArea = new JList(model);
        
        listArea.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listArea.setFont(new Font("Serif", Font.ITALIC, 14));
        
        scrollPane.setViewportView(listArea);
        listArea.setLayoutOrientation(JList.VERTICAL);
        panel.add(scrollPane);

    JFrame frame = new JFrame("AdminPage");
        frame.setSize(500, 500);
        frame.getContentPane().add(panel);
		
		
		listArea.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList listArea = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		        
		            // Double-click detected
		            int index = listArea.locationToIndex(evt.getPoint());
		            id = searchResult.get(index).getId();
		        } else if (evt.getClickCount() == 3) {

		            // Triple-click detected
		            int index = listArea.locationToIndex(evt.getPoint());
		            id = searchResult.get(index).getId();
		        }
		    }
		});
		
		
		
		
	}
}
