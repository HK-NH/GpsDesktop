/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.SmartphoneRemote;
import dao.UserRemote;
import entities.Smartphone;
import entities.User;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

/**
 *
 * @author NameHere
 */
public class DetailUser extends javax.swing.JFrame {

	/**
	 * Creates new form DetailUser
	 */

	private int userid;
	private SmartphoneRemote sr;
	private UserRemote ur;
	private Smartphone sm;
	private DefaultTableModel model;
	private List<Smartphone> smartphones;
	private int id;

	public DetailUser() {
		initComponents();
	}

	public DetailUser(int userid) {
		initComponents();
		this.userid = userid;
		try {
			sr = SmartphoneLookup();
			ur = UserLookup();
			nomUser.setText("Gestion Des SmartPhones pour " + ur.findById(userid).getNom());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model = (DefaultTableModel) smartphoneTable.getModel();
		sm = new Smartphone();
		loadTable();
	}

	void loadTable() {
		smartphones = new ArrayList<Smartphone>(sr.findAll(userid));
		for (Smartphone s : smartphones) {
			model.addRow(new Object[] { s.getId(), s.getMarque(), s.getImei() });
		}
	}

	public SmartphoneRemote SmartphoneLookup() throws NamingException {
		Hashtable<Object, Object> conf = new Hashtable<Object, Object>();
		conf.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		conf.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(conf);
		return (SmartphoneRemote) context.lookup("ejb:/GpsServer/SmartphoneService!dao.SmartphoneRemote");
	}

	public UserRemote UserLookup() throws NamingException {
		Hashtable<Object, Object> conf = new Hashtable<Object, Object>();
		conf.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		conf.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(conf);
		return (UserRemote) context.lookup("ejb:/GpsServer/UserService!dao.UserRemote");
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		marque = new javax.swing.JTextField();
		imei = new javax.swing.JTextField();
		nomUser = new javax.swing.JLabel();
		nomUser.setFont(new Font("Times New Roman", Font.BOLD, 13));
		jScrollPane1 = new javax.swing.JScrollPane();
		smartphoneTable = new javax.swing.JTable();
		Creates = new javax.swing.JButton();
		Creates.setFont(new Font("Tahoma", Font.BOLD, 11));
		Updates = new javax.swing.JButton();
		Updates.setFont(new Font("Tahoma", Font.BOLD, 11));
		Deletes = new javax.swing.JButton();
		Deletes.setFont(new Font("Tahoma", Font.BOLD, 11));
		jButton4 = new javax.swing.JButton();
		jButton4.setFont(new Font("Tahoma", Font.BOLD, 11));
		menuBar = new javax.swing.JMenuBar();
		fileMenu = new javax.swing.JMenu();
		openMenuItem = new javax.swing.JMenuItem();
		exitMenuItem = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setLocation(new java.awt.Point(200, 100));
		jLabel1.setText("Marque :");

		jLabel2.setText("IMEI :");

		smartphoneTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Id", "Marque", "IMEI" }) {
			boolean[] canEdit = new boolean[] { false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		smartphoneTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				smartphoneTableMousePressed(evt);
			}
		});
		jScrollPane1.setViewportView(smartphoneTable);

		Creates.setText("Create");
		Creates.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				CreatesMouseClicked(evt);
			}
		});
		Creates.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CreatesActionPerformed(evt);
			}
		});

		Updates.setText("Update");
		Updates.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				UpdatesActionPerformed(evt);
			}
		});

		Deletes.setText("Delete");
		Deletes.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DeletesActionPerformed(evt);
			}
		});

		jButton4.setText("Gestion Position");

		fileMenu.setMnemonic('f');
		fileMenu.setText("Gestion");

		openMenuItem.setMnemonic('o');
		openMenuItem.setText("Gestion User");
		openMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				openMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(openMenuItem);

		exitMenuItem.setMnemonic('x');
		exitMenuItem.setText("Exit");
		exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(exitMenuItem);

		menuBar.add(fileMenu);

		setJMenuBar(menuBar);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(243)
						.addComponent(nomUser, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(191, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup().addGap(43).addGroup(layout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 43,
												GroupLayout.PREFERRED_SIZE))
								.addGap(29)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(marque, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 120,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(imei, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 120,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(Creates, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(Updates, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(Deletes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(jButton4, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
								.addGap(60))
						.addGroup(layout.createSequentialGroup()
								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 672, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(37, Short.MAX_VALUE)))));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addGap(21).addComponent(nomUser).addGap(35)
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(Creates).addGap(14).addComponent(Updates)
								.addGap(17).addComponent(Deletes).addGap(18).addComponent(jButton4))
						.addGroup(layout.createSequentialGroup().addComponent(jLabel1).addGap(17)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel2)
										.addComponent(imei, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup()
								.addComponent(marque, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 41, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE).addGap(19)));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>

	private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

	private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Swing swing = new Swing();
		swing.setVisible(true);
		this.setVisible(false);
	}

	private void CreatesMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
	}

	private void CreatesActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		if (marque.getText() == null || imei.getText() == null) {
			JOptionPane.showMessageDialog(null, "Veuillez Remplir tout les champs");
		} else {
			sr.create(
					new Smartphone(Integer.parseInt(imei.getText()), marque.getText().toString(), ur.findById(userid)));
			model.setRowCount(0);
			loadTable();
			JOptionPane.showMessageDialog(null, "Smartphone associ? a l'utilisateur avec succes");
		}
	}

	private void smartphoneTableMousePressed(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		int row = smartphoneTable.getSelectedRow();
		id = (Integer) model.getValueAt(row, 0);
		marque.setText(model.getValueAt(row, 1).toString());
		imei.setText(model.getValueAt(row, 2).toString());
	}

	private void DeletesActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		if (marque.getText() == null || imei.getText() == null) {
			JOptionPane.showMessageDialog(null, "Veuillez selectionner un Smartphone");
		} else {
			int dialogResult = JOptionPane.showConfirmDialog(null, "Voulez vous supprimer ce Smartphone ?", "Warning",
					JOptionPane.YES_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {
				sm.setId(id);
				sr.delete(sm);
				model.setRowCount(0);
				loadTable();
				marque.setText(null);
				imei.setText(null);
				JOptionPane.showMessageDialog(null, "Smartphone supprim? avec succes");
			}
		}
	}

	private void UpdatesActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		if (marque.getText() == null || imei.getText() == null) {
			JOptionPane.showMessageDialog(null, "Veuillez selectionner un Smartphone");
		} else {
			sm = new Smartphone(Integer.parseInt(imei.getText()), marque.getText().toString(), ur.findById(userid));
			sm.setId(id);
			sr.update(sm);
			model.setRowCount(0);
			loadTable();
			marque.setText(null);
			imei.setText(null);
			JOptionPane.showMessageDialog(null, "Smartphone modifi? avec succes");
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
			java.util.logging.Logger.getLogger(DetailUser.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(DetailUser.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(DetailUser.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(DetailUser.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new DetailUser().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton Creates;
	private javax.swing.JButton Deletes;
	private javax.swing.JButton Updates;
	private javax.swing.JMenuItem exitMenuItem;
	private javax.swing.JMenu fileMenu;
	private javax.swing.JTextField imei;
	private javax.swing.JButton jButton4;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextField marque;
	private javax.swing.JMenuBar menuBar;
	private javax.swing.JLabel nomUser;
	private javax.swing.JMenuItem openMenuItem;
	private javax.swing.JTable smartphoneTable;
	// End of variables declaration

}
