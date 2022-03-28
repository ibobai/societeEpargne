package fr.gestion.comptes.bancaires.cloturer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import fr.gestion.comptes.bancaires.comptes.ListeComptesForm;
import fr.gestion.comptes.bancaires.daos.implement.CompteImplement;
import fr.gestion.comptes.bancaires.pojos.Compte;

import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.awt.event.MouseEvent;

public class CloturerCompteForm {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CloturerCompteForm window = new CloturerCompteForm();
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
	public CloturerCompteForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);

		frame.setBounds(100, 100, 700, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// center la fenetre
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\u00CAtes-vous s\u00FBr de vouloir supprimer ce compte ?");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor  cur1 = new Cursor(Cursor.HAND_CURSOR);
				btnSupprimer.setCursor(cur1);
			}
		});
	
		
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Cursor  cur1 = new Cursor(Cursor.HAND_CURSOR);
				btnAnnuler.setCursor(cur1);
			}
			
		});
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAnnuler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //frame.setVisible(false);
                ListeComptesForm listC = new ListeComptesForm();
                listC.main(null);
            }
        });
		
		
		System.out.println("We are in cloturer !");
		ListeComptesForm lcf = new ListeComptesForm();
		ArrayList theRawa = lcf.getTheSelectedRaw();
		CompteImplement ci = new CompteImplement();
		Compte c = ci.getCompteByNumeroCompte((Integer.parseInt(theRawa.get(0).toString())));
		
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSupprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	ci.deleteCompte(c.getCompteID());
                //frame.setVisible(false);
            	SupprimerConfirm listC = new SupprimerConfirm();
                listC.main(null);
            }
        });
		//System.out.println(c.getSolde() + " This is the solde ");
		
		
		
		
//////////////////////     Layout                    ////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(206)
							.addComponent(btnSupprimer)
							.addGap(94)
							.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(155)
							.addComponent(lblNewLabel)))
					.addContainerGap(199, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addComponent(lblNewLabel)
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSupprimer)
						.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(199, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
