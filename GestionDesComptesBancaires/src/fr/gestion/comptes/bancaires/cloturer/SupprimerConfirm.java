package fr.gestion.comptes.bancaires.cloturer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import fr.gestion.comptes.bancaires.comptes.ListeComptesForm;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SupprimerConfirm {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupprimerConfirm window = new SupprimerConfirm();
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
	public SupprimerConfirm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JLabel lblCompteSupprime= new JLabel("Le compte est supprim\u00E9 !");
		lblCompteSupprime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnBack = new JButton("Retour \u00E0 la page d'accueil");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //frame.setVisible(false);
                ListeComptesForm listC = new ListeComptesForm();
                listC.main(null);
            }
        });
		
		
		
/////////////////////////////  LAYOUT ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(116)
							.addComponent(lblCompteSupprime))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(124)
							.addComponent(btnBack)))
					.addContainerGap(117, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addComponent(lblCompteSupprime)
					.addGap(67)
					.addComponent(btnBack)
					.addContainerGap(82, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
