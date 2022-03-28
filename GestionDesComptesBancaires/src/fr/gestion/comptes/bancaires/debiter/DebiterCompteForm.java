package fr.gestion.comptes.bancaires.debiter;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fr.gestion.comptes.bancaires.comptes.ListeComptesForm;
import fr.gestion.comptes.bancaires.daos.implement.CompteImplement;
import fr.gestion.comptes.bancaires.pojos.Compte;

public class DebiterCompteForm {

	private JFrame frame;
	private JTextField numeroCompte;
	private JTextField solde;
	private JTextField montant;
	private JButton btnValider;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DebiterCompteForm window = new DebiterCompteForm();
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
	public DebiterCompteForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);

		frame.getContentPane().setBackground(new Color(190, 247, 251));
		frame.setResizable(false);
		frame.setBounds(100, 100, 1300, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JLabel lblDebiter = new JLabel("Debiter un compte");
		lblDebiter.setBackground(new Color(118, 199, 240));
		lblDebiter.setHorizontalAlignment(SwingConstants.CENTER);
		lblDebiter.setFont(new Font("Verdana", Font.BOLD, 30));
		lblDebiter.setOpaque(true);
		

		

		JLabel lblNumroDeCompte = new JLabel("Numéro Compte");

		lblNumroDeCompte.setOpaque(true);
		lblNumroDeCompte.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumroDeCompte.setBackground(new Color(118, 199, 240));
		
		JLabel lblSolde = new JLabel("Solde");
		lblSolde.setOpaque(true);
		lblSolde.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolde.setBackground(new Color(118, 199, 240));
		
		JLabel lblNumroDeCompte_2_2 = new JLabel("Montant");
		lblNumroDeCompte_2_2.setOpaque(true);
		lblNumroDeCompte_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumroDeCompte_2_2.setBackground(new Color(118, 199, 240));
		
		numeroCompte = new JTextField();
		numeroCompte.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( !(Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.')) {
		            e.consume();  // ignorer l'�v�nement
		        }
		     }
		});
		numeroCompte.setColumns(10);
		
		solde = new JTextField();
		solde.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( !(Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.')) {
		            e.consume();  // ignorer l'�v�nement
		        }
		     }
		});
		solde.setColumns(10);
		
		montant = new JTextField();
		montant.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( !(Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.')) {
		            e.consume();  // ignorer l'�v�nement
		        }
		     }
		});
		montant.setColumns(10);
		
		btnValider = new JButton("Valider");
		btnValider.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor  cur1 = new Cursor(Cursor.HAND_CURSOR);
				btnValider.setCursor(cur1);
			}
		});

		
		
		btnBack = new JButton("<-------");
		btnBack.setBackground(new Color(192, 192, 192));
		btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
                ListeComptesForm listC = new ListeComptesForm();
                listC.main(null);
            }
        });
		
		
		//Le compte clické de la liste des comptes : 
		
		ListeComptesForm lcf = new ListeComptesForm();
		ArrayList theRawa = lcf.getTheSelectedRaw();
		System.out.println("The selected raw saize is : "+ theRawa.size());
		System.out.println("We are in débiter ! ");
		System.out.println("The numero of the account  : "+theRawa.get(0));
		numeroCompte.setText(theRawa.get(0)+"");
		
//		for (Object val : theRawa) {
//		    System.out.print(val + " From the table créditer !");
//		}
		
		//Compte info
		
		CompteImplement ci = new CompteImplement();
		Compte c = ci.getCompteByNumeroCompte((Integer.parseInt(theRawa.get(0).toString())));
		//System.out.println(c.getSolde() + " This is the solde ");
		solde.setText(c.getSolde()+"");
		
		
		btnValider.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnValider.setBackground(new Color(118, 199, 240));
		btnValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	Double theSolde = c.getSolde();
            	System.out.println("The actual solde is : "+theSolde);
            	System.out.println("The montant text is : "+montant.getText());
            	Double theAddedSolde = theSolde -  Double.parseDouble(montant.getText());
            	if(Double.parseDouble(solde.getText()) >= Double.parseDouble(montant.getText())) {
                	c.setSolde(c.getSolde() - Double.parseDouble(montant.getText()));
                	ci.createCompte(c);
                	System.out.println("The after solde is  : " + theAddedSolde);
                	//ci.createCompte(c);
                    frame.setVisible(false);
                    ListeComptesForm listC = new ListeComptesForm();
                    listC.main(null);
            		
            	}else {
            		System.out.println("Solde is inferierur ");
            	    JOptionPane.showMessageDialog(frame, "Le solde à débiter est inférieur au solde initial !");
            	}
            	
            }
        });
	
		
		/////////////////////////////////////////////////////////////////////////////////////////////////
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(371)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNumroDeCompte, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSolde, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumroDeCompte_2_2, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
							.addGap(109)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(solde, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
								.addComponent(numeroCompte, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
								.addComponent(montant, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(416)
							.addComponent(lblDebiter, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(97)
							.addComponent(btnBack))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(552)
							.addComponent(btnValider, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(398, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addComponent(lblDebiter, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(120)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumroDeCompte, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(numeroCompte, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSolde, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(solde, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNumroDeCompte_2_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(montant, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addComponent(btnValider, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(63)
					.addComponent(btnBack)
					.addContainerGap(85, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
