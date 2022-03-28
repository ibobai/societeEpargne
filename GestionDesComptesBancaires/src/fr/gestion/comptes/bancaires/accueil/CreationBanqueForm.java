package fr.gestion.comptes.bancaires.accueil;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import fr.gestion.comptes.bancaires.comptes.ListeComptesForm;
import fr.gestion.comptes.bancaires.daos.implement.ClientImplement;
import fr.gestion.comptes.bancaires.daos.implement.Main;

public class CreationBanqueForm extends ClientImplement {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JLabel lblLogo;
	private JLabel lblUtilisateur;
	private JLabel lblMpd;
	private JTextField InputUtilisateur;
	protected Object btnAnnuler;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreationBanqueForm window = new CreationBanqueForm();
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
	public CreationBanqueForm() {
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(190, 247, 251));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("Valider");
		btnNewButton.setBackground(new Color(118, 199, 240));
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Utilisateur");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(CreationBanqueForm.class.getResource("/res/ISN BANK.png")));
		
		lblUtilisateur = new JLabel("Utilisateur");
		lblUtilisateur.setOpaque(true);

		lblUtilisateur.setBackground(new Color(131, 224, 229));
		lblUtilisateur.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblUtilisateur.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnValiderCreationBanque = new JButton("Valider");
		btnValiderCreationBanque.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor  cur1 = new Cursor(Cursor.HAND_CURSOR);
				btnValiderCreationBanque.setCursor(cur1);
				
			}
		});
		
		btnValiderCreationBanque.setBackground(new Color(118, 199, 240));
		btnValiderCreationBanque.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnValiderCreationBanque.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	if (e.getSource()==btnAnnuler)System.exit(0);
            	else {
            		String lg="essai";
            		String mp="123";
            		String lg1=InputUtilisateur.getText();
            		String mp1=passwordField.getText();
            		if (lg1.length()==0  || mp1.length()==0) {
            			InputUtilisateur.setText("");
            			passwordField.setText("");
            			JOptionPane.showInputDialog(this, "Vos saie ne son pas correcte");
            			
            		}
            		else if(lg.contentEquals(lg1) && mp.contentEquals(mp1)) {
            			
            			
            			
            			ClientImplement c = new ClientImplement();

            		//	c.deleteClient(2);
            		
            			// c.deleteClient(2); 

            			//JOptionPane.showInputDialog(this, "Vous �tes autentifi� (es)");
            			frame.setVisible(false);
                        ListeComptesForm listC = new ListeComptesForm();
                        listC.main(null);
            			
            		}
            		
            		else {
            			InputUtilisateur.setText("");
            			passwordField.setText("");
            			JOptionPane.showInputDialog(this, "Le login ou mot de passe est incorecte");
            			
            		}
            	}
                
            }
        });
		lblMpd = new JLabel("Mot de passe");
		lblMpd.setOpaque(true);
		lblMpd.setHorizontalAlignment(SwingConstants.CENTER);
		lblMpd.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblMpd.setBackground(new Color(131, 224, 229));
		
		InputUtilisateur = new JTextField();
		InputUtilisateur.setColumns(10);
		
		JButton btnAnnuler = new JButton("Annuler");
		 btnAnnuler.setBackground(new Color(118, 199, 240));
		 btnAnnuler.setFont(new Font("Verdana", Font.PLAIN, 15));
		 btnAnnuler.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseMoved(MouseEvent e) {
					Cursor  cur1 = new Cursor(Cursor.HAND_CURSOR);
					 btnAnnuler.setCursor(cur1);
					
				}
			});
		
		passwordField = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(601, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					.addGap(444))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(182)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
					.addComponent(textField_1, 709, 709, 709)
					.addGap(109))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(148, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblUtilisateur, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
								.addGap(143)))
						.addComponent(lblMpd, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
							.addComponent(InputUtilisateur, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE))
						.addComponent(passwordField, 603, 603, 603))
					.addGap(210))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(627, Short.MAX_VALUE)
					.addComponent(btnValiderCreationBanque, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addGap(83)
					.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addGap(326))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(398, Short.MAX_VALUE)
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
					.addGap(355))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addGap(94)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUtilisateur, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(InputUtilisateur, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMpd, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnValiderCreationBanque, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(165)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addGap(55)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(51))))
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 1300, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
