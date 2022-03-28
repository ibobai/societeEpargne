package fr.gestion.comptes.bancaires.ouvrir;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.print.attribute.AttributeSet;
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
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import fr.gestion.comptes.bancaires.comptes.ListeComptesForm;
import fr.gestion.comptes.bancaires.daos.implement.ClientImplement;
import fr.gestion.comptes.bancaires.daos.implement.CompteImplement;
import fr.gestion.comptes.bancaires.daos.implement.ComptecousImplement;
import fr.gestion.comptes.bancaires.daos.implement.CompteepaImplement;
import fr.gestion.comptes.bancaires.obj.CompteObj;
import fr.gestion.comptes.bancaires.obj.ComptecousObj;
import fr.gestion.comptes.bancaires.obj.CompteepaObj;
import fr.gestion.comptes.bancaires.pojos.Client;
import fr.gestion.comptes.bancaires.pojos.Compte;
import fr.gestion.comptes.bancaires.pojos.Comptecous;
import fr.gestion.comptes.bancaires.pojos.Compteepa;

public class OuvrirCompteForm  {

	private JFrame frame;
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
					OuvrirCompteForm window = new OuvrirCompteForm();
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
	public OuvrirCompteForm() {
		initialize();
	}
	
	//################################        fonction   Generer      ####################################################################
	
	public static int GenererNumCompte() {
		double nb = Math.random()*1000000;
		int res=(int)Math.floor(nb);
		
		while (res < 100000) {
			nb = Math.random()*1000000;
			res=(int)Math.floor(nb);	
		}
		return (res);	
	}
	
	//################################        Methode limitation de textfield       ####################################################################
	
	class JTextFieldLimit extends PlainDocument {
		  private int limit;
		  JTextFieldLimit(int limit) {
		    super();
		    this.limit = limit;
		  }

		  JTextFieldLimit(int limit, boolean upper) {
		    super();
		    this.limit = limit;
		  }

		  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		    if (str == null)
		      return;

		    if ((getLength() + str.length()) <= limit) {
		      super.insertString(offset, str, (javax.swing.text.AttributeSet) attr);
		    }
		  }
		}
	
	
	//################################                  ####################################################################


	
	//Toutes les variables.
	
	JRadioButton rdbtnEpargne;
	JRadioButton rdbtnCourant;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(190, 247, 251));
		frame.setResizable(false);
		frame.setBounds(100, 100, 1300, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JLabel lblOuvrirUnCompte = new JLabel("Ouvrir un compte");
		lblOuvrirUnCompte.setFont(new Font("Verdana", Font.BOLD, 30));
		lblOuvrirUnCompte.setBackground(new Color(118, 199, 240));
		lblOuvrirUnCompte.setHorizontalAlignment(SwingConstants.CENTER);
		lblOuvrirUnCompte.setOpaque(true);
		
		
		JLabel lblNumroDeCompte = new JLabel("Numero de compte");
		lblNumroDeCompte.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumroDeCompte.setBackground(new Color(118, 199, 240));
		lblNumroDeCompte.setOpaque(true);
		
		
		
		JButton btnBack = new JButton("<-------");
		btnBack.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor  cur1 = new Cursor(Cursor.HAND_CURSOR);
				btnBack.setCursor(cur1);
			}
		});
		btnBack.setBackground(new Color(192, 192, 192));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
                ListeComptesForm listC = new ListeComptesForm();
                listC.main(null);
			}
		});
		
			
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
		
		//  rdbtnCourant ##################################################################################################################################################################
		
		rdbtnCourant = new JRadioButton("Courant");
		rdbtnCourant.setBackground(new Color(131, 224, 229));
		rdbtnCourant.setHorizontalAlignment(SwingConstants.CENTER);
		
		rdbtnCourant.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				lblTautInteret.setBackground(new Color(192, 192, 192));
				lblPlafond.setBackground(new Color(192, 192, 192));
				
				tautInteret.setEditable(false);
				plafond.setEditable(false);
				
				lblSoldeMinAuto.setBackground(new Color(118, 199, 240));
				lblFraisDeTransfert.setBackground(new Color(118, 199, 240));
				
				soldeMinAuto.setEditable(true);
				fraisDeTransfert.setEditable(true);


			}
		});
		
	//  ##################################################################################################################################################################
				
		rdbtnEpargne = new JRadioButton("Epargne");
		rdbtnEpargne.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnEpargne.setBackground(new Color(131, 224, 229));
		rdbtnEpargne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblSoldeMinAuto.setBackground(new Color(192, 192, 192));
				lblFraisDeTransfert.setBackground(new Color(192, 192, 192));
				soldeMinAuto.setEditable(false);
				fraisDeTransfert.setEditable(false);
				
				lblTautInteret.setBackground(new Color(118, 199, 240));
				lblPlafond.setBackground(new Color(118, 199, 240));
				tautInteret.setEditable(true);
				plafond.setEditable(true);
			}
		});
		
	//  ###################       champs de texte        ############################################################################################################################
		
		nomDeClient = new JTextField();
		nomDeClient.setColumns(10);
		
		telDeClient = new JTextField();
		telDeClient.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( !(Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.')) {
		            e.consume();  // ignorer l'�v�nement
		        }
		     }
		});
		telDeClient.setColumns(10);
		
		fraisDeTransfert = new JTextField();
		fraisDeTransfert.setColumns(10);
		fraisDeTransfert.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( !(Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.')) {
		            e.consume();  // ignorer l'�v�nement
		        }
		     }
		});
		
		plafond = new JTextField();
		plafond.setColumns(10);
		plafond.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( !(Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.')) {
		            e.consume();  // ignorer l'�v�nement
		        }
		     }
		});
				
		soldeInitial = new JTextField();
		soldeInitial.setColumns(10);
		soldeInitial.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( !(Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE) && (c != ',')) {
		            e.consume();  // ignorer l'�v�nement
		        }
		     }
		});
		
		
		prenomDeClient = new JTextField();
		prenomDeClient.setColumns(10);
		
		adresseDeClient = new JTextField();
		adresseDeClient.setColumns(10);
		
		soldeMinAuto = new JTextField();
		soldeMinAuto.setColumns(10);
		soldeMinAuto.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( !(Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE) && (c != ',')) {
		            e.consume();  // ignorer l'�v�nement
		        }
		     }
		});
		
		
		tautInteret = new JTextField();
		tautInteret.setColumns(10);
		tautInteret.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( !(Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE) && (c != ',')) {
		            e.consume();  // ignorer l'�v�nement
		        }
		     }
		});

				
		
		//Pour choisir un seul type de compte.
		ButtonGroup typeDesComptes = new ButtonGroup();
		typeDesComptes.add(rdbtnEpargne); 
		typeDesComptes.add(rdbtnCourant);
		
		//Pour les listeners !
//		rdbtnEpargne.addActionListener(this);
//		rdbtnCourant.addActionListener(this);


		
		JLabel lblNumCompteGenere = new JLabel(String.valueOf(GenererNumCompte()));
		lblNumCompteGenere.setBackground(new Color(245, 255, 250));
		
		lblNumCompteGenere.setOpaque(true);
		lblNumCompteGenere.setHorizontalAlignment(SwingConstants.CENTER);
	
		// ###############        Valider       #################################################################################################################################
		
		
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
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					if((!nomDeClient.getText().equals("")) && (!prenomDeClient.getText().equals(""))&& (!telDeClient.getText().equals(""))&& (!adresseDeClient.getText().equals(""))&&(!soldeInitial.getText().equals(""))) {
						
						//###################################### Persisting client and account ################################################################
						ClientImplement cI = new ClientImplement();
						CompteImplement c = new CompteImplement();
						CompteepaImplement cE = new CompteepaImplement();
						ComptecousImplement cC = new ComptecousImplement();
						
						// inicier les objets 
						
						Client client = new Client();
						Compte compte = new Compte();
						Comptecous compteCous = new Comptecous();
						Compteepa compteepa = new Compteepa();
						
						
						
						//Client 
						
						client.setNom(nomDeClient.getText());
						client.setPrenom(prenomDeClient.getText());
						client.setTel(telDeClient.getText());
						client.setAdresse(adresseDeClient.getText());
						client.setEmail("nom@gmail.com");
						cI.createClient(client);
						
                        // compte 
						
						compte.setNumCom(Integer.parseInt(lblNumCompteGenere.getText()));
						compte.setSolde(Double.parseDouble(soldeInitial.getText())); 
						compte.setClientID(client.getClientID());
						c.createCompte(compte);
						
						if (!plafond.getText().equals("")) {
							
							//Comte Epargne 
							
							compteepa.setPlafond(Integer.parseInt(plafond.getText()));
							compteepa.setTauxInteret(Integer.parseInt(tautInteret.getText()));
							compteepa.setCompteID(compte.getCompteID());
							cE.createCompteepa(compteepa);
						}
						
						if (!fraisDeTransfert.getText().equals("")) {
							
							//compte Courant
							
							compteCous.setFraisTrans(Integer.parseInt(fraisDeTransfert.getText()));
							compteCous.setSoldeMin(Double.parseDouble(soldeMinAuto.getText()));
							compteCous.setCompteID(compte.getCompteID());
							cC.createComptecous(compteCous);
						}
							
						frame.setVisible(false);
		                ListeComptesForm listC = new ListeComptesForm();
		                listC.main(null); 
		                
		                /*
		                (!nomDeClient.getText().equals("")) && (!prenomDeClient.getText().equals(""))&& (!telDeClient.getText().equals(""))&& (!adresseDeClient.getText().equals(""))&&(!soldeInitial.getText().equals(""))
		                */	                
					}
					else {
						JFrame d = new  JFrame();
					    JLabel l = new JLabel("Veuillez saisir tous les champs !" , SwingConstants.CENTER);  
					     // Ajouter l'�tiquette � la bo�te de dialogue 
					    d.getContentPane().add(l); 
					    // D�finir la taille de la bo�te de dialogue 
					    d.setPreferredSize(new Dimension(280, 200));
					    d.setVisible(true);
					    d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					    d.pack();
					    d.setLocationRelativeTo(null);
					}
					
	                
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		btnValider.setBackground(new Color(118, 199, 240));
		
		
		
		
		//############################################################## Persisting client and account #######################################

		//###################      Layout     #############################################################################################################################################"

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(516, Short.MAX_VALUE)
					.addComponent(lblOuvrirUnCompte, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
					.addGap(432))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBack)
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
										.addComponent(lblNumCompteGenere, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))
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
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(1000, Short.MAX_VALUE)
					.addComponent(btnValider)
					.addGap(219))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOuvrirUnCompte, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumroDeCompte, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumCompteGenere, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
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
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSoldeInitial, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(soldeInitial, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addComponent(btnBack)
							.addContainerGap(78, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnValider)
							.addGap(47))))
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
