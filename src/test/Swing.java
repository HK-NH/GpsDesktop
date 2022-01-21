package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.PositionRemote;
import dao.SmartphoneRemote;
import dao.UserRemote;
import entities.User;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Swing extends javax.swing.JFrame {

	private UserRemote ur;
	private User u;
	private DefaultTableModel model;
	private List<User> users;
	private int id;

	public Swing() {
		initComponents();
		try {
			ur = UserLookup();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model = (DefaultTableModel) UserTable.getModel();
		u = new User();
		loadTable();
	}

	void loadTable() {
		users = new ArrayList<User>(ur.findAll());
		for (User u : users) {
			model.addRow(new Object[] { u.getId(), u.getNom(), u.getPrenom(), u.getEmail(), u.getTelephone(),
					u.getDateNaissance() });
		}
	}

	public UserRemote UserLookup() throws NamingException {
		Hashtable<Object, Object> conf = new Hashtable<Object, Object>();
		conf.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		conf.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(conf);
		return (UserRemote) context.lookup("ejb:/GpsServer/UserService!dao.UserRemote");
	}

	public SmartphoneRemote SmartphoneLookup() throws NamingException {
		Hashtable<Object, Object> conf = new Hashtable<Object, Object>();
		conf.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		conf.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(conf);
		return (SmartphoneRemote) context.lookup("ejb:/GpsServer/SmartphoneService!dao.SmartphoneRemote");
	}

	public PositionRemote PositionLookup() throws NamingException {
		Hashtable<Object, Object> conf = new Hashtable<Object, Object>();
		conf.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		conf.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(conf);
		return (PositionRemote) context.lookup("ejb:/GpsServer/PositionService!dao.PositionRemote");
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		nom = new javax.swing.JTextField();
		prenom = new javax.swing.JTextField();
		email = new javax.swing.JTextField();
		tel = new javax.swing.JTextField();
		daten = new com.toedter.calendar.JDateChooser();
		jScrollPane1 = new javax.swing.JScrollPane();
		UserTable = new javax.swing.JTable();
		createu = new javax.swing.JButton();
		createu.setFont(new Font("Tahoma", Font.BOLD, 11));
		deleteu = new javax.swing.JButton();
		deleteu.setFont(new Font("Tahoma", Font.BOLD, 11));
		updateu = new javax.swing.JButton();
		updateu.setFont(new Font("Tahoma", Font.BOLD, 11));
		gs = new javax.swing.JButton();
		gs.setFont(new Font("Tahoma", Font.BOLD, 11));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setLocation(new java.awt.Point(200, 100));

		jLabel1.setText("Nom :");

		jLabel2.setText("Prénom :");

		jLabel3.setText("Email :");

		jLabel4.setText("Télephone :");

		jLabel5.setText("Date Naissance");

		UserTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Id", "Nom", "Prenom", "Email", "Telephone", "Date Naissance" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		UserTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				UserTableMousePressed(evt);
			}
		});
		jScrollPane1.setViewportView(UserTable);

		createu.setText("Create");
		createu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				createuActionPerformed(evt);
			}
		});

		deleteu.setText("Delete");
		deleteu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteuActionPerformed(evt);
			}
		});

		updateu.setText("Update");
		updateu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updateuActionPerformed(evt);
			}
		});

		gs.setText("Gestion Smartphone");
		gs.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				gsActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(27, 27, 27)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
						.addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(nom, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
										.addComponent(prenom).addComponent(email).addComponent(tel))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(deleteu, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(gs, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(updateu, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(createu, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(84, 84, 84))
						.addGroup(layout.createSequentialGroup()
								.addComponent(daten, javax.swing.GroupLayout.PREFERRED_SIZE, 165,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
				.addGroup(layout
						.createSequentialGroup().addGap(41, 41, 41).addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(64, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(38, 38, 38)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(createu).addGap(18, 18, 18)
										.addComponent(updateu).addGap(18, 18, 18).addComponent(deleteu)
										.addGap(18, 18, 18).addComponent(gs))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel1))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel2).addComponent(prenom,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel3).addComponent(email,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel4).addComponent(tel,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jLabel5).addComponent(daten,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(32, 32, 32)));

		pack();

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnNewMenu = new JMenu("Gestion");
		menuBar.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("Gestion Users");
		mnNewMenu.add(mntmNewMenuItem);

		mntmNewMenuItem_1 = new JMenuItem("Exit");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
	}// </editor-fold>

	private void createuActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		if (nom.getText() == null || prenom.getText() == null || email.getText() == null || daten.getDate() == null
				|| tel.getText() == null) {
			JOptionPane.showMessageDialog(null, "Veuillez Remplir tout les champs");
		} else {
			SimpleDateFormat dt = new SimpleDateFormat("yyyyy-MM-dd", Locale.ENGLISH);
			ur.create(new User(nom.getText().toString(), prenom.getText().toString(), email.getText().toString(),
					daten.getDate(), tel.getText().toString()));
			model.setRowCount(0);
			loadTable();
			JOptionPane.showMessageDialog(null, "Utilisateur ajouté avec succes");
		}
	}

	private void UserTableMousePressed(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		int row = UserTable.getSelectedRow();
		id = (Integer) model.getValueAt(row, 0);
		nom.setText(model.getValueAt(row, 1).toString());
		prenom.setText(model.getValueAt(row, 2).toString());
		email.setText(model.getValueAt(row, 3).toString());
		tel.setText(model.getValueAt(row, 4).toString());
		daten.setDate((Date) model.getValueAt(row, 5));

	}

	private void updateuActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		if (nom.getText() == null || prenom.getText() == null || email.getText() == null || daten.getDate() == null
				|| tel.getText() == null) {
			JOptionPane.showMessageDialog(null, "Veuillez Selectionner un Utilisateur");
		} else {
			u = new User(nom.getText().toString(), prenom.getText().toString(), email.getText().toString(),
					daten.getDate(), tel.getText().toString());
			u.setId(id);
			ur.update(u);
			model.setRowCount(0);
			loadTable();
			nom.setText(null);
			prenom.setText(null);
			email.setText(null);
			daten.setDate(null);
			tel.setText(null);
			JOptionPane.showMessageDialog(null, "Utilisateur modifié avec succes");
		}

	}

	private void deleteuActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		if (nom.getText() == null || prenom.getText() == null || email.getText() == null || daten.getDate() == null
				|| tel.getText() == null) {
			JOptionPane.showMessageDialog(null, "Veuillez Selectionner un Utilisateur");
		} else {
			int dialogResult = JOptionPane.showConfirmDialog(null, "Voulez vous supprimer cette Utilisateur ?",
					"Warning", JOptionPane.YES_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {
				u.setId(id);
				ur.delete(u);
				model.setRowCount(0);
				loadTable();
				nom.setText(null);
				prenom.setText(null);
				email.setText(null);
				daten.setDate(null);
				tel.setText(null);
				JOptionPane.showMessageDialog(null, "Utilisateur supprimé");

			}
		}
	}

	private void gsActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		if (nom.getText() == null || prenom.getText() == null || email.getText() == null || daten.getDate() == null
				|| tel.getText() == null) {
			JOptionPane.showMessageDialog(null, "Veuillez Choisir Un Utilisateur");
		} else {
			DetailUser detailUser = new DetailUser(id);
			detailUser.setVisible(true);
			this.setVisible(false);
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Swing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Swing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Swing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Swing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Swing().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JTable UserTable;
	private javax.swing.JButton createu;
	private com.toedter.calendar.JDateChooser daten;
	private javax.swing.JButton deleteu;
	private javax.swing.JTextField email;
	private javax.swing.JButton gs;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextField nom;
	private javax.swing.JTextField prenom;
	private javax.swing.JTextField tel;
	private javax.swing.JButton updateu;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	// End of variables declaration
}
