package week02;

// Çok Boyutlu Diziler ile A Harfi Yazdıran Program

public class DrawLetterB {
    public static void main(String[] args) {
        String[][] letter = new String[7][4];

        for(int row = 0; row < letter.length; row++) {
            for(int col = 0; col < letter[row].length; col++) {
                if(col == 0) {
                    letter[row][col] = " * ";
                } else if ((col == 1 || col == 2) && (row == 0 || row == 3 || row == 6)) {
                    letter[row][col] = " * ";
                } else if ((col == 3) && (row == 1 || row == 2 || row == 4 || row == 5)) {
                    letter[row][col] = " * ";
                } else {
                    letter[row][col] = "   ";
                }
            }
        }
        for (String[] row : letter){
            for (String col : row){
                System.out.print(col);
            }
            System.out.println();
        }
    }
}
