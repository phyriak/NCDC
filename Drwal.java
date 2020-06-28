
import java.io.*;

public class Drwal {
    public static void main(String[] args) throws IOException {
        if (!args[0].chars().allMatch(Character::isDigit)
                || !args[1].chars().allMatch(Character::isDigit)
                || !args[3].chars().allMatch(Character::isDigit)
                || !args[4].chars().allMatch(Character::isDigit)) {
            System.out.println("klops");
        } else {
            int xStart = Integer.parseInt(args[0].trim());
            int yStart = Integer.parseInt(args[1].trim());
            char kolor = args[2].trim().charAt(0);
            int width = Integer.parseInt(args[3].trim());
            int height = Integer.parseInt(args[4].trim());
            char matrix[][] = new char[height][width];
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            System.in, "UTF-8"));

            if (xStart > width || yStart > height || width > 50 || height > 50 || xStart <= 0 || yStart <= 0 || kolor == ' ') {
                System.out.println("klops");
            } else {
                int row = 0;
                int k = 0;
                boolean inputSize = true;
                String line;
                // filling matrix
                while ((line = in.readLine()) != null) {
                    row++;
                    if (line.length() > width) {
                        System.out.println("klops");
                        inputSize = false;
                        break;
                    }
                    if (row > height) {
                        System.out.println("klops");
                        inputSize = false;
                        break;
                    }
                    for (int j = 0; j < width; j++) {
                        if (j == line.length()) break;
                        matrix[k][j] = line.charAt(j);
                    }
                    if (row == height) break;
                    k++;
                }
                if (inputSize) {
                    //filling start point with kolor
                    if (matrix[yStart - 1][xStart - 1] == ' ') {
                        matrix[yStart - 1][xStart - 1] = kolor;
                    }
                    //filling rest of draw
                    //filling corners
                    if (matrix[0][0] == kolor) {
                        if (matrix[0][1] == ' ') matrix[0][1] = kolor;
                        if (matrix[1][0] == ' ') matrix[1][0] = kolor;
                    }
                    if (matrix[0][width - 1] == kolor) {
                        if (matrix[0][width - 2] == ' ') matrix[0][width - 2] = kolor;
                        if (matrix[1][width - 1] == ' ') matrix[1][width - 1] = kolor;
                    }
                    if (matrix[height - 1][0] == kolor) {
                        if (matrix[height - 2][0] == ' ') matrix[height - 2][0] = kolor;
                        if (matrix[height - 1][1] == ' ') matrix[height - 1][1] = kolor;
                    }
                    if (matrix[height - 1][width - 1] == kolor) {
                        if (matrix[height - 1][width - 2] == ' ') matrix[height - 1][width - 2] = kolor;
                        if (matrix[height - 2][width - 1] == ' ') matrix[height - 2][width - 1] = kolor;
                    }

                    //filling edges
                    for (int i = 1; i < width - 2; i++) {
                        if (matrix[0][i] == kolor) {
                            if (matrix[0][i - 1] == ' ') matrix[0][i - 1] = kolor;
                            if (matrix[0][i + 1] == ' ') matrix[0][i + 1] = kolor;
                            if (matrix[1][i] == ' ') matrix[1][i] = kolor;
                        }
                        if (matrix[height - 1][i] == kolor) {
                            if (matrix[height - 1][i - 1] == ' ') matrix[height - 1][i - 1] = kolor;
                            if (matrix[height - 1][i + 1] == ' ') matrix[height - 1][i + 1] = kolor;
                            if (matrix[height - 2][i] == ' ') matrix[height - 2][i] = kolor;
                        }
                    }
                    for (int i = 1; i < height - 2; i++) {
                        if (matrix[i][0] == kolor) {
                            if (matrix[i - 1][0] == ' ') matrix[i - 1][0] = kolor;
                            if (matrix[i + 1][0] == ' ') matrix[0][i + 1] = kolor;
                            if (matrix[i][1] == ' ') matrix[i][1] = kolor;
                        }
                        if (matrix[i][width - 1] == kolor) {
                            if (matrix[i - 1][width - 1] == ' ') matrix[i - 1][width - 1] = kolor;
                            if (matrix[i + 1][width - 1] == ' ') matrix[i + 1][width - 1] = kolor;
                            if (matrix[i][width - 2] == ' ') matrix[i][width - 2] = kolor;
                        }
                    }
                    //filling interior of draw
                    for (int m = 0; m < 50; m++) {
                        for (int i = 1; i < height - 1; i++) {
                            for (int j = 1; j < width - 1; j++) {
                                if (matrix[i][j] == kolor) {
                                    if (matrix[i + 1][j] == ' ') matrix[i + 1][j] = kolor;
                                    if (matrix[i - 1][j] == ' ') matrix[i - 1][j] = kolor;
                                    if (matrix[i][j + 1] == ' ') matrix[i][j + 1] = kolor;
                                    if (matrix[i][j - 1] == ' ') matrix[i][j - 1] = kolor;
                                    if (matrix[i + 1][j + 1] == ' ') {
                                        if (matrix[i + 1][j] == ' ' && matrix[i][j + 1] == ' ')
                                            matrix[i + 1][j + 1] = kolor;
                                    }
                                    if (matrix[i - 1][j - 1] == ' ') {
                                        if (matrix[i - 1][j] == ' ' && matrix[i][j - 1] == ' ')
                                            matrix[i - 1][j - 1] = kolor;
                                    }
                                    if (matrix[i + 1][j - 1] == ' ') {
                                        if (matrix[i + 1][j] == ' ' && matrix[i][j - 1] == ' ')
                                            matrix[i + 1][j - 1] = kolor;
                                    }
                                    if (matrix[i - 1][j + 1] == ' ') {
                                        if (matrix[i - 1][j] == ' ' && matrix[i][j + 1] == ' ')
                                            matrix[i - 1][j + 1] = kolor;
                                    }
                                }
                            }
                        }
                    }
                    //printing
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            System.out.print(matrix[i][j]);
                        }
                        System.out.println();
                    }
                }
            }
        }
    }
}
