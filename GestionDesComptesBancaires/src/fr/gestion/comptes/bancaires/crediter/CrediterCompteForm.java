package fr.gestion.comptes.bancaires.crediter;

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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import fr.gestion.comptes.bancaires.comptes.ListeComptesForm;
import fr.gestion.comptes.bancaires.daos.implement.CompteImplement;
import fr.gestion.comptes.bancaires.pojos.Compte;

public class CrediterCompteForm {

	private JLabel lblcrediterUnCompte;
	private JFrame frame;
	private JTextField numeroCompte;
	private JTextField solde;
	private JTextField montant;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrediterCompteForm window = new CrediterCompteForm();
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
	public CrediterCompteForm() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);

		frame.getContentPane().setBackground(new Color(190, 247, 251));
		frame.setBounds(100, 100, 1300, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	
	
		
		numeroCompte = new JTextField();
		numeroCompte.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( !(Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.')) {
		            e.consume();  // ignorer l'�v�nement
		        }
		     }
		});		numeroCompte.setColumns(10);
		
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
		
		JButton btnValiderCrediterUnCompte = new JButton("Valider");
		btnValiderCrediterUnCompte.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor  cur1 = new Cursor(Cursor.HAND_CURSOR);
				btnValiderCrediterUnCompte.setCursor(cur1);
			}
		});
	
		
		
		JLabel lblNumeroCompte = new JLabel("Numéro Compte");
		lblNumeroCompte.setOpaque(true);
		lblNumeroCompte.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroCompte.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNumeroCompte.setBackground(new Color(131, 224, 229));

		
		JLabel lblSolde = new JLabel("Solde");
		lblSolde.setOpaque(true);
		lblSolde.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolde.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblSolde.setBackground(new Color(131, 224, 229));
		
		JLabel lblMontant = new JLabel("Montant");
		lblMontant.setOpaque(true);
		lblMontant.setHorizontalAlignment(SwingConstants.CENTER);
		lblMontant.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblMontant.setBackground(new Color(131, 224, 229));
		
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
		
		btnNewButton = new JButton("<-------");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
                ListeComptesForm listC = new ListeComptesForm();
                listC.main(null);
            }
        });
		

    	lblcrediterUnCompte = new JLabel("Crediter un compte");
		lblcrediterUnCompte.setFont(new Font("Verdana", Font.BOLD, 30));
		lblcrediterUnCompte.setBackground(new Color(118, 199, 240));
		lblcrediterUnCompte.setHorizontalAlignment(SwingConstants.CENTER);
		lblcrediterUnCompte.setOpaque(true);


		
		
		//Le compte clické de la liste des comptes : 
		
		ListeComptesForm lcf = new ListeComptesForm();
		ArrayList theRawa = lcf.getTheSelectedRaw();
		System.out.println("The selected raw saize is : "+ theRawa.size());
		System.out.println("We are in créditer ! ");
		System.out.println("The numero of the account  : "+theRawa.get(0));
		numeroCompte.setText(theRawa.get(0)+"");
//		
//		for (Object val : theRawa) {
//		    System.out.print(val + " From the table créditer !");
//		}
//		
		//Compte info
		
		CompteImplement ci = new CompteImplement();
		Compte c = ci.getCompteByNumeroCompte((Integer.parseInt(theRawa.get(0).toString())));
		//System.out.println(c.getSolde() + " This is the solde ");
		solde.setText(c.getSolde()+"");
		

		
		btnValiderCrediterUnCompte.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnValiderCrediterUnCompte.setBackground(new Color(118, 199, 240));
		btnValiderCrediterUnCompte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	Double theSolde = c.getSolde();
            	System.out.println("The actual solde is : "+theSolde);
            	System.out.println("The solde text is : "+solde.getText());
            	Double theAddedSolde = theSolde +  Double.parseDouble(montant.getText());
            	c.setSolde(c.getSolde() + Double.parseDouble(montant.getText()));
            	System.out.println("The after solde is  : " + theAddedSolde);
            	ci.createCompte(c);
                frame.setVisible(false);
                ListeComptesForm listC = new ListeComptesForm();
                listC.main(null);
            }
        });
		
/////////////  Layout	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(222)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNumeroCompte, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSolde, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMontant, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
					.addGap(77)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(montant)
						.addComponent(solde)
						.addComponent(numeroCompte, GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE))
					.addContainerGap(144, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 412, Short.MAX_VALUE)
					.addComponent(btnValiderCrediterUnCompte, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addGap(428))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(496, Short.MAX_VALUE)
					.addComponent(lblcrediterUnCompte, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
					.addGap(188))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(117)
					.addComponent(lblcrediterUnCompte, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(114)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumeroCompte, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(numeroCompte, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSolde, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(solde, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMontant, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(montant, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(71)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnValiderCrediterUnCompte, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(49))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
