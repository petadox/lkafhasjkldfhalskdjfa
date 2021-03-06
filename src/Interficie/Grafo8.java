package Interficie;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JToggleButton;


public class Grafo8 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grafo8 frame = new Grafo8();
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
	public Grafo8() {
		setTitle("Gestion de Grafos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton(new ImageIcon("next.jpg"));
		button.setBounds(293, 215, 131, 31);
		contentPane.add(button);
		
		JToggleButton tglbtnCrearGrafo = new JToggleButton("Importar Grafo");
		tglbtnCrearGrafo.setBounds(113, 43, 121, 23);
		contentPane.add(tglbtnCrearGrafo);
		
		JToggleButton tglbtnGuardarGrafo = new JToggleButton("Guardar grafo");
		tglbtnGuardarGrafo.setBounds(113, 96, 121, 23);
		contentPane.add(tglbtnGuardarGrafo);
		
		JToggleButton tglbtnCargarGrafo = new JToggleButton("Cargar grafo");
		tglbtnCargarGrafo.setBounds(113, 149, 121, 23);
		contentPane.add(tglbtnCargarGrafo);
		
		JToggleButton tglbtnBorrarGrafo = new JToggleButton("Borrar Grafo");
		tglbtnBorrarGrafo.setBounds(113, 202, 121, 23);
		contentPane.add(tglbtnBorrarGrafo);
		
		tglbtnCargarGrafo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnGuardarGrafo.isSelected() ) tglbtnGuardarGrafo.setSelected(false); ;
				if(tglbtnCrearGrafo.isSelected()) tglbtnCrearGrafo.setSelected(false);
				if(tglbtnBorrarGrafo.isSelected()) tglbtnBorrarGrafo.setSelected(false);
				}
			});
		
		tglbtnCrearGrafo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnGuardarGrafo.isSelected() ) tglbtnGuardarGrafo.setSelected(false); ;
				if(tglbtnCargarGrafo.isSelected()) tglbtnCargarGrafo.setSelected(false);
				if(tglbtnBorrarGrafo.isSelected()) tglbtnBorrarGrafo.setSelected(false);
				}
			});
		
		tglbtnGuardarGrafo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnCrearGrafo.isSelected() ) tglbtnCrearGrafo.setSelected(false); ;
				if(tglbtnCargarGrafo.isSelected()) tglbtnCargarGrafo.setSelected(false);
				if(tglbtnBorrarGrafo.isSelected()) tglbtnBorrarGrafo.setSelected(false);
				}
			});
		
		tglbtnBorrarGrafo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnGuardarGrafo.isSelected() ) tglbtnGuardarGrafo.setSelected(false); ;
				if(tglbtnCargarGrafo.isSelected()) tglbtnCargarGrafo.setSelected(false);
				if(tglbtnCrearGrafo.isSelected()) tglbtnCrearGrafo.setSelected(false);
				}
			});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser directorio = new JFileChooser();
				JFileChooser absoluto = new JFileChooser();
				directorio.setCurrentDirectory(new File(System.getProperty("user.dir")+"\\BaseDades\\"));
				absoluto.setCurrentDirectory(new File(System.getProperty("user.dir")+"\\BaseDades\\Graphs\\"));
				directorio.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if(tglbtnCrearGrafo.isSelected()) {
					int result = directorio.showOpenDialog(directorio);
					if (result == JFileChooser.CANCEL_OPTION) {
						ControladorInterficie.VistaGrafo8();
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
				else if(tglbtnCargarGrafo.isSelected()) {
					int result = absoluto.showOpenDialog(absoluto);
					if (result == JFileChooser.CANCEL_OPTION) {
						ControladorInterficie.VistaGrafo8();
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
				else if(tglbtnGuardarGrafo.isSelected()) {
					int result = absoluto.showSaveDialog(absoluto);
					if (result == JFileChooser.CANCEL_OPTION) {
						ControladorInterficie.VistaGrafo8();
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
				}
				else if(tglbtnBorrarGrafo.isSelected()) {
					int result = absoluto.showOpenDialog(absoluto);
					if (result == JFileChooser.CANCEL_OPTION) {
						ControladorInterficie.VistaGrafo8();
						dispose();
					}
					else {
						String path = absoluto.getSelectedFile().getAbsolutePath();
						try {
							ControladorInterficie.deleteGraph(path);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						ControladorInterficie.VistaMenu2();
						dispose();
					}
				}
				else {
					JOptionPane.showOptionDialog(null, "Has de seleccionar alguna opcion", "", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null,new Object[] {} , JOptionPane.NO_OPTION);
				}
			}
		});
	}
}
