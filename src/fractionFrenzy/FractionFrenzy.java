package fractionFrenzy;

public class FractionFrenzy {

	public static void main(String[] args){
		Fraction[][] grid = new Fraction[10][10];
		makeGrid(grid);
		Fraction[][] grid2 = grid;
		printGrid(grid);
		squareGrid(grid2);
		printGrid(grid2);
	}
	
	public static Fraction[][] makeGrid(Fraction[][] grid){
		
		for(int i = 0;i < grid.length;i++){
			for(int j = 0; j<grid[i].length;j++){
				grid[i][j] = new Fraction(num0to100(),num1to100());
			}
		}
		return grid;
	}
	
	public static void printGrid(Fraction[][] grid){
		
		for(int i = 0;i < grid.length;i++){
			for(int j = 0; j<grid[i].length;j++){
				System.out.print(grid[i][j].numerator + "/" + grid[i][j].denominator + "\t");
			}
			System.out.println("");
		}		
	}
	
	public static Fraction[][] squareGrid(Fraction[][] grid){
		
		for(int i = 0;i < grid.length;i++){
			for(int j = 0; j<grid[i].length;j++){
				grid[i][j].numerator = (int) Math.pow(grid[i][j].numerator, 2);
				grid[i][j].denominator = (int) Math.pow(grid[i][j].denominator, 2);
			}
		}
		return grid;		
	}
	
	public Fraction addFractions(Fraction[][] grid, int i1, int j1, int i2, int j2){
		int numerator;
		int denominator;
		if(grid[i1][j1].denominator != grid[i2][j2].denominator){
			int c = grid[i1][j1].denominator;
			grid[i1][j1].denominator = grid[i1][j1].denominator*grid[i2][j2].denominator;
			grid[i1][j1].numerator = grid[i1][j1].numerator*grid[i2][j2].denominator;
			
			grid[i2][j2].denominator = grid[i2][j2].denominator*c;
			grid[i2][j2].numerator = grid[i2][j2].numerator*c;
		}
		denominator = grid[i1][j1].denominator;
		numerator = grid[i1][j1].numerator + grid[i2][j2].numerator; 
		
		Fraction x = new Fraction(numerator, denominator);
		return x;
	}
	
	public Fraction subtractFractions(Fraction[][] grid, int i1, int j1, int i2, int j2){
		int numerator;
		int denominator;
		if(grid[i1][j1].denominator != grid[i2][j2].denominator){
			int c = grid[i1][j1].denominator;
			grid[i1][j1].denominator = grid[i1][j1].denominator*grid[i2][j2].denominator;
			grid[i1][j1].numerator = grid[i1][j1].numerator*grid[i2][j2].denominator;
			
			grid[i2][j2].denominator = grid[i2][j2].denominator*c;
			grid[i2][j2].numerator = grid[i2][j2].numerator*c;
		}
		denominator = grid[i1][j1].denominator;
		numerator = grid[i1][j1].numerator - grid[i2][j2].numerator; 
		
		Fraction x = new Fraction(numerator, denominator);
		return x;
	}
	
	public static int num0to100(){
		int x = (int)(Math.random()*101);
		return x;
	}
	
	public static int num1to100(){
		int x = (int)(Math.random()*100 + 1);
		return x;
	}
}
