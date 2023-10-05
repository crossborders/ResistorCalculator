import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Window.Type;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Frame;

import javax.print.DocFlavor.STRING;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.CardLayout;
import java.awt.Canvas;
import java.awt.Label;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BandCombineOp;
import java.security.PublicKey;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.SwingConstants;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Test extends JFrame {
	
	double renkband1 , renkband2 , carpan , tolerans , sonuc ; 
	private JPanel contentPane;
	private JTextField txtband1;
	private JTextField txtband2;
	private JTextField txttolerans;
	private JTextField txtcarpan;
    private JTextField txtsonuc;
    static Color mybrown = new Color(102, 51 , 0);
    static Color mySilverColor = new Color(192 , 192 , 192);
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	static int []colorset = new int[10];
    
	
	/**
	 * Create the frame.
	 */
	public Test() {
		setType(Type.UTILITY);
		setTitle("Resistör Deger Hesaplama - byMustafaTEKER");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel degerpanel = new JPanel();
		degerpanel.setBounds(10, 10, 258, 443);
		contentPane.add(degerpanel);
		degerpanel.setLayout(null);
		
		String []renkbandları = {"Siyah - 0", "Kahverengi - 1 ", "Kırmızı - 2", "Turuncu - 3", "Sarı - 4", "Yeşil - 5", "Mavi - 6", "Mor - 7", "Gri - 8", "Beyaz - 9"};
		
		
		
	    JComboBox band1 = new JComboBox();
	    band1.setModel(new DefaultComboBoxModel(new String[] {"Siyah - 0", "Kahverengi - 1 ", "Kırmızı - 2", "Turuncu - 3", "Sarı - 4", "Yeşil - 5", "Mavi - 6", "Mor - 7", "Gri - 8", "Beyaz - 9"}));
		
		band1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		band1.setEditable(true);
		band1.setToolTipText("");
		band1.setBounds(24, 84, 213, 38);
		band1.setActionCommand(getName());
		
		
        
		
		
		
		degerpanel.add(band1);
		txtband1 = new JTextField();
		txtband1.setEditable(false);
		txtband1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtband1.setText("1. Renk Bandı");
		txtband1.setBounds(24, 52, 213, 22);
		degerpanel.add(txtband1);
		txtband1.setColumns(10);
		
		JComboBox band2 = new JComboBox();
		band2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		band2.setModel(new DefaultComboBoxModel(new String[] {"Siyah - 0", "Kahverengi - 1 ", "Kırmızı - 2", "Turuncu - 3", "Sarı - 4", "Yeşil - 5", "Mavi - 6", "Mor - 7", "Gri - 8", "Beyaz - 9"}));
		band2.setEditable(true);
		band2.setBounds(24, 177, 213, 38);
		degerpanel.add(band2);
		
		txtband2 = new JTextField();
		txtband2.setEditable(false);
		txtband2.setText("2. Renk Bandı");
		txtband2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtband2.setColumns(10);
		txtband2.setBounds(24, 148, 213, 22);
		degerpanel.add(txtband2);
		
		JComboBox tolband = new JComboBox();
		tolband.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tolband.setModel(new DefaultComboBoxModel(new String[] {"Altın - 5%", "Gümüş - 10%", "Boş - 20%"}));
		tolband.setEditable(true);
		tolband.setBounds(24, 357, 213, 38);
		degerpanel.add(tolband);
		
		txttolerans = new JTextField();
		txttolerans.setText("Tolerans");
		txttolerans.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txttolerans.setEditable(false);
		txttolerans.setColumns(10);
		txttolerans.setBounds(24, 325, 213, 22);
		degerpanel.add(txttolerans);
		
		JComboBox carpband = new JComboBox();
		carpband.setFont(new Font("Tahoma", Font.PLAIN, 15));
		carpband.setModel(new DefaultComboBoxModel(new String[] {"Siyah - 0", "Kahverengi - 1 ", "Kırmızı - 2", "Turuncu - 3", "Sarı - 4", "Yeşil - 5", "Mavi - 6", "Mor - 7", "Gri - 8", "Beyaz - 9"}));
		carpband.setEditable(true);
		carpband.setBounds(24, 267, 213, 38);
		degerpanel.add(carpband);
		
		txtcarpan = new JTextField();
		txtcarpan.setEditable(false);
		txtcarpan.setText("Çarpan");
		txtcarpan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtcarpan.setColumns(10);
		txtcarpan.setBounds(24, 238, 213, 22);
		degerpanel.add(txtcarpan);
		
		JPanel sonucpanel = new JPanel();
		sonucpanel.setBackground(Color.WHITE);
		sonucpanel.setBounds(278, 10, 464, 443);
		contentPane.add(sonucpanel);
		sonucpanel.setLayout(null);
		
		JPanel pnlcolor1 = new JPanel();
		pnlcolor1.setOpaque(true);
		pnlcolor1.setBounds(97, 67, 20, 89);
		sonucpanel.add(pnlcolor1);
		
		JPanel pnlcolortol = new JPanel();
		pnlcolortol.setBounds(348, 66, 20, 89);
		sonucpanel.add(pnlcolortol);
		
		JPanel pnlcolor2 = new JPanel();
		pnlcolor2.setBounds(190, 72, 20, 75);
		sonucpanel.add(pnlcolor2);
		
		JPanel pnlcolorcarpan = new JPanel();
		pnlcolorcarpan.setBounds(261, 72, 20, 75);
		sonucpanel.add(pnlcolorcarpan);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Test.class.getResource("/images/resistör.jpg")));
		lblNewLabel.setBounds(71, 60, 340, 102);
		sonucpanel.add(lblNewLabel);
		
		txtsonuc = new JTextField();
		txtsonuc.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtsonuc.setEditable(false);
		txtsonuc.setHorizontalAlignment(SwingConstants.CENTER);
		txtsonuc.setBounds(70, 261, 340, 57);
		sonucpanel.add(txtsonuc);
		txtsonuc.setColumns(10);
		
		JButton btnHESAPLA = new JButton("HESAPLA");
		
		btnHESAPLA.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHESAPLA.setBounds(69, 336, 342, 57);
		sonucpanel.add(btnHESAPLA);
		
		//band1 set color
		band1.addPopupMenuListener(new PopupMenuListener() {
	    	public void popupMenuCanceled(PopupMenuEvent e) {
	    	}
	    	public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
	    		String x = String.valueOf(band1.getSelectedItem());
	    		if(x == "Siyah - 0") {
	    			pnlcolor1.setBackground(Color.black);
	    		}
	    		else if(x == "Kahverengi - 1 ") {
		    		pnlcolor1.setBackground(mybrown);
	    		}
	    	    else if (x == "Kırmızı - 2") {
	    	    	pnlcolor1.setBackground(Color.red);   
					
				}
	    	    else if (x == "Turuncu - 3") {
	    	    	pnlcolor1.setBackground(Color.orange);
					
				}
	    	    else if (x == "Sarı - 4") {
	    	    	pnlcolor1.setBackground(Color.yellow);
					
				}
	    	    else if (x == "Yeşil - 5") {
	    	    	pnlcolor1.setBackground(Color.green);
					
				}
	    	    else if (x == "Mavi - 6") {
	    	    	pnlcolor1.setBackground(Color.blue);
					
				}
	    	    else if (x == "Mor - 7") {
	    	    	pnlcolor1.setBackground(Color.magenta);
					
				}
	    	    else if (x == "Gri - 8") {
	    	    	pnlcolor1.setBackground(Color.lightGray);
					
				}
	    	    else {
					pnlcolor1.setBackground(Color.WHITE);
				}
	    	}
	    	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
	    	}
	    });
		
		//band2 set color
		band2.addPopupMenuListener(new PopupMenuListener() {
	    	public void popupMenuCanceled(PopupMenuEvent e) {
	    	}
	    	public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
	    		String x = String.valueOf(band2.getSelectedItem());
	    		if(x == "Siyah - 0") {
	    			pnlcolor2.setBackground(Color.black);
	    		}
	    		else if(x == "Kahverengi - 1 ") {
		    		pnlcolor2.setBackground(mybrown);
	    		}
	    	    else if (x == "Kırmızı - 2") {
	    	    	pnlcolor2.setBackground(Color.red);   //"Sarı - 4", "Yeşil - 5", "Mavi - 6", "Mor - 7", "Gri - 8", "Beyaz - 9"
					
				}
	    	    else if (x == "Turuncu - 3") {
	    	    	pnlcolor2.setBackground(Color.orange);
					
				}
	    	    else if (x == "Sarı - 4") {
	    	    	pnlcolor2.setBackground(Color.yellow);
					
				}
	    	    else if (x == "Yeşil - 5") {
	    	    	pnlcolor2.setBackground(Color.green);
					
				}
	    	    else if (x == "Mavi - 6") {
	    	    	pnlcolor2.setBackground(Color.blue);
					
				}
	    	    else if (x == "Mor - 7") {
	    	    	pnlcolor2.setBackground(Color.magenta);
					
				}
	    	    else if (x == "Gri - 8") {
	    	    	pnlcolor2.setBackground(Color.lightGray);
					
				}
	    	    else {
					pnlcolor2.setBackground(Color.WHITE);
				}
	    	}
	    	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
	    	}
	    });
		
		carpband.addPopupMenuListener(new PopupMenuListener() {
	    	public void popupMenuCanceled(PopupMenuEvent e) {
	    	}
	    	public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
	    		String x = String.valueOf(carpband.getSelectedItem());
	    		if(x == "Siyah - 0") {
	    			pnlcolorcarpan.setBackground(Color.black);
	    		}
	    		else if(x == "Kahverengi - 1 ") {
		    		pnlcolorcarpan.setBackground(mybrown);
	    		}
	    	    else if (x == "Kırmızı - 2") {
	    	    	pnlcolorcarpan.setBackground(Color.red);   
					
				}
	    	    else if (x == "Turuncu - 3") {
	    	    	pnlcolorcarpan.setBackground(Color.orange);
					
				}
	    	    else if (x == "Sarı - 4") {
	    	    	pnlcolorcarpan.setBackground(Color.yellow);
					
				}
	    	    else if (x == "Yeşil - 5") {
	    	    	pnlcolorcarpan.setBackground(Color.green);
					
				}
	    	    else if (x == "Mavi - 6") {
	    	    	pnlcolorcarpan.setBackground(Color.blue);
					
				}
	    	    else if (x == "Mor - 7") {
	    	    	pnlcolorcarpan.setBackground(Color.magenta);
					
				}
	    	    else if (x == "Gri - 8") {
	    	    	pnlcolorcarpan.setBackground(Color.lightGray);
					
				}
	    	    else {
					pnlcolorcarpan.setBackground(Color.WHITE);
				}
	    	}
	    	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
	    	}
	    });

		
		tolband.addPopupMenuListener(new PopupMenuListener() {
	    	public void popupMenuCanceled(PopupMenuEvent e) {
	    	}
	    	public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
	    		String x = String.valueOf(tolband.getSelectedItem());
	    		if(x == "Altın - 5%") {
	    			pnlcolortol.setBackground(Color.yellow);
	    		}
	    		else if(x == "Gümüş - 10%") {
		    		pnlcolortol.setBackground(mySilverColor);
	    		}
	    	    
	    	    else {
					pnlcolortol.setBackground(Color.white);
				}
	    	}
	    	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
	    	}
	    });
		
		band1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		if(band1.getSelectedItem() == "Siyah - 0") {
	    			renkband1 = 0 ;
	    		}
	    		else if(band1.getSelectedItem() == "Kahverengi - 1 ") {
		    		renkband1 = 1 ;
	    		}
	    	    else if (band1.getSelectedItem() == "Kırmızı - 2") {
	    	    	renkband1 = 2;   
					
				}
	    	    else if (band1.getSelectedItem() == "Turuncu - 3") {
	    	    	renkband1 = 3;
					
				}
	    	    else if (band1.getSelectedItem() == "Sarı - 4") {
	    	    	renkband1 = 4;
					
				}
	    	    else if (band1.getSelectedItem() == "Yeşil - 5") {
	    	    	renkband1 = 5;
					
				}
	    	    else if (band1.getSelectedItem() == "Mavi - 6") {
	    	    	renkband1 = 6;
					
				}
	    	    else if (band1.getSelectedItem() == "Mor - 7") {
	    	    	renkband1 = 7;
					
				}
	    	    else if (band1.getSelectedItem() == "Gri - 8") {
	    	    	renkband1 = 8;
					
				}
	    	    else {
					renkband1 = 9;
				}
	    		
	    	}
	    });
		
		band2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(band2.getSelectedItem() == "Siyah - 0") {
	    			renkband2 = 0 ;
	    		}
	    		else if(band2.getSelectedItem() == "Kahverengi - 1 ") {
		    		renkband2 = 1 ;
	    		}
	    	    else if (band2.getSelectedItem() == "Kırmızı - 2") {
	    	    	renkband2 = 2;   
					
				}
	    	    else if (band2.getSelectedItem() == "Turuncu - 3") {
	    	    	renkband2 = 3;
					
				}
	    	    else if (band2.getSelectedItem() == "Sarı - 4") {
	    	    	renkband2 = 4;
					
				}
	    	    else if (band2.getSelectedItem() == "Yeşil - 5") {
	    	    	renkband2 = 5;
					
				}
	    	    else if (band2.getSelectedItem() == "Mavi - 6") {
	    	    	renkband2 = 6;
					
				}
	    	    else if (band2.getSelectedItem() == "Mor - 7") {
	    	    	renkband2 = 7;
					
				}
	    	    else if (band2.getSelectedItem() == "Gri - 8") {
	    	    	renkband2 = 8;
					
				}
	    	    else {
					renkband2 = 9;
				}
				
				
			}
		} );
		
		carpband.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(carpband.getSelectedItem() == "Siyah - 0") {
	    			carpan = 0 ;
	    		}
	    		else if(carpband.getSelectedItem() == "Kahverengi - 1 ") {
	    			carpan = 1 ;
	    		}
	    	    else if (carpband.getSelectedItem() == "Kırmızı - 2") {
	    	    	carpan = 2;   
					
				}
	    	    else if (carpband.getSelectedItem() == "Turuncu - 3") {
	    	    	carpan = 3;
					
				}
	    	    else if (carpband.getSelectedItem() == "Sarı - 4") {
	    	    	carpan = 4;
					
				}
	    	    else if (carpband.getSelectedItem() == "Yeşil - 5") {
	    	    	carpan = 5;
					
				}
	    	    else if (carpband.getSelectedItem() == "Mavi - 6") {
	    	    	carpan = 6;
					
				}
	    	    else if (carpband.getSelectedItem() == "Mor - 7") {
	    	    	carpan = 7;
					
				}
	    	    else if (carpband.getSelectedItem() == "Gri - 8") {
	    	    	carpan = 8;
					
				}
	    	    else {
	    	    	carpan = 9;
				}
				
			}
		});
		
		tolband.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(tolband.getSelectedItem() == "Altın - 5%") {
					tolerans = 5;
				}
				else if (tolband.getSelectedItem() == "Gümüş - 10%") {
					tolerans = 10;
				}
				else {
					tolerans = 20;
				}
				
			}
		});
		
		
		btnHESAPLA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sonuc = ((renkband1 * 10) + (renkband2))* Math.pow(10, carpan) ;
				txtsonuc.setText( sonuc + "%" + tolerans + "Ω");
			}
		});
		
	
	}

	
}
