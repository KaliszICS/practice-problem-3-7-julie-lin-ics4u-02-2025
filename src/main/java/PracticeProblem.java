public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int searchMazeMoves(String [][] arr) {
		int row = arr.length - 1;
		int col = 0;
		int moves = 0;

		moves = mazeMovesHelper (arr, row, col, moves);

		return moves;
	}

	public static int mazeMovesHelper(String [][] arr, int row, int col, int moves) {
		if (row == -1 || col == -1 || row == arr.length || col == arr[row].length || arr[row][col].equals("*")) {
			return -1;
		}
		if (arr[row][col].equals("F")) {
			return moves;
		}

		String temp = arr[row][col];
		arr[row][col] = "*";
		moves++;

		int up = mazeMovesHelper(arr, row, col +1, moves);
		int down = mazeMovesHelper(arr, row, col -1, moves);
		int right = mazeMovesHelper(arr, row +1, col, moves);
		int left = mazeMovesHelper(arr, row -1, col, moves);

		if (up != -1) {
			if (up > left && left != -1) {
				up = left;
			}
		}
		else {
			up = left;
		}

		if (down != -1) {
			if (down > right && right != -1) {
				down = right;
			}
		}
		else {
			down = right;
		}

		if (down != -1) {
			if (down > up && up != -1) {
				down = up;
			}
		}
		else {
			down = up;
		}

		moves = down;
		arr[row][col] = temp;
		return moves;
	}
	
}
