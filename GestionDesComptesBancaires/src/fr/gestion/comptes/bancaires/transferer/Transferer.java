package fr.gestion.comptes.bancaires.transferer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import fr.gestion.comptes.bancaires.comptes.ListeComptesForm;
import fr.gestion.comptes.bancaires.daos.implement.CompteImplement;
import fr.gestion.comptes.bancaires.daos.implement.ComptecousImplement;
import fr.gestion.comptes.bancaires.daos.implement.CompteepaImplement;
import fr.gestion.comptes.bancaires.pojos.Compte;
import fr.gestion.comptes.bancaires.pojos.Comptecous;
import fr.gestion.comptes.bancaires.pojos.Compteepa;

import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

public class Transferer {

	private JFrame frame;
	private JLabel lblTransferer;
	private JLabel numCompteEmetteur;
	private JLabel lblMontant;
	private JLabel lblNumDeCompte;
	private JButton btnNewButton_1;
	private JButton btnRoutour;

	private JTextField montant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transferer window = new Transferer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Transferer() {
		initialize();
	}

	// Insterting a row to the table !
	public static String[][] insertRow(String[][] m, int r, String[] data) {
		String[][] out = new String[m.length + 1][];
		for (int i = 0; i < r; i++) {
			out[i] = m[i];
		}
		out[r] = data;
		for (int i = r + 1; i < out.length; i++) {
			out[i] = m[i - 1];
		}
		return out;
	}

	// Returning the selected raw
	static ArrayList theRaw = new ArrayList();

	public ArrayList getTheSelectedRaw() {
		return theRaw;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);

		frame.getContentPane().setBackground(new Color(190, 247, 251));
		frame.setBackground(new Color(0, 191, 255));
		frame.setBounds(100, 100, 1300, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JButton btnValider = new JButton("Valider");
		btnValider.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor cur1 = new Cursor(Cursor.HAND_CURSOR);
				btnValider.setCursor(cur1);
			}
		});
		btnValider.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnValider.setBackground(new Color(118, 199, 240));

	
		lblTransferer = new JLabel("Transf\u00E9rer");
		lblTransferer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransferer.setFont(new Font("Verdana", Font.BOLD, 30));
		lblTransferer.setOpaque(true);
		lblTransferer.setBackground(new Color(118, 199, 240));

		numCompteEmetteur = new JLabel("  ");
		numCompteEmetteur.setHorizontalAlignment(SwingConstants.CENTER);
		numCompteEmetteur.setBackground(new Color(255, 255, 255));
		numCompteEmetteur.setOpaque(true);

		lblMontant = new JLabel("Montant :");
		lblMontant.setOpaque(true);
		lblMontant.setHorizontalAlignment(SwingConstants.CENTER);
		lblMontant.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMontant.setBackground(new Color(131, 224, 229));

		lblNumDeCompte = new JLabel("Num\u00E9ro du compte Emetteur :");
		lblNumDeCompte.setOpaque(true);
		lblNumDeCompte.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumDeCompte.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumDeCompte.setBackground(new Color(131, 224, 229));

		btnNewButton_1 = new JButton("<-------");
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ListeComptesForm listC = new ListeComptesForm();
				listC.main(null);
			}
		});

		btnRoutour = new JButton("<-------");
		btnRoutour.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor cur1 = new Cursor(Cursor.HAND_CURSOR);
				btnRoutour.setCursor(cur1);
			}
		});
		btnRoutour.setBackground(new Color(192, 192, 192));
		btnRoutour.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnRoutour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ListeComptesForm listC = new ListeComptesForm();
				listC.main(null);
			}
		});

		montant = new JTextField();
		montant.enable(false);
		montant.setBackground(new Color(192, 192, 192));
		montant.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.')) {
					e.consume();
				}
			}
		});

//		montant.setToolTipText("");
//		montant.setColumns(10);
//		System.out.println(montant.getText());

		// table

		// Getting the list of clients from the database

		CompteImplement ci = new CompteImplement();
		ComptecousImplement cci = new ComptecousImplement();
		CompteepaImplement cei = new CompteepaImplement();

		List<Compte> clientsList = ci.getComptes();
		String[][] clientListData = {};
		for (Compte c : clientsList) {
			Integer i = 0;
			Comptecous comptC = cci.getComptecousByCompteId(c.getCompteID());
			Compteepa comptE = cei.getCompteepaByCompteId(c.getCompteID());/// Is returning a null value
			String typeCompte = "Pas de type";

			// Type assgnement
			if (comptC.getCompteCouID() > 0) {
				typeCompte = "Courant";
			}
			if (comptE.getCompteEpaID() > 0) {
				typeCompte = "Epargne";
			}
			clientListData = insertRow(clientListData, i,
					new String[] { c.getNumCom() + "", typeCompte, c.getClientID() + "", c.getSolde() + "" });
			i++;

		}

		String col[] = { "   Num\u00E9ro de Compte  ", "    Type de Compte", "   Cilent", "    Solde" };
		JTable table = new JTable(clientListData, col);
		table.setModel(new DefaultTableModel(clientListData,
				new String[] { "   Num\u00E9ro de Compte  ", "    Type de Compte", "   Cilent", "    Solde" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		// ################################################

		// Le compte clické de la liste des comptes :

		//Compte émetteur
		ListeComptesForm lcf = new ListeComptesForm();
		ArrayList theRawa = lcf.getTheSelectedRaw();
		System.out.println("The selected raw saize is : " + theRawa.size());
		System.out.println("We are in transferer ! ");
		System.out.println("The numero of the account  : " + theRawa.get(0));
		numCompteEmetteur.setText(theRawa.get(0) + "");
		Compte c = ci.getCompteByNumeroCompte((Integer.parseInt(theRawa.get(0).toString())));
		
		

		//#####################################################################################
		
		table.setFont(new Font("Verdana", Font.PLAIN, 12));
		table.setPreferredScrollableViewportSize(new Dimension(500, 200));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// frame.getContentPane().add(scrollPane);

		JTableHeader header = table.getTableHeader();
		header.setBackground(new Color(123, 167, 220));
		header.setFont(new Font("Verdana", Font.BOLD, 14));

		
		
		//Accutal table evenListener
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("Row clicked in Transfer! ");
				montant.enable(true);
				montant.setBackground(new Color(255, 255, 255));
				theRaw = new ArrayList();
				int i = table.getSelectedRow();
				TableModel tm = table.getModel();
			
				theRaw.add(tm.getValueAt(i, 0).toString());
				theRaw.add(tm.getValueAt(i, 1).toString()); 
				theRaw.add(tm.getValueAt(i, 2).toString()); 
				theRaw.add(tm.getValueAt(i, 3).toString()); 
				
				for(Object o : theRaw) {
					System.out.print(" "+o+" ");
				}
				
			}
		});
		
		//theRawa is the comming Raw
		//TheRaw is the current raw of the transferer
		
		
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Compte compteEmetteur = c;
				Compte compteBenificiaire = ci.getCompteByNumeroCompte((Integer.parseInt(theRaw.get(0).toString())));
				
				if(compteBenificiaire.getNumCom() == compteEmetteur.getNumCom()) {
					System.out.println("Le compter émetteur et le compte bénificiaire sont le même compte");
            	    JOptionPane.showMessageDialog(frame, "Le compter émetteur et le compte bénificiaire sont le même compte!");
				}else {
					if(compteEmetteur.getSolde() >= Double.parseDouble(montant.getText())) {
						compteBenificiaire.setSolde(compteBenificiaire.getSolde() + Double.parseDouble(montant.getText()));
						compteEmetteur.setSolde(compteEmetteur.getSolde() - Double.parseDouble(montant.getText()));
						ci.createCompte(compteBenificiaire);
						ci.createCompte(compteEmetteur);
						
						frame.setVisible(false);
						ListeComptesForm listC = new ListeComptesForm();
						listC.main(null);
						
					}else {
						System.out.println("Le montant à débiter est suppérieur au solde du compte ! ");
	            	    JOptionPane.showMessageDialog(frame, "Le montant à débiter est suppérieur au solde du compte ! ");
					}
				}
				
				
				
			}
		});


		
		

		
		// Layout

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addGap(101).addComponent(btnRoutour)
				.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 782, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblMontant, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
								.addGap(37)
								.addComponent(montant, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNumDeCompte, GroupLayout.PREFERRED_SIZE, 256,
										GroupLayout.PREFERRED_SIZE)
								.addGap(48).addComponent(numCompteEmetteur, GroupLayout.PREFERRED_SIZE, 470,
										GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnValider, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
								.addGap(190)))
				.addContainerGap(257, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(523, Short.MAX_VALUE)
						.addComponent(lblTransferer, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
						.addGap(493)));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addComponent(lblTransferer, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addGap(53)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(numCompteEmetteur, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNumDeCompte, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
								.addGap(18)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(48)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblMontant, GroupLayout.PREFERRED_SIZE, 43,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(montant, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnRoutour)
										.addComponent(btnValider, GroupLayout.PREFERRED_SIZE, 49,
												GroupLayout.PREFERRED_SIZE))
								.addGap(41)));
		frame.getContentPane().setLayout(groupLayout);

	}

}
