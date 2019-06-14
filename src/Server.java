import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements Interface,Serializable
{
      
	private static final long serialVersionUID = 4376149574188519279L;
	private Partie game;
	private int lobby, IDPartie, nombrejoueurs, counter, playersflottant, scoreflottant;
	private ArrayList<Joueur> listejoueurs;
	private ArrayList<Partie> parties;
	private ArrayList<Integer> lobbies;
	
	
    public Server() throws RemoteException 
    {
    	super();
    	this.lobby = 0;
    	this.counter = 0;
    	this.IDPartie = 0;
    	this.parties = new ArrayList<Partie>();
    	this.listejoueurs = new ArrayList<Joueur>();
    	this.playersflottant = 0;
    	this.lobbies = new ArrayList<Integer>();
    }
        
    
    public static void main(String args[]) 
    {
        try 
        {
        	Server obj = new Server();
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("localhost", obj);
            System.err.println("Server ready");
        } 
        
        catch (Exception e) 
        {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
    
    public synchronized int lobby() // pour placer un joueur en attente
    {
    	this.lobbies.add(this.nombrejoueurs);
    	while (this.counter < this.nombrejoueurs)
        {
            try 
            {
                Thread.sleep(1000);
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
        this.game = new Partie(this.listejoueurs);
        this.parties.add(this.game);
        this.game.setIDPartie(this.IDPartie);
        this.IDPartie++;
        this.lobby++;
        this.counter = 0;
        return this.IDPartie - 1;
    }
     
    public int addJoueur(String pseudo) 
	{
		if(this.counter < this.nombrejoueurs) 
		{
			this.listejoueurs.add(new Joueur(pseudo));
			this.counter++;
			return (this.counter - 1);
		}
		else 
		{
			return -1;
		}
	}
	
    public synchronized boolean resetLobby()
    {
        IDPartie++;
        lobby=0;
        return true;
    }
    
    public void setScoreFlottant(int ss) 
    {
    	this.scoreflottant = ss;
    }
    
    public int getScoreFlottant() 
    {
    	return this.scoreflottant;
    }
    
    
    public int getIDPartie() 
    {
    	return this.IDPartie;
    }
    
    public int getLobby(int n) 
    {
    	return this.lobbies.get(n);
    }
    
    public int getNbrLobby() 
    {
    	return this.lobbies.size();
    }
    
    public Partie getPartie(int id) 
    {
    	return this.parties.get(0);
    }
    
    public int getNombreJoueurs()
    {
    	return this.nombrejoueurs;
    }
    
	public void setNombreJoueurs(int nombrej) 
	{
		this.nombrejoueurs = nombrej;
	}

    public int getLobbySize() 
    {
    	return this.counter;
    }

	@Override
	public void setScore(int nombre, int id, int idpartie) throws RemoteException 
	{
		Partie partie = this.parties.get(idpartie);
		Joueur player = partie.getJoueur(id, idpartie);
		player.setScore(nombre, id, idpartie);
		partie.setJoueur(id, player, idpartie);
		this.parties.set(idpartie, partie);
	}
	
	@Override
	public int getScore(int id, int idp) 
	{
		Partie jeu = this.parties.get(idp);
		Joueur lej = jeu.getJoueur(id, idp);
		return lej.getScore(id, idp);
	}
	
	@Override
	public String[] ScoreAtteint(int qui, int idp) throws RemoteException 
	{
		return this.parties.get(idp).ScoreAtteint(qui, idp);
	}

	@Override
	public Piece[] PoolPieces(int id, int idp) throws RemoteException 
	{
		return this.parties.get(idp).PoolPieces(id, idp);
	}

	@Override
	public boolean PoserPiece(int ligne, int colonne, byte[][] forme, String nom, int id, int idp) throws RemoteException 
	{
		Partie partie = this.parties.get(idp);
		Grille lagrille = partie.getGrille(id, idp);
		boolean retour = lagrille.PoserPiece(ligne, colonne, forme, nom, id, idp);
		this.setGrille(id, lagrille, idp);
		return retour;
	}

	@Override
	public ArrayList<ArrayList<Integer>> Check(int id, int idp) throws RemoteException 
	{
		Partie partie = this.parties.get(idp);
		Grille lagrille = partie.getGrille(id, idp);
		ArrayList<ArrayList<Integer>> retour = lagrille.Check(id, idp);
		this.setGrille(id, lagrille, idp);
		return retour;
	}

	@Override
	public String getPseudo(int id, int idp) throws RemoteException {
		return this.parties.get(idp).getJoueur(id, idp).getPseudo(id, idp);
	}

	@Override
	public void setScoreLimite(int numero, int idp) throws RemoteException 
	{
		if(this.parties.size() > 0) 
		{
			Partie partie = this.parties.get(idp);
			partie.setScoreLimite(numero, idp);
			this.parties.set(idp, partie);
		}
	}

	@Override
	public Joueur getJoueur(int id, int idp) throws RemoteException 
	{
		return this.parties.get(idp).getJoueur(id, idp);
	}

	@Override
	public int getRang(int id, int idp) throws RemoteException 
	{
		return this.parties.get(idp).getJoueur(id, idp).getRang(id);
	}

	@Override
	public void setRang(int id, int idp) throws RemoteException 
	{
		Partie partie = this.parties.get(idp);
		Joueur player = partie.getJoueur(id, idp);
		player.setRang(id, idp);
		partie.setJoueur(id, player, idp);
		this.parties.set(idp, partie);
	}

	@Override
	public Grille getGrille(int id, int idp) throws RemoteException 
	{
		return this.parties.get(idp).getGrille(id, idp);
	}

	@Override
	public void setGrille(int id, Grille grid, int idp) throws RemoteException 
	{
		Partie partie = this.parties.get(idp);
		partie.setGrille(id, grid, idp);
		this.parties.set(idp, partie);
	}

	@Override
	public Piece[][] getPiecesPartie(int idp) throws RemoteException 
	{
		return this.parties.get(idp).getPiecesPartie(idp);
	}

	@Override
	public int getNbrJoueurs(int idp) throws RemoteException 
	{
		return this.parties.get(idp).getNbrJoueurs(idp);
	}

	@Override
	public int getScoreLimite(int i, int idp) throws RemoteException 
	{
		return this.parties.get(idp).getScoreLimite(i);
	}

	@Override
	public String getState(int id, int idp) throws RemoteException {
		return this.parties.get(idp).getJoueur(id, idp).getState(id, idp);
	}

	@Override
	public String getWin(int id, int idp) throws RemoteException {
		return this.parties.get(idp).getJoueur(id, idp).getState(id, idp);
	}


	@Override
	public void setState(String ee, int id, int idp) throws RemoteException {
		Partie game = this.parties.get(idp);
		Joueur player = game.getJoueur(id, idp);
		player.setState(ee, id, idp);
		game.setJoueur(id, player, idp);
		this.parties.set(idp, game);
	}

	@Override
	public ArrayList<Joueur> getJoueurs(int idp) throws RemoteException {
		return this.parties.get(idp).getJoueurs(idp);
	}

	
}