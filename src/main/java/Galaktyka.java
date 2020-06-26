
public class Galaktyka {
    public static void main(String[] args) {
        if (!args[0].chars().allMatch(Character::isDigit)) {
            System.out.println("klops");
        } else {
            int n = Integer.parseInt(args[0]);
            String orientation = args[1];
            int numberOfColumns = n + 2;
            int numberOfRows = n + 3;
            int row = 0, col = 0;
            char move = 'r';
            int bound = numberOfColumns - 1;
            int flag = 0;
            int changeOfBound = numberOfRows - 1;
            StringBuilder line = new StringBuilder();
            int counter = 0;

            if (n < 1 || n > 10000 || !"NWSE".contains(orientation) || orientation.length() != 1) {
                System.out.println("klops");
            } else {
                char matrix[][] = new char[numberOfRows][numberOfColumns];
                char rotatedMatrix[][] = new char[numberOfColumns][numberOfRows];

                //fill spiral in matrix
                for (int i = 0; i < numberOfRows * numberOfColumns; i++) {
                    matrix[row][col] = '*';

                    switch (move) {
                        case 'r':
                            col += 1;
                            break;
                        // if left, go left
                        case 'l':
                            col -= 1;
                            break;
                        // if up, go up
                        case 'u':
                            row -= 1;
                            break;
                        // if down, go down
                        case 'd':
                            row += 1;
                            break;
                    }

                    if (i == bound - 1) {
                        flag++;
                        if (flag > 1) {
                            changeOfBound--;
                        }
                        bound += changeOfBound;

                        //change direction of movement
                        switch (move) {
                            case 'r':
                                move = 'd';
                                break;
                            case 'd':
                                move = 'l';
                                break;
                            case 'l':
                                move = 'u';
                                break;
                            case 'u':
                                move = 'r';
                                break;
                        }
                    }
                    if (i == bound) break; //spiral is finished, break program
                }

                //rotate matrix
                for (row = 0; row < numberOfRows; row++) {
                    for (col = numberOfColumns - 1; col >= 0; col--) {
                        rotatedMatrix[col][row] = matrix[row][col];
                    }
                }
                //print spiral in case of direction
                switch (orientation) {
                    case "W":
                        for (row = 0; row < numberOfRows; row++) {
                            for (col = 0; col < numberOfColumns; col++) {
                                if (matrix[row][col] != '*') {
                                    matrix[row][col] = ' ';
                                    counter++;
                                }
                                line.append(matrix[row][col]);
                            }
                            System.out.println(line);
                            line.setLength(0);
                        }
                        System.out.println(counter);
                        break;

                    case "E":
                        for (row = numberOfRows - 1; row >= 0; row--) {
                            for (col = numberOfColumns - 1; col >= 0; col--) {
                                if (matrix[row][col] != '*') {
                                    matrix[row][col] = ' ';
                                    counter++;
                                }
                                line.append(matrix[row][col]);
                            }
                            System.out.println(line);
                            line.setLength(0);
                        }
                        System.out.println(counter);
                        break;

                    case "N":
                        for (col = 0; col < numberOfColumns; col++) {
                            for (row = numberOfRows - 1; row >= 0; row--) {
                                if (rotatedMatrix[col][row] != '*') {
                                    rotatedMatrix[col][row] = ' ';
                                    counter++;
                                }
                                line.append(rotatedMatrix[col][row]);
                            }
                            System.out.println(line);
                            line.setLength(0);
                        }
                        System.out.println(counter);
                        break;

                    case "S":
                        for (col = numberOfColumns - 1; col >= 0; col--) {
                            for (row = 0; row < numberOfRows; row++) {
                                if (rotatedMatrix[col][row] != '*') {
                                    rotatedMatrix[col][row] = ' ';
                                    counter++;
                                }
                                line.append(rotatedMatrix[col][row]);
                            }
                            System.out.println(line);
                            line.setLength(0);
                        }
                        System.out.println(counter);
                        break;
                }
            }
        }
    }
}



