
package Interficie;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import Excepcions.FicheroNoExiste;
import domini.Pair;
import domini.PathException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
public class ModificarPerfil23 extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SLEntidades6 frame = new SLEntidades6();
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
	
	ArrayList<ArrayList<String>> ArrayDeCamps = new ArrayList<>();
	
	public ModificarPerfil23() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(169, 31, 226, 215);
		contentPane.add(scrollPane);
		
		JList<String> list = new JList<String>();
		scrollPane.setViewportView(list);
		
		
		JButton btnBack = new JButton(new ImageIcon("back.jpg"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ControladorInterficie.getconsplant17() != null && ControladorInterficie.getconsplant17().equals("GenerarPerfil")) {
					try {
						ControladorInterficie.VistaConsPerf15();
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
				}
				else if (ControladorInterficie.getElement3().equals("Relaciones")) ControladorInterficie.VistaEntRel7();
				else ControladorInterficie.VistaEntidades4();
				dispose();
			}
		});
		btnBack.setBounds(10, 215, 131, 31);
		contentPane.add(btnBack);
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		
		
		list.setModel(dlm);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setEditable(false);
		textField.setBounds(10, 64, 125, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(ControladorInterficie.getNomPerfil());
		
		// Aqui tengo que conseguir los datos para llenar
		
		
		ArrayList<String> ArrayDeNoms = new ArrayList<>();
		ArrayDeCamps = ControladorInterficie.getCampPle();
		ArrayDeNoms = ControladorInterficie.getNomPath();
		llenarList(ArrayDeCamps,ArrayDeNoms,dlm);
		
		ArrayList<Integer> tamaņoCadaCampo = new ArrayList<>();
		for (int i = 0; i < ArrayDeCamps.size(); ++i) {
			tamaņoCadaCampo.add(ArrayDeCamps.get(i).size());
		}
		
		
		
		
		
		MouseListener mouseListener = new MouseAdapter() {
		     public void mouseClicked(MouseEvent e) {
		             Integer index = list.locationToIndex(e.getPoint());
		             String nomEnt = dlm.getElementAt(index);
		             System.out.println(index);
		             if (nomEnt == "       ") JOptionPane.showMessageDialog(null, "No puedes cambiar eso");
		             else {
		            	 actualizaIyJ(index, ArrayDeCamps);
			             ControladorInterficie.VistaCanviarNom();
			             dispose();
		             }
		             
		             
		             
			     }
			 };
			 list.addMouseListener(mouseListener);
	}
	
	private void llenarList(ArrayList<ArrayList<String>> MatriuCamps, ArrayList<String> NomsArray, DefaultListModel list) {
		int t = MatriuCamps.size();
		for (int i = 0; i < t; ++i) {
			if (i != 0) list.addElement("       "); // Linea blanca entre tipo y tipo, tipo heheh;
			list.addElement(NomsArray.get(i));
			for (int j = 0; j < MatriuCamps.get(i).size(); ++j) {
				list.addElement(MatriuCamps.get(i).get(j));
				
			}
		}
	}
	
	private void actualizaIyJ(Integer index, ArrayList<ArrayList<String>> ArrayDeCamps) {
		Integer n = 0;
		for (Integer i = 0; i < ArrayDeCamps.size(); ++i) {
			if (n == index) {
				System.out.println("LLEGOAQUI");
				System.out.println("LLEGOAQUI");
				System.out.println("LLEGOAQUI");
				ControladorInterficie.setIPerCanviNom(i);
				ControladorInterficie.setJPerCanviNom(0);
				ControladorInterficie.setEsNom(true);
			}
			++n;
			for (Integer j = 0 ; j < ArrayDeCamps.get(i).size(); ++j) {
				if (n == index) {
					ControladorInterficie.setIPerCanviNom(i);
					ControladorInterficie.setJPerCanviNom(j);
					ControladorInterficie.setEsNom(false);
				}
				++n;
			}
			++n;
			// Espacio en blanco, necesito el ++n pero no compruebo la igualdad;
		}
		
	}
	
}