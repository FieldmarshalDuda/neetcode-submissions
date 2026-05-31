class Solution {
    public boolean isValidSudoku(char[][] board) {
     HashMap<Integer, Set<Character>> rowSet = new HashMap<>();
        HashMap<Integer, Set<Character>> colSet = new HashMap<>();
        HashMap<String, Set<Character>> squareSet = new HashMap<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                String squareKey = (row / 3) + "," + (col / 3);
                if (rowSet.computeIfAbsent(row, lm ->
                        new HashSet<>()).contains(board[row][col])
                        || colSet.computeIfAbsent(col, lm ->
                        new HashSet<>()).contains(board[row][col])
                        || squareSet.computeIfAbsent(squareKey, lm ->
                        new HashSet<>()).contains(board[row][col])) {
                    return false;
                }
                rowSet.get(row).add(board[row][col]);
                colSet.get(col).add(board[row][col]);
                squareSet.get(squareKey).add(board[row][col]);
            }
        }
        return true;
    }
}
