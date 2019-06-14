import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
 
public interface Interface extends Remote
{
	
	Piece[] PoolPieces(int id, int idp) throws RemoteException;
	boolean PoserPiece(int ligne, int colonne, byte[][] forme, String nom, int id, int idp) throws RemoteException;
	ArrayList<ArrayList<Integer>> Check(int id, int idp) throws RemoteException;
	String getPseudo(int id, int idp) throws RemoteException; 
	void setScoreLimite(int numero, int idp) throws RemoteException;
	Joueur getJoueur(int id, int idp) throws RemoteException;
	int getRang(int id, int idp) throws RemoteException;
	void setRang(int id, int idp) throws RemoteException;
	Grille getGrille(int id, int idp) throws RemoteException;
	void setGrille(int id, Grille grid, int idp) throws RemoteException;
	Piece[][] getPiecesPartie(int idp) throws RemoteException;
	int getNbrJoueurs(int idp) throws RemoteException;
	int getScoreLimite(int i, int idp) throws RemoteException;
	String getState(int id, int idp) throws RemoteException;
	void setState(String ee, int id, int idp) throws RemoteException;
	ArrayList<Joueur> getJoueurs(int idp) throws RemoteException;
	int addJoueur(String pseudo) throws RemoteException;

	int getScore(int qui, int idp) throws RemoteException;
	void setScore(int nombre, int id, int idpartie) throws RemoteException;
	String[] ScoreAtteint(int id, int idp) throws RemoteException;
	
	int getLobbySize() throws RemoteException;
	boolean resetLobby() throws RemoteException;
	void setNombreJoueurs(int nombrej) throws RemoteException;
	int lobby() throws RemoteException;
	Partie getPartie(int id) throws RemoteException;
	int getNombreJoueurs() throws RemoteException;
	int getNbrLobby() throws RemoteException;
	int getLobby(int n) throws RemoteException;
	int getIDPartie() throws RemoteException;
	void setScoreFlottant(int ss) throws RemoteException;
	int getScoreFlottant() throws RemoteException;
	String getWin(int id, int idp) throws RemoteException;
	
}