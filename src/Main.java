
public class Main {
	public class LaserMirror {
	}
	private static int _numRow;
	private static int _numColumn;
	private static int _fireRow= -1;
	static int _north = 0;
	static int _south = 1;
	static int _east = 2;
	static int _west = 3;
	/*static String[] _initStrings = {
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
	*/
static int[][] mirrors = new int[10][10];
	static char[][] _squares = new char[_numRow][_numColumn];
	static void _initialize(){


	};
	//Length of the array.
	//static int length01 = _initStrings.length;
	

	public static void main(String[] args) {
		System.out.println(mirrors);
	}

}
