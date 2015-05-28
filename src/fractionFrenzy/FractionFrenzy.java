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
	
	public Fraction multiplyFractions (Fraction f1, Fraction f2){
		Fraction x = new Fraction(f1.numerator*f2.numerator, f1.denominator*f2.denominator);
		return x;
	}
	
	public Fraction divideFractions (Fraction f1, Fraction f2){
		//inverses the second fraction and then multiplies
		int buffer = f2.numerator;
		f2.numerator = f2.denominator;
		f2.denominator = buffer;
		
		Fraction result = multiplyFractions(f1,f2);
		return result;
	}
	
	public Fraction addFractions(Fraction f1, Fraction f2){
		//multiply denominators and add.
		int numerator;
		int denominator;
		numerator = f1.numerator*f2.denominator + f2.numerator*f1.denominator;
		denominator = f1.denominator*f2.denominator;
		
		Fraction x = new Fraction(numerator,denominator);
		return x;
	}
	
	public Fraction subtractFractions(Fraction f1, Fraction f2){
		//multiply denominators and subtract.
		int numerator;
		int denominator;
		numerator = f1.numerator*f2.denominator - f2.numerator*f1.denominator;
		denominator = f1.denominator*f2.denominator;
		
		Fraction x = new Fraction(numerator,denominator);
		return x;
	}
	
	public Fraction[] sortRow(Fraction[][] grid,int rowNumber){
		Fraction[] row = new Fraction[grid[rowNumber].length];
		//copies values in row to new array
		for(int i = 0; i<grid[rowNumber].length;i++){
			row[i] = grid[rowNumber][i];
		}
		bubbleSort(row);	
		return row;
	}
	
	public Fraction[] sortColumn(Fraction[][] grid,int columnNumber){
		Fraction[] row = new Fraction[grid.length];
		for(int i = 0; i<grid.length;i++){
			row[i] = grid[i][columnNumber];
		}
		bubbleSort(row);
		
		return row;
	}
	
	public static int num0to100(){
		int x = (int)(Math.random()*101);
		return x;
	}
	
	public static int num1to100(){
		int x = (int)(Math.random()*100 + 1);
		return x;
	}
	
	public void bubbleSort(Fraction[] array) {
	      boolean swapped = true;
	      int j = 0;
	      double tmp;
	      while (swapped) {
	            swapped = false;
	            j++;
	            for (int i = 0; i < array.length - j; i++) {                                       
	                  if (array[i].value > array[i + 1].value) {                          
	                        tmp = array[i].value;
	                        array[i].value = array[i + 1].value;
	                        array[i + 1].value = tmp;
	                        swapped = true;
	                  }
	            }                
	      }
	}
}
