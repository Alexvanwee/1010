import java.io.Serializable;
import java.util.ArrayList;

public class Grille implements Serializable
{
	
	private static final long serialVersionUID = 5628009468729438962L;
	private byte[][] grille = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0}};
	private ArrayList<ArrayList<Integer>> whatisfull;
	

	public boolean PoserPiece(int ligne, int colonne, byte[][] forme, String nom, int id, int idp) 
	{
		if(nom.contains("CoinBD")) 
		{
			int tokenl = -4;
			for(int l = 4; l>-1; l--) 
			{
				int tokenc = -4;
				for(int c = 4; c>-1; c--) 
				{
					if(forme[l][c] == 1) 
					{
						if((ligne - (tokenl + l)) < 0 || (colonne - (tokenc + c)) < 0) 
						{
							if(forme[l][c] == 1) 
							{
								return false;
							}
							else 
							{
								continue;
							}
						}
						else 
						{
							if(this.grille[ligne - (tokenl + l)][colonne - (tokenc + c)] == 1) 
							{
								return false;
							}
						}
					}
					tokenc = tokenc + 2;
				}
				tokenl = tokenl + 2;
			}
			//********************
			int t1 = -4;
			for(int g = 4; g>-1; g--) 
			{
				int t2 = -4;
				for(int h = 4; h>-1; h--) 
				{
					if(forme[g][h] == 1 && this.grille[ligne - (t1 + g)][colonne - (t2 + h)] == 0) 
					{
						this.grille[ligne - (t1 + g)][colonne - (t2 + h)] = 1;	
					}
					t2 = t2 + 2;
				}
				t1 = t1 +2;
			}
		return true;
		}
		//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		else if(nom.contains("CoinBG")) 
		{
			int tokenl = -4;
			for(int l = 4; l>-1; l--) 
			{
				for(int c = 0; c<5; c++) 
				{
					if(forme[l][c] == 1) 
					{
						if((ligne - (tokenl + l)) < 0 || (colonne + c) > 9) 
						{
							if(forme[l][c] == 1) 
							{
								return false;
							}
						}
						else 
						{
							if(this.grille[ligne - (tokenl + l)][colonne + c] == 1) 
							{
								return false;
							}
						}
						
					}
				}
				tokenl = tokenl + 2;
			}
			//***********************************
			int t1 = -4;
			for(int g = 4; g>-1; g--) 
			{
				for(int h = 0; h < 5; h++) 
				{
					if(forme[g][h] == 1 && this.grille[ligne - (t1 + g)][colonne + h] == 0) 
					{
						this.grille[ligne - (t1 + g)][colonne + h] = 1;
					}
				}
				t1 = t1 + 2;
			}
		return true;	
		}
		
		//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		else if(nom.contains("CoinHD")) 
		{
			for(int l = 0; l<5; l++) 
			{
				int token2 = -4;
				for(int c = 4; c>-1; c--) 
				{
					if(forme[l][c] == 1) 
					{
						if((ligne + l) < 0 || (colonne + (c - token2)) < 0) 
						{
							if(forme[l][c] == 1) 
							{
								return false;
							}
							else 
							{
								continue;
							}
						}
						else 
						{
							if(this.grille[ligne + l][colonne - (token2 + c)] == 1) 
							{
								return false;
							}
						}	
					}
					token2 = token2 + 2;
				}
			}
			
			//*************************
			for(int g = 0; g < 5; g++) 
			{
				int t2 = -4;
				for(int h = 4; h>-1; h--) 
				{
					if(forme[g][h] == 1 && this.grille[ligne + g][colonne - (t2 + h)] == 0) 
					{
						this.grille[ligne + g][colonne - (t2 + h)] = 1;
					}
					t2 = t2 + 2;
				}
			}
		return true;
		}		
		////////////////////////////////////////////////////////////////////////////////////////////
		else 
		{
			for(int y = 0; y < 5; y++) 
			{
				for(int z = 0; z < 5; z++) 
				{
					if(forme[y][z] == 1) 
					{
						if((ligne + y) > 9 || (colonne + z) > 9) 
						{
							if(forme[y][z] == 1) 
							{
								return false;
							}
							else 
							{
								continue;
							}
						}
						
						else 
						{
							if(this.grille[ligne + y][colonne + z] == 1) 
							{
								return false;
							}
						}
					}
				}
			}
	
			for(int g = 0; g < 5; g++) 
			{
				for(int h = 0; h < 5; h++) 
				{
					if(forme[g][h] == 1 && this.grille[ligne + g][colonne + h] == 0) 
					{
						this.grille[ligne + g][colonne + h] = 1;
					}
				}
			}
		}
			
		//affiche la grille en dur
		/*for(int i = 0; i<10; i++) 
		{
			for(int j = 0; j<10; j++) 
			{
				System.out.print(this.grille[i][j]);
			}
			System.out.println("");
		}*/
		
		return true;	
	}
	
	
	public ArrayList<ArrayList<Integer>> Check(int id, int idp) 
	{
		this.whatisfull = new ArrayList<ArrayList<Integer>>();
		
		/* Test des lignes */
		
		ArrayList<Integer> lignefull = new ArrayList<Integer>();
		int counterligne = 0;
		for(int i = 0; i<10; i++) 
		{
			counterligne = 0;
			for(int j = 0; j<10; j++) 
			{
				if(this.grille[i][j] == 0) 
				{
					break;
				}
				
				if(this.grille[i][j] == 1) 
				{
					counterligne = counterligne + 1;
				}
				
				if(counterligne == 10) 
				{
					lignefull.add(lignefull.size() , i);
				}
			}
		}
		
		/* Test des colonnes */
		
		ArrayList<Integer> colonnefull = new ArrayList<Integer>();
		int countercolonne = 0;
		for(int k = 0; k<10; k++) 
		{
			countercolonne = 0;
			for(int l = 0; l<10; l++) 
			{
				if(this.grille[l][k] == 0) 
				{
					break;
				}
				
				if(this.grille[l][k] == 1) 
				{
					countercolonne = countercolonne + 1;
				}
				
				if(countercolonne == 10) 
				{
					colonnefull.add(colonnefull.size(), k);
				}
				
			}
		}
		
		this.whatisfull.add(0, lignefull);
		this.whatisfull.add(1, colonnefull);
		this.ZeroGrille(lignefull, colonnefull);
		return this.whatisfull;
		
	}
	
	
	public void ZeroGrille(ArrayList<Integer> lignes, ArrayList<Integer> colonnes) 
	{
		//pour remettre a zero lignes et colonnes completes
		for(int i = 0; i < lignes.size(); i++) 
		{
			for(int j = 0; j < 10; j++) 
			{
				this.grille[lignes.get(i)][j] = 0;
			}
		}
		
		//*********************************************
		
		for(int a = 0; a < colonnes.size(); a++) 
		{
			for(int b = 0; b < 10; b++) 
			{
				this.grille[b][colonnes.get(a)] = 0;
			}
		}
			
	}	
	
}
