package Interficie;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Excepcions.FicheroNoExiste;
import domini.PathException;
public class SLPerfiles9 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SLPerfiles9 frame = new SLPerfiles9();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws FicheroNoExiste 
	 */
	public SLPerfiles9() throws FicheroNoExiste, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFileChooser absoluto = new JFileChooser();
		absoluto.setCurrentDirectory(new File("C:\\Users\\Albert Ripol\\Desktop\\PracticaProp\\ProjectePROP\\BaseDades"));

		int result = absoluto.showOpenDialog(absoluto);
		String ruta = "";
		if (result == JFileChooser.CANCEL_OPTION) {
			ControladorInterficie.VistaElementos3();
			dispose();
		}
		else { 
				ruta = absoluto.getSelectedFile().getAbsolutePath();
			
			if(ControladorInterficie.getMenu2() == "Consultar" || 
			   ControladorInterficie.getMenu2() == "Modificar"){
				   ControladorInterficie.loadP(ruta);
				   
				   ControladorInterficie.VistaConsPerf15();
				   dispose();
			}
			else if(ControladorInterficie.getMenu2() == "Borrar"){
				ControladorInterficie.deleteP(ruta);
			}
		}
		dispose();
		
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