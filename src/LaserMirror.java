import java.util.Scanner;


public class LaserMirror {
	private static int _numRow=10;
	private static int _numColumn=10;
	private static int _fireRow= -1;
	static int _north = 1;
	static int _south = 3;
	static int _east = 0;
	static int _west = 2;
	static String[] _initStrings = {
		"...../...\\",
		"..\\.......",
		"......./..",
		"..........",
		"........\\.",
		"..........",
		"..........",
		".....\\../.",
		"..\\....../",
		".........."
	};


	static char[][] _squares = new char[_numRow][_numColumn];
	//Initializes the characters of each array and display them
	static void initialize(){
		for(int i = 0; i< _numRow; ++i){
			for( int j = 0; j<_numColumn; ++j){

				_squares[i][j] = _initStrings[i].charAt(j);


			}

		}
	}

	public static void fire()
	{
		_numColumn = 0; 
		_numRow=_fireRow; 

		int _direction = 0; 
		boolean contin = true; 
		while (contin == true) 
		{
			// east
			if (_direction == 0) 
			{
				if (_squares[_numRow][_numColumn] == '/') 
				{
					_numRow = _numRow - 1; 
					_direction = 1; 
					if (_numRow==-1) 
						contin=false; 
				}	
				else if(_squares[_numRow][_numColumn]== '.')
				{
					_squares[_numRow][_numColumn]= '-';
					_numColumn++;
					
				}
				else if(_squares[_numRow][_numColumn] == '\\') 
				{
					_numRow = _numRow + 1; 
					//south
					_direction = 3; 
				}
				else if(_squares[_numRow][_numColumn] == '|') 
				{

					_squares[_numRow][_numColumn] = '+'; 
					_numColumn++; 
				}
				else 
				{
					
					
					//end of array
					if (_numColumn==_squares[0].length)
					{
						contin=false;
					}
				}
			}
			//north
			else if (_direction == 1) 
			{							
				if (_squares[_numRow][_numColumn] == '/') 
				{
					_numColumn = _numColumn + 1;
					_direction = 0; 
				}
				else if(_squares[_numRow][_numColumn]== '.')
				{
					_squares[_numRow][_numColumn]= '|';
					_numRow--;
					
				}
				else if(_squares[_numRow][_numColumn] == '\\')
				{
					_numColumn = _numColumn - 1;
					_direction = 2; 
				}
				else if(_squares[_numRow][_numColumn] == '-')
				{
					_squares[_numRow][_numColumn] = '+';
					_numRow--; 
				}
				else
				{
					
					if (_numRow==-1) 
					{
						contin = false; 
					}
				}
			}

			// south
			else if (_direction == 3) 
			{						
				if (_squares[_numRow][_numColumn] == '/')
				{
					_numColumn--;
					_direction = 2;
				}
				else if(_squares[_numRow][_numColumn]== '.')
				{
					_squares[_numRow][_numColumn]= '|';
					_numRow++;
					
				}
				else if(_squares[_numRow][_numColumn] == '\\')
				{
					_numColumn++;
					_direction = 0;
				}
				else if(_squares[_numRow][_numColumn] == '-')
				{
					_squares[_numRow][_numColumn] = '+';
					_numRow++;
				}
				else
				{
					
					if (_numRow==_squares.length) 
					{
						contin = false; 
					}
				}
			}
			
			
			//west
			else if (_direction == 2) 
			{							
				if (_squares[_numRow][_numColumn] == '/')
				{
					_numRow++;
					_direction = 3; 
				}
				else if(_squares[_numRow][_numColumn]== '.')
				{
					_squares[_numRow][_numColumn]= '-';
					_numColumn--;
					
				}
				else if(_squares[_numRow][_numColumn] == '\\')
				{
					_numRow--;
					_direction = 1; 
				}
				else if(_squares[_numRow][_numColumn] == '|')
				{
					_squares[_numRow][_numColumn] = '+';
					_numColumn--;
				}
				else
				{
					
					if (_numColumn==0) 
					{
						_squares[_numRow][_numColumn]= '-';
						contin = false;
					}
				}
			}
		}
	}




	static void fireStart(){
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.print("Fire the laser at row #:  ");
		_fireRow = sc.nextInt();
		System.out.println();
	}
	static void show(){
		for(int i = 0; i< _numRow; ++i){

			System.out.print(i);
			//System.out.print(_fireRow);
			if(  i == _fireRow){
				System.out.print(">");
			}
			else{
				System.out.print(" ");
			}

			for( int j = 0; j<_numColumn; ++j){

				_squares[i][j] = _initStrings[i].charAt(j);

				System.out.print(_squares[i][j]);

			}

			System.out.print("\n");

		}


	}





	public static void main(String[] args) {



		initialize();
		show();
		fireStart();
		fire();
		show();





	}

}





