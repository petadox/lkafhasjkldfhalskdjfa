package Interficie;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
@SuppressWarnings("serial")
public class AfegirCamp12 extends JFrame {
	private JPanel contentPane;
	private JTextField txtNomCamp;
	private JTextField txtDescripcioCamp;
	private JTextField txtPath;
	private JTextField txtQuantitat;
	private JTextField txtMnim;
	private JTextField textNomPlant;
	private JTextField textDescPlant;
	private JTextField textPath;
	private JTextField textQuant;
	private JTextField textMin;
	private JButton btnHelpNP;
	private JButton btnHelpDP;
	private JButton btnHelpP;
	private JButton btnHelpQ;
	private JButton btnHelpM;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfegirCamp12 frame = new AfegirCamp12();
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
	public AfegirCamp12() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNomCamp = new JTextField();
		txtNomCamp.setEditable(false);
		txtNomCamp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNomCamp.setText("Nom Camp:");
		txtNomCamp.setBounds(10, 29, 131, 31);
		contentPane.add(txtNomCamp);
		txtNomCamp.setColumns(10);
		
		txtDescripcioCamp = new JTextField();
		txtDescripcioCamp.setEditable(false);
		txtDescripcioCamp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDescripcioCamp.setText("Descripci\u00F3 Camp:");
		txtDescripcioCamp.setBounds(10, 71, 131, 31);
		contentPane.add(txtDescripcioCamp);
		txtDescripcioCamp.setColumns(10);
		
		txtPath = new JTextField();
		txtPath.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPath.setEditable(false);
		txtPath.setText("Path:");
		txtPath.setBounds(10, 113, 131, 31);
		contentPane.add(txtPath);
		txtPath.setColumns(10);
		
		txtQuantitat = new JTextField();
		txtQuantitat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtQuantitat.setEditable(false);
		txtQuantitat.setText("Quantitat:");
		txtQuantitat.setBounds(10, 155, 131, 31);
		contentPane.add(txtQuantitat);
		txtQuantitat.setColumns(10);
		
		txtMnim = new JTextField();
		txtMnim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMnim.setEditable(false);
		txtMnim.setText("M\u00EDnim:");
		txtMnim.setBounds(10, 197, 131, 31);
		contentPane.add(txtMnim);
		txtMnim.setColumns(10);
		
		textNomPlant = new JTextField();
		textNomPlant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNomPlant.setBounds(139, 29, 203, 31);
		contentPane.add(textNomPlant);
		textNomPlant.setColumns(10);
		
		textDescPlant = new JTextField();
		textDescPlant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textDescPlant.setBounds(139, 71, 203, 31);
		contentPane.add(textDescPlant);
		textDescPlant.setColumns(10);
		
		textPath = new JTextField();
		textPath.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPath.setBounds(139, 113, 203, 31);
		contentPane.add(textPath);
		textPath.setColumns(10);
		
		textQuant = new JTextField();
		textQuant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textQuant.setBounds(139, 155, 102, 31);
		contentPane.add(textQuant);
		textQuant.setColumns(10);
		
		textMin = new JTextField();
		textMin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textMin.setBounds(139, 197, 102, 31);
		contentPane.add(textMin);
		textMin.setColumns(10);
		
		JButton btnNext = new JButton(new ImageIcon("next.jpg"));
		btnNext.setBounds(293, 215, 131, 31);
		contentPane.add(btnNext);
		
		btnHelpNP = new JButton("?");
		btnHelpNP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Escriu el nom de la Plantilla.");
			}
		});
		btnHelpNP.setBounds(352, 29, 37, 31);
		contentPane.add(btnHelpNP);
		
		btnHelpDP = new JButton("?");
		btnHelpDP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "[Opcional] Escrigui una descripci� per a la Plantilla.");
			}
		});
		btnHelpDP.setBounds(352, 71, 37, 31);
		contentPane.add(btnHelpDP);
		
		btnHelpP = new JButton("?");
		btnHelpP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Escrigui el Path de la Plantilla. P = paper, A = autor, C = confer�ncia i T = terme.");
			}
		});
		btnHelpP.setBounds(352, 113, 37, 31);
		contentPane.add(btnHelpP);
		
		btnHelpQ = new JButton("?");
		btnHelpQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "introdueix un valor entre 0 i 1 o -1 si vol usar l'opci� 'M�nim'.");
			}
		});
		btnHelpQ.setBounds(251, 155, 37, 31);
		contentPane.add(btnHelpQ);
		
		btnHelpM = new JButton("?");
		btnHelpM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "introdueix quants elements vols que es mostrin o -1 si vol usar l'opci� 'Quantitat'.");
			}
		});
		ArrayList<String> s = new ArrayList<String>();
		btnHelpM.setBounds(251, 197, 37, 31);
		contentPane.add(btnHelpM);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textNomPlant.getText().isEmpty())JOptionPane.showMessageDialog(null,"Introdueix un nom");
				else if(textDescPlant.getText().isEmpty())JOptionPane.showMessageDialog(null,"Introdueix una descripcio");
				else if(textPath.getText().isEmpty())JOptionPane.showMessageDialog(null,"Introdueix un path valid");
				else if(textQuant.getText().isEmpty())JOptionPane.showMessageDialog(null,"Introdueix una quantitat v�lida");
				else if(textMin.getText().isEmpty())JOptionPane.showMessageDialog(null,"Introdueix un m�nim valid");
				else{
					if(ControladorInterficie.pathValid(textPath.getText())){
						if(ControladorInterficie.quantValid(textQuant.getText())){
							if(ControladorInterficie.minValid(textMin.getText())){
								double auxMin = Double.parseDouble(textMin.getText());
								double auxQuant = Double.parseDouble(textQuant.getText());
								if(auxMin == -1 && auxQuant == -1) JOptionPane.showMessageDialog(null,"M�nim o Quant han de tenir un valor diferent a -1");
								else if(auxMin > -1 && auxQuant > -1)JOptionPane.showMessageDialog(null,"M�nim o Quant han de tenir un valor igual a -1");
								else{
									s.add(textDescPlant.getText());
									s.add(textNomPlant.getText());
									s.add(textPath.getText());
									s.add(textQuant.getText());
									s.add(textMin.getText());
									ControladorInterficie.setCamp(s);
									JOptionPane.showMessageDialog(null,"Camp afegit!");
									dispose();
								}
							}
							else JOptionPane.showMessageDialog(null,"M�nim no v�lid"); 
						}
						else JOptionPane.showMessageDialog(null,"Quantitat no v�lid"); 
					}
					else JOptionPane.showMessageDialog(null,"Path no v�lid"); 
				}
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
