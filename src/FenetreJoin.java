import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreJoin extends JFrame implements ActionListener{
	

	private static final long serialVersionUID = -4230001330432128894L;
	private String pseudo;
	private Interface interf;
	private JPanel boutonspane;
	private Partie game;
	private int num,players,scoremax,ret,faitchier,nbrparties;
	
	
	public FenetreJoin(String userName, Interface ecran) throws RemoteException
	{
		this.pseudo = userName;
		this.interf = ecran;
		this.nbrparties = this.interf.getLobbySize();
		this.setLayout(new BorderLayout());
		this.boutonspane = new JPanel();
		this.boutonspane.setLayout(new GridLayout(this.nbrparties,1));
		
		System.out.println("il y a "+this.nbrparties+" parties en cours");
		System.out.println(this.interf.getNombreJoueurs()+" joueurs");
		
		for(int i = 0; i < this.interf.getNbrLobby(); i++) 
		{
			JButton bouton = new JButton();
			bouton.setActionCommand(""+i);
			bouton.setText(this.interf.getLobbySize()+"/"+this.interf.getLobby(i));
			bouton.addActionListener(this);
			this.boutonspane.add(bouton);
			System.out.println("une partie ajoutee");

		}
		
		this.add(this.boutonspane, BorderLayout.CENTER);
		
		JButton retour = new JButton("Retour");
		retour.addActionListener(this);
		retour.setActionCommand("RETOUR");
		this.add(retour,BorderLayout.SOUTH);
		
		//Ajout pseudo
		JPanel pseudo=new JPanel();
		JLabel ID = new JLabel(userName);
		ID.setOpaque(true);
		ID.setPreferredSize(new Dimension(75,20));
		ID.setBackground(Color.WHITE);
		pseudo.add(ID);
		this.add(pseudo, BorderLayout.NORTH);	
		//********************************
		
		this.setTitle("1010 Join");
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String etiquette = arg0.getActionCommand();
		
		if(etiquette == "RETOUR") 
		{
			try 
			{
				new FenetreMenu(this.pseudo, this.interf);
			} 
			catch (RemoteException e) 
			{
				e.printStackTrace();
			}
			this.dispose();
		}
		
		if(etiquette.length() <= 2) 
		{
			char nume = etiquette.charAt(0);
			String numstring = nume + "";
			this.num = Integer.parseInt(numstring);
			
			try 
			{
				this.players = this.interf.getNombreJoueurs();
				this.scoremax = this.interf.getScoreFlottant();
				this.ret = this.interf.addJoueur(this.pseudo);
				System.out.println("votre id est : "+this.ret);
			} 
			catch (RemoteException e)
			{
				e.printStackTrace();
			}
			
			try {
				this.faitchier = this.interf.getLobbySize();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
			while(this.faitchier != this.players) 
			{
				try 
				{
					this.faitchier = this.interf.getLobbySize();
				} 
				catch (RemoteException e) 
				{
					e.printStackTrace();
				}
			}
			
			try 
			{
			    Thread.sleep(1500);            
			}
			catch(InterruptedException ex) 
			{
			    Thread.currentThread().interrupt();
			}
			
			try {
				new TEST(this.interf, this.pseudo, this.players, this.scoremax, this.num, this.ret);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
			System.out.println("new fen ok");
			
			
			this.dispose();
		}
		
	}
}
