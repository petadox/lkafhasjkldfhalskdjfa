package Interficie;
//@author Eduard Maestro
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Excepcions.FicheroNoExiste;
import Excepcions.FicheroYaExistente;
import javax.swing.JButton;
import java.awt.List;
@SuppressWarnings("serial")
public class ConsPlant17 extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsPlant17 frame = new ConsPlant17();
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
	 * @throws NumberFormatException 
	 */
	public ConsPlant17() throws NumberFormatException, FicheroNoExiste, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGuardarYSalir = new JButton("Guardar y salir");
		btnGuardarYSalir.setBounds(245, 24, 130, 41);
		contentPane.add(btnGuardarYSalir);
		
		JButton btnModificarPerfil = new JButton("Modificar Plantilla");
		btnModificarPerfil.setBounds(245, 76, 130, 41);
		contentPane.add(btnModificarPerfil);
		
		JButton btnGenerarPerfil = new JButton("Generar Perfil");
		btnGenerarPerfil.setBounds(245, 128, 130, 41);
		contentPane.add(btnGenerarPerfil);
		
		JButton btnBorrarPlantilla = new JButton("Borrar Plantilla");
		btnBorrarPlantilla.setBounds(245, 180, 130, 41);
		contentPane.add(btnBorrarPlantilla);
		
		List list = new List();
		list.setBounds(43, 24, 150, 195);
		contentPane.add(list);
		
		
		ControladorInterficie.impPlantilla17();
		list.add(ControladorInterficie.getNomPlantilla());
		list.add(ControladorInterficie.getTipusPlantilla());
		ArrayList<ArrayList<String>> todaPlantilla = new ArrayList<ArrayList<String>>();
		todaPlantilla = ControladorInterficie.getCamp12();
		for (int i = 0; i < todaPlantilla.size(); ++i ) {
			list.add("");
			for (int j = 0; j < 5; ++j) {
				list.add(todaPlantilla.get(i).get(j));
			}
		}
		
		btnGuardarYSalir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					if(ControladorInterficie.getMenu2().equals("Crear")){
						ControladorInterficie.savePP();
						ControladorInterficie.borrarCamp12();
						ControladorInterficie.VistaMenu2();
						dispose();
						JOptionPane.showMessageDialog(null,"Plantilla guardada correctament");
					}
					else{
						int resp;
						String ruta = ControladorInterficie.getRutaPlant();
						String aux = "";
						for(int i=ruta.length()-1; ruta.charAt(i) != '\\'; i--){
							aux = aux+ruta.charAt(i);
						}
						String aux2 = "";
						for(int i=aux.length()-1; i>3; i--){
							aux2 = aux2+aux.charAt(i);
						}
						if(aux2.equals(ControladorInterficie.getNomPlantilla())){
							resp = JOptionPane.showConfirmDialog(null,"Vols sobreescriure la plantilla? en cas contrari dona-li un altre nom", "Alerta!", JOptionPane.YES_NO_OPTION);
							if(resp == 1){ //resp = no
								
							}
							else{ //resp = si
								ControladorInterficie.deletePP(ControladorInterficie.getRutaPlant());
								ControladorInterficie.cargarPlantilla();
								ControladorInterficie.savePP();
								ControladorInterficie.VistaMenu2();
								dispose();
							}
						}
						else{
							ControladorInterficie.savePP();
							ControladorInterficie.borrarCamp12();
							ControladorInterficie.VistaMenu2();
							dispose();
						}
					}
				} catch (IOException | FicheroNoExiste | FicheroYaExistente e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		btnModificarPerfil.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ControladorInterficie.VistaModPlantilla18();
				dispose();
				
				// ++ ModificarPlant;
				
			}
			
		});
		
		btnGenerarPerfil.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ControladorInterficie.setconsplant17("GenerarPerfil");
				ControladorInterficie.VistaSLEntidades6();
				dispose();
			}
			
			// ++ Generar Perfil;
			
		});
		
		btnBorrarPlantilla.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (ControladorInterficie.getMenu2().equals("Consultar") &&
						ControladorInterficie.getElement3().equals("Plantilla")) {
					try {
						int resp = JOptionPane.showConfirmDialog(null,"Vols eliminar la plantilla?", "Alerta!", JOptionPane.YES_NO_OPTION);
						if(resp == 1){ //resp = no
							
						}
						else{ //resp = si
							ControladorInterficie.deletePP(ControladorInterficie.getRutaPlant());
							ControladorInterficie.cargarPlantilla();
							ControladorInterficie.savePP();
							ControladorInterficie.VistaMenu2();
							dispose();
						}
						ControladorInterficie.deletePP(ControladorInterficie.getRutaPlant());
					} catch (FicheroNoExiste | IOException | FicheroYaExistente e1) {
						e1.printStackTrace();
					}
				}
				// ++ Borrar Plantilla;
			}
		});
	}
}