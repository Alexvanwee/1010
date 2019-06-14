import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreFin extends JFrame
{

	private String state;
	private JPanel bas;
	private ImageIcon imagefin;
	
	public FenetreFin(String etat)
	{

		this.state = etat;
		this.bas = new JPanel();
		JLabel bas = new JLabel();
		
		if(this.state.startsWith("g")) 
		{
			this.imagefin = new ImageIcon(this.getClass().getResource("gagne.png"));
			bas.setIcon(imagefin);
		}
		else 
		{
			this.imagefin = new ImageIcon(this.getClass().getResource("perdu.png"));
			bas.setIcon(imagefin);
		}
		
		this.bas.add(bas);
		this.add(this.bas);
		this.setTitle("1010");
	    this.setSize(1066, 600);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setVisible(true); 
	
	}
	
	
	
	
	
	
}
