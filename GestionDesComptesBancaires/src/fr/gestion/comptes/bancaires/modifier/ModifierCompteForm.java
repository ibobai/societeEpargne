package fr.gestion.comptes.bancaires.modifier;


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

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import fr.gestion.comptes.bancaires.comptes.ListeComptesForm;
import fr.gestion.comptes.bancaires.daos.implement.ClientImplement;
import fr.gestion.comptes.bancaires.daos.implement.CompteImplement;
import fr.gestion.comptes.bancaires.daos.implement.ComptecousImplement;
import fr.gestion.comptes.bancaires.daos.implement.CompteepaImplement;
import fr.gestion.comptes.bancaires.pojos.Client;
import fr.gestion.comptes.bancaires.pojos.Compte;
import fr.gestion.comptes.bancaires.pojos.Comptecous;
import fr.gestion.comptes.bancaires.pojos.Compteepa;

public class ModifierCompteForm  {

	private JFrame frame;
	private JTextField numeroCompte;
	private JTextField nomDeClient;
	private JTextField telDeClient;
	private JTextField fraisDeTransfert;
	private JTextField plafond;
	private JTextField soldeInitial;
	private JTextField prenomDeClient;
	private JTextField adresseDeClient;
	private JTextField soldeMinAuto;
	private JTextField tautInteret;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifierCompteForm window = new ModifierCompteForm();
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
	public ModifierCompteForm() {
		initialize();
	}

	
	//Toutes les variables.
	
	JRadioButton rdbtnEpargne;
	JRadioButton rdbtnCourant;
	String typeCompte;
	Compte theCompte;
	Client theClient;
	Compteepa theCompteE;
	Comptecous theCompteCous;
	ClientImplement cImplement = new ClientImplement();
	CompteImplement ci = new CompteImplement();
	ComptecousImplement cci = new ComptecousImplement();
	CompteepaImplement cei = new CompteepaImplement();
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
		
		
		//Type de compte et les imports###########################################################"
		
		ListeComptesForm lcf = new ListeComptesForm();
		ArrayList theRawa = lcf.getTheSelectedRaw();
		Integer i = 0;
		
		
		
		
		Compte c = ci.getCompteByNumeroCompte((Integer.parseInt(theRawa.get(0).toString())));
		Comptecous comptC = cci.getComptecousByCompteId(c.getCompteID());
		Compteepa comptE = cei.getCompteepaByCompteId(c.getCompteID());/// Is returning a null value
		
		
		
		
		
		// System.out.println("Id compteCoups : " + comptC.getCompteCouID());
		// System.out.println("Id compteepas : " + comptE.getCompteEpaID());
		typeCompte = "Pas de type";

		// Type assgnement
		if (comptC.getCompteCouID() > 0) {
			typeCompte = "Courant";
		}
		if (comptE.getCompteEpaID() > 0) {
			typeCompte = "Epargne";
		}
		//#################################################################################
		
		
		JLabel lblModifierUnCompte = new JLabel("Modifier un compte");
		lblModifierUnCompte.setFont(new Font("Verdana", Font.BOLD, 30));
		lblModifierUnCompte.setBackground(new Color(118, 199, 240));
		lblModifierUnCompte.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifierUnCompte.setOpaque(true);
		
		JLabel lblNumroDeCompte = new JLabel("Numero de compte");
		lblNumroDeCompte.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumroDeCompte.setBackground(new Color(118, 199, 240));
		lblNumroDeCompte.setOpaque(true);
		
		JButton btnBack = new JButton("<-------");
		btnBack.setBackground(new Color(192, 192, 192));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
                ListeComptesForm listC = new ListeComptesForm();
                listC.main(null);
			}
		});
		
		JButton btnValider = new JButton("Valider");
		btnValider.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor  cur1 = new Cursor(Cursor.HAND_CURSOR);
				btnValider.setCursor(cur1);
			}
		});
		btnValider.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnValider.setBackground(new Color(118, 199, 240));
		btnValider.setBackground(new Color(118, 199, 240));
		
		
		
		/*
		JButton btnBack = new JButton("<-------");
		btnBack.setBackground(new Color(192, 192, 192));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnValider.setBackground(new Color(118, 199, 240));
		
		*/
		
		
		JLabel lblTypeDeCompte = new JLabel("Type de compte");
		lblTypeDeCompte.setOpaque(true);
		lblTypeDeCompte.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypeDeCompte.setBackground(new Color(118, 199, 240));
		
		JLabel lblNomDeClient = new JLabel("Nom de client");
		lblNomDeClient.setOpaque(true);
		lblNomDeClient.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomDeClient.setBackground(new Color(118, 199, 240));
		
		JLabel lblTel = new JLabel("Tel");
		lblTel.setOpaque(true);
		lblTel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTel.setBackground(new Color(118, 199, 240));
		
		JLabel lblFraisDeTransfert = new JLabel("Frais de transfert");
		lblFraisDeTransfert.setOpaque(true);
		lblFraisDeTransfert.setHorizontalAlignment(SwingConstants.CENTER);
		lblFraisDeTransfert.setBackground(new Color(118, 199, 240));
		
		JLabel lblPlafond = new JLabel("Plafond");
		lblPlafond.setOpaque(true);
		lblPlafond.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlafond.setBackground(new Color(118, 199, 240));
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setOpaque(true);
		lblPrenom.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenom.setBackground(new Color(118, 199, 240));
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setOpaque(true);
		lblAdresse.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdresse.setBackground(new Color(118, 199, 240));
		
		JLabel lblSoldeMinAuto = new JLabel("Solde min auto");
		lblSoldeMinAuto.setOpaque(true);
		lblSoldeMinAuto.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoldeMinAuto.setBackground(new Color(118, 199, 240));
		
		JLabel lblTautInteret = new JLabel("Taux d'interet");
		lblTautInteret.setOpaque(true);
		lblTautInteret.setHorizontalAlignment(SwingConstants.CENTER);
		lblTautInteret.setBackground(new Color(118, 199, 240));
		
		JLabel lblSoldeInitial = new JLabel("Solde initial");
		lblSoldeInitial.setOpaque(true);
		lblSoldeInitial.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoldeInitial.setBackground(new Color(118, 199, 240));
		
		rdbtnCourant = new JRadioButton("Courant");
		rdbtnCourant.setBackground(new Color(131, 224, 229));
		rdbtnCourant.setHorizontalAlignment(SwingConstants.CENTER);
				
		rdbtnEpargne = new JRadioButton("Epargne");
		rdbtnEpargne.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnEpargne.setBackground(new Color(131, 224, 229));
		
		//########  Les text s  ###########################################################################################################################
		
		numeroCompte = new JTextField("");
		numeroCompte.setColumns(10);
		
		
		//  ClientObj updateClient(Integer id, String Change, String indic)
		
		
//		CompteImplement c = new CompteImplement();
//		CompteepaImplement cE = new CompteepaImplement();
//		ComptecousImplement cC = new ComptecousImplement();
//		
//		ClientObj client = new ClientObj();
		/*
		Compte compte = new Compte();
		Comptecous compteCous = new Comptecous();
		Compteepa compteepa = new Compteepa();*/
		
		
		nomDeClient = new JTextField();
		nomDeClient.setColumns(10);
//		if (!nomDeClient.getText().equals("")) {
//			String indic = "N";
//			cI.updateClient(1, nomDeClient.getText(),indic);
//			
//		}
		
		
		prenomDeClient = new JTextField();
		prenomDeClient.setColumns(10);
		
		telDeClient = new JTextField();
		telDeClient.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( !(Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE)) {
		            e.consume();  // ignorer l'�v�nement
		        }
		     }
		});
		
		adresseDeClient = new JTextField();
		adresseDeClient.setColumns(10);
			
		telDeClient.setColumns(10);
		
		fraisDeTransfert = new JTextField();
		fraisDeTransfert.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( !(Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE) && (c != ',')) {
		            e.consume();  // ignorer l'�v�nement
		        }
		     }
		});
		fraisDeTransfert.setColumns(10);
		
		plafond = new JTextField();
		plafond.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( !(Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE) && (c != ',')) {
		            e.consume();  // ignorer l'�v�nement
		        }
		     }
		});
		plafond.setColumns(10);
		
		soldeInitial = new JTextField();
		soldeInitial.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( !(Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE) && (c != ',')) {
		            e.consume();  // ignorer l'�v�nement
		        }
		     }
		});
		soldeInitial.setColumns(10);
		
		
		
		soldeMinAuto = new JTextField();
		soldeMinAuto.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( !(Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE) && (c != ',')) {
		            e.consume();  // ignorer l'�v�nement
		        }
		     }
		});
		soldeMinAuto.setColumns(10);
		
		tautInteret = new JTextField();
		tautInteret.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( !(Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE) && (c != ',')) {
		            e.consume();  // ignorer l'�v�nement
		        }
		     }
		});
		tautInteret.setColumns(10);
		
		
		//Pour choisir un seul type de compte.
		ButtonGroup typeDesComptes = new ButtonGroup();
		typeDesComptes.add(rdbtnEpargne); 
		typeDesComptes.add(rdbtnCourant);
		
		//Pour les listeners !
//		rdbtnEpargne.addActionListener(this);
//		rdbtnCourant.addActionListener(this);

		
		
		if(typeCompte.equals("Courant")) {
			
			theCompte = c;
			theClient = cImplement.getClientById(c.getClientID());
			theCompteCous = comptC;
			
			
			nomDeClient.setText(theClient.getNom());
			prenomDeClient.setText(theClient.getPrenom());
			telDeClient.setText(theClient.getTel());
			adresseDeClient.setText(theClient.getAdresse());
			
			soldeMinAuto.setText(theCompteCous.getSoldeMin()+"");
			fraisDeTransfert.setText(theCompteCous.getFraisTrans()+"");
			
			soldeInitial.setText(theCompte.getSolde()+"");
			
			
			
			lblTautInteret.setBackground(new Color(192, 192, 192));
			lblPlafond.setBackground(new Color(192, 192, 192));
			tautInteret.setEditable(false);
			plafond.setEditable(false);
			rdbtnCourant.setSelected(true);
			//rdbtnEpargne.enable(false);
			
			lblSoldeMinAuto.setBackground(new Color(118, 199, 240));
			lblFraisDeTransfert.setBackground(new Color(118, 199, 240));
			soldeMinAuto.setEditable(true);
			fraisDeTransfert.setEditable(true);
			
			
			
			
		}if(typeCompte.equals("Epargne")) {
			
			theCompte = c;
			theClient = cImplement.getClientById(c.getClientID());
			theCompteE = comptE;
			
			nomDeClient.setText(theClient.getNom());
			prenomDeClient.setText(theClient.getPrenom());
			telDeClient.setText(theClient.getTel());
			adresseDeClient.setText(theClient.getAdresse());
			
			tautInteret.setText(theCompteE.getTauxInteret()+"");
			plafond.setText(theCompteE.getPlafond()+"");
			
			soldeInitial.setText(theCompte.getSolde()+"");
			
			
			
			lblSoldeMinAuto.setBackground(new Color(192, 192, 192));
			lblFraisDeTransfert.setBackground(new Color(192, 192, 192));
			soldeMinAuto.setEditable(false);
			fraisDeTransfert.setEditable(false);
			rdbtnEpargne.setSelected(true);
			//rdbtnCourant.enable(false);
			
			lblTautInteret.setBackground(new Color(118, 199, 240));
			lblPlafond.setBackground(new Color(118, 199, 240));
			tautInteret.setEditable(true);
			plafond.setEditable(true);
		}
		
//		rdbtnCourant.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//
//			}
//		});
//		
//		rdbtnEpargne.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//			
//
//
//			}
//		});
		
		

		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(typeCompte.equals("Courant")) {
					
					//Pour le client
					theClient.setAdresse(adresseDeClient.getText());
					theClient.setNom(nomDeClient.getText());
					theClient.setPrenom(prenomDeClient.getText());
					theClient.setTel(telDeClient.getText());
					cImplement.createClient(theClient);
					
					
					//Pour le compteType
					theCompteCous.setFraisTrans(Integer.parseInt(fraisDeTransfert.getText()));
					theCompteCous.setSoldeMin(Integer.parseInt(soldeMinAuto.getText()));
					cci.createComptecous(comptC);
					
					//Pour le compte
					theCompte.setSolde(Double.parseDouble(soldeInitial.getText()));
					ci.createCompte(c);
					
				}if(typeCompte.equals("Epargne")) {
					//Pour le client
					theClient.setAdresse(adresseDeClient.getText());
					theClient.setNom(nomDeClient.getText());
					theClient.setPrenom(prenomDeClient.getText());
					theClient.setTel(telDeClient.getText());
					cImplement.createClient(theClient);
					
					
					//Pour le compteType
					theCompteE.setPlafond(Integer.parseInt(plafond.getText()));
					theCompteE.setTauxInteret(Integer.parseInt(tautInteret.getText()));
					
					//Pour le compte
					theCompte.setSolde(Double.parseDouble(soldeInitial.getText()));
					ci.createCompte(c);
				}
				
				frame.setVisible(false);
                ListeComptesForm listC = new ListeComptesForm();
                listC.main(null);
			}
		});
		
		//Le compte clické de la liste des comptes : 
	
		System.out.println("The selected raw saize is : "+ theRawa.size());
		System.out.println("We are in débiter ! ");
		System.out.println("The numero of the account  : "+theRawa.get(0));
		numeroCompte.setText(theRawa.get(0)+"");
		
		// #########  Layout ######################################################################################################################

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(516, Short.MAX_VALUE)
					.addComponent(lblModifierUnCompte, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
					.addGap(432))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnBack)
							.addPreferredGap(ComponentPlacement.RELATED, 991, Short.MAX_VALUE)
							.addComponent(btnValider)
							.addGap(82))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPlafond, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNumroDeCompte, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTypeDeCompte, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNomDeClient, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFraisDeTransfert, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTel, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSoldeInitial, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
							.addGap(92)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(nomDeClient, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
												.addComponent(telDeClient, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
												.addComponent(fraisDeTransfert, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
												.addComponent(plafond, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
											.addGap(40)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblAdresse, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblPrenom, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblSoldeMinAuto, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblTautInteret, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(rdbtnCourant, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
											.addComponent(rdbtnEpargne, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
										.addComponent(numeroCompte, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))
									.addGap(103)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(prenomDeClient, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
										.addComponent(soldeMinAuto, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
										.addComponent(adresseDeClient, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
										.addComponent(tautInteret, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
									.addGap(157))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(soldeInitial, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblModifierUnCompte, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumroDeCompte, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(numeroCompte, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTypeDeCompte, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnCourant, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnEpargne, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomDeClient, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrenom, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(nomDeClient, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(prenomDeClient, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdresse, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(telDeClient, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(adresseDeClient, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFraisDeTransfert, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSoldeMinAuto, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(fraisDeTransfert, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(soldeMinAuto, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlafond, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTautInteret, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(plafond, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(tautInteret, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSoldeInitial, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(soldeInitial, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnValider))
					.addContainerGap(77, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	/*
	 	resultEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(frame, "Your name is: "+ txtName.getText()+"\nYour email is: "+txtEmail.getText(),"Your infos",JOptionPane.INFORMATION_MESSAGE);
				//lblNameAndEmail.setText("It's working!");
				if(signe.equals("+")) {
					answerIs.setText( Integer.toString(Integer.parseInt(firstNumb.getText()) + Integer.parseInt(secondNumb.getText())));
				}else {
					answerIs.setText( Integer.toString(Integer.parseInt(firstNumb.getText()) - Integer.parseInt(secondNumb.getText())));

				}
				firstNumb.setText("");secondNumb.setText("");

			}
		});
	  */
	
	//Pour rendre la page dénamique ! Et qu'elle change en fonction de type de compte.

//	public void actionPerformed(ActionEvent e){
//		if(e.getSource() == rdbtnEpargne) {
//			
//			System.out.println("You picked compte épargne ! ");
//		}
//		if(e.getSource() == rdbtnCourant) {
//			System.out.println("You picked compte courant ! ");
//		}
//	}
	
}
