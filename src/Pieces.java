import java.io.Serializable;

public class Pieces implements Serializable{

	private static final long serialVersionUID = -3175723740860555146L;
	
	private Piece BarreH2 = new BarreH2();
	private Piece BarreH3 = new BarreH3();
	private Piece BarreH4 = new BarreH4();
	private Piece BarreH5 = new BarreH5();
	private Piece BarreV2 = new BarreV2();
	private Piece BarreV3 = new BarreV3();
	private Piece BarreV4 = new BarreV4();
	private Piece BarreV5 = new BarreV5();
	private Piece Carre1 = new Carre1();
	private Piece Carre2 = new Carre2();
	private Piece Carre3 = new Carre3();
	private Piece CoinBD1 = new CoinBD1();
	private Piece CoinBD2 = new CoinBD2();
	private Piece CoinBG1 = new CoinBG1();
	private Piece CoinBG2 = new CoinBG2();
	private Piece CoinHD1 = new CoinHD1();
	private Piece CoinHD2 = new CoinHD2();
	private Piece CoinHG1 = new CoinHG1();
	private Piece CoinHG2 = new CoinHG2();
	private Piece[] listepieces;
	private int aleatoire;
	private Piece lapiece;
	
	public Pieces() 
	{		
		this.listepieces = new Piece[]{BarreH2,BarreH3,BarreH4,BarreH5,BarreV2,BarreV3,BarreV4,BarreV5,Carre1,Carre2,Carre3,CoinBD1,CoinBD2,CoinBG1,CoinBG2,CoinHD1,CoinHD2,CoinHG1,CoinHG2};
	}
				

	public Piece getPiece() 
	{		 
		this.aleatoire = (int) (Math.random() * 19);
		this.lapiece = listepieces[aleatoire];
		return lapiece;
	}
	
	
}
