package Interficie;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Excepcions.FicheroNoExiste;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
@SuppressWarnings("serial")

public class Plantilla11 extends JFrame {
	private JPanel contentPane;
	private boolean usat = false;
	private JTextField txtNom;
	private JTextField txtTipus;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Plantilla11 frame = new Plantilla11();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Plantilla11() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNom = new JTextField();
		txtNom.setHorizontalAlignment(SwingConstants.CENTER);
		txtNom.setEditable(false);
		txtNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNom.setText("Nom:");
		txtNom.setBounds(55, 34, 81, 31);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtTipus = new JTextField();
		txtTipus.setHorizontalAlignment(SwingConstants.CENTER);
		txtTipus.setEditable(false);
		txtTipus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTipus.setText("Tipus:");
		txtTipus.setBounds(55, 96, 81, 31);
		contentPane.add(txtTipus);
		txtTipus.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(134, 34, 250, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setBounds(134, 96, 250, 31);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAfegirCamp = new JButton("Afegir Camp");
		btnAfegirCamp.setBounds(134, 153, 178, 48);
		contentPane.add(btnAfegirCamp);
		btnAfegirCamp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty()) JOptionPane.showMessageDialog(null,"Escrigui un nom per a la plantilla.");
				else if(textField_1.getText().isEmpty()) JOptionPane.showMessageDialog(null,"Escrigui un tipus per a la plantilla.");
				else if(ControladorInterficie.tipusValid(textField_1.getText()) == false) JOptionPane.showMessageDialog(null,"Escrigui un tipus de plantilla valid.");
				else{
					ControladorInterficie.setTipusPlant11(textField_1.getText());
					usat = true;
					ControladorInterficie.VistaAfegirCamp12();
				}
			}
		});
		
		JButton btnNext = new JButton(new ImageIcon("next.jpg"));
		btnNext.setBounds(293, 215, 131, 31);
		contentPane.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textField.getText();
				if(s.isEmpty())JOptionPane.showMessageDialog(null,"Introdueix un nom.");
				else{
					s = textField_1.getText();
					boolean bo = false;
					if(s.equals("Autor"))bo = true;
					if(s.equals("Paper"))bo = true;
					if(s.equals("Conferencia"))bo = true;
					if(s.equals("Terme"))bo = true;
					if(bo == false)JOptionPane.showMessageDialog(null,"Tipus no v�l�lid.");
					else{
						ControladorInterficie.setNomPlant11(textField.getText());
						ControladorInterficie.setTipusPlant11(textField_1.getText());
						ControladorInterficie.setEntidades4(textField_1.getText());
						if(!usat) ControladorInterficie.borrarCamp12();
						try {
							ControladorInterficie.cargarPlantilla();
							ControladorInterficie.VistaConsPlant17();
						} catch (NumberFormatException | FicheroNoExiste | IOException e1) {
							e1.printStackTrace();
						}
						dispose();
					}
				}
			}
		});
		JButton btnBack = new JButton(new ImageIcon("back.jpg"));
		btnBack.setBounds(10, 215, 131, 31);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ControladorInterficie.setNomPlant11((""));
				ControladorInterficie.setTipusPlant11("");
				ControladorInterficie.borrarCamp12();
				ControladorInterficie.VistaElementos3();
				dispose();
			}
			
		});
		
		JButton btnNuevoGrafo = new JButton("Nuevo Grafo");
		btnNuevoGrafo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser absoluto = new JFileChooser();
				JFileChooser directorio = new JFileChooser();
				directorio.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				absoluto.setCurrentDirectory(new File(System.getProperty("user.dir")+"\\BaseDades\\"));
				directorio.setCurrentDirectory(new File(System.getProperty("user.dir")+"\\BaseDades\\"));
				int res = JOptionPane.showConfirmDialog(null, "Si cambias de grafo, perder�s todos los datos �Quieres guardar los cambios que has hecho hasta ahora?");
				if (res == 0) {
					//Si guarda
					int result = absoluto.showSaveDialog(absoluto);
					if (result == JFileChooser.CANCEL_OPTION) {
						ControladorInterficie.VistaElementos3();
						dispose();
					}
					else {
						String path = absoluto.getSelectedFile().getAbsolutePath();
						try {
							ControladorInterficie.saveGraph(path);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						ControladorInterficie.VistaMenu2();
						dispose();
					}
					int cargaroimportar = JOptionPane.showOptionDialog(null, "�Quieres cargar o importar un grafo?", "Cargar/Importar", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null,new Object[] {"Importar","Cargar"} , JOptionPane.NO_OPTION);
					//usuario da a importar
					if (cargaroimportar == 0) {
						result = directorio.showOpenDialog(absoluto);
						if (result == JFileChooser.CANCEL_OPTION) {
							ControladorInterficie.VistaElementos3();
							dispose();
						}
						else {
							String path = directorio.getSelectedFile().getAbsolutePath();
							try {
								ControladorInterficie.importaGraph(path);
								} catch (IOException e1) {
								e1.printStackTrace();
							}
							ControladorInterficie.VistaMenu2();
							dispose();
						}
					}
					//cargar
					else {
						result = absoluto.showOpenDialog(absoluto);
						if (result == JFileChooser.CANCEL_OPTION) {
							ControladorInterficie.VistaElementos3();
							dispose();
						}
						else {
							String path = absoluto.getSelectedFile().getAbsolutePath();
							try {
								ControladorInterficie.carregaGraph(path);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							ControladorInterficie.VistaMenu2();
							dispose();	
						}
					}
				}
				else if (res == 1) {
					int cargaroimportar = JOptionPane.showOptionDialog(null, "�Quieres cargar o importar un grafo?", "Cargar/Importar", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null,new Object[] {"Importar","Cargar"} , JOptionPane.NO_OPTION);
					if (cargaroimportar == 0) {
						int result = directorio.showOpenDialog(absoluto);
						if (result == JFileChooser.CANCEL_OPTION) {
							ControladorInterficie.VistaElementos3();
							dispose();
						}
						else {
							String path = directorio.getSelectedFile().getAbsolutePath();
							try {
								ControladorInterficie.importaGraph(path);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							ControladorInterficie.VistaMenu2();
							dispose();
						}
					}
					//cargar
					else {
						int result = absoluto.showOpenDialog(absoluto);
						if (result == JFileChooser.CANCEL_OPTION) {
							ControladorInterficie.VistaElementos3();
							dispose();
						}
						else {
							String path = absoluto.getSelectedFile().getAbsolutePath();
							try {
								ControladorInterficie.carregaGraph(path);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							ControladorInterficie.VistaMenu2();
							dispose();
						}
					}
				}
			}
		});
		btnNuevoGrafo.setFont(new Font("Arial", Font.PLAIN, 8));
		btnNuevoGrafo.setBounds(0, 0, 79, 31);
		contentPane.add(btnNuevoGrafo);
	}
}