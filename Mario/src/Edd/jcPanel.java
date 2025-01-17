package Edd;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class jcPanel extends JPanel implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int index = 1;
    //Nos sirve para almacenar a los objetos creados
    private Map nota = new HashMap();

    public jcPanel()
    {
        this.setSize(1000, 1000);
        this.setVisible(true);
        this.setBorder(BorderFactory.createLineBorder( Color.BLACK ));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.addMouseListener(new mouse());
    }

    public void Mi_Componente(String path,int id,String nombre)
    {        
    	
        URL url = this.getClass().getResource(path);  
        ImageIcon icon = new ImageIcon(url); 
        //instancia nueva a componente
        jpComponente jpc = new jpComponente(index);
        jpc.btn.addActionListener(this);//escucha eventos
        jpc.btn2.addActionListener(this);
        jpc.label1.setIcon(icon);
        jpc.label2.setText(""+id);
        jpc.nombrepersonaje.setText(nombre);
        this.add(jpc);//se a�ade al jpanel
        this.validate();
        //se a�ade al MAP
        this.nota.put("key_" + index, jpc );
        this.nota.put("ley2_" + index, jpc );
        //se incrementa contador de componentes
        index++;
    }

    public void actionPerformed(ActionEvent e) {
        //se obtiene el comando ejecutado
        String comando = e.getActionCommand();
        //se recorre el MAP
        Iterator it = nota.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            //se obtiene el KEY -> identificador unico
            String itm = entry.getKey().toString();
            //si comando de componente es igual a comando pulsado
            if( itm.equals(comando))
            {
            	if(itm.charAt(0)=='k'){
            		//se recupera el contenido del JTextfield
                	String name = ((jpComponente) entry.getValue()).nombrepersonaje.getText();
                	String name2 = ((jpComponente) entry.getValue()).label2.getText();
                	Inicio.BorrarPersonaje(Integer.parseInt(name2));
                	Inicio.mi_panel.removeAll();
                    Inicio.mi_panel.repaint();
                    //mostramos resultado
                    JOptionPane.showMessageDialog(null, "Se Ha eliminado: " + name+"presione para actualizar");
            	}else{
            		String name = ((jpComponente) entry.getValue()).nombrepersonaje.getText();
            		String j=name;
                	String name2 = ((jpComponente) entry.getValue()).label2.getText();
                	Inicio.ModificarPersonaje(name, Integer.parseInt(name2));
                	JOptionPane.showMessageDialog(null, "Se ha modificado el nombre a : " + name);
            	}
              
            }
        }
    }
    
    public class mouse implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			Inicio.actualizar();
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
    	
    }

}