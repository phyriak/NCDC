public class Kosmolot {
    public static void main(String[] args) {
        if (!args[0].chars().allMatch(Character::isDigit)) {
            System.out.println("klops");
        }else {
            int n = Integer.parseInt(args[0]);
            String cover = args[1];
            if (n < 1 || n > 75 || !"NY".contains(cover) || cover.length() != 1) {
                System.out.println("klops");
            } else {
                String row = "";
                int tableSize = 2 * n - 1;
                String[] table = new String[tableSize];
                if (cover.equals("N")) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            for (int l = 0; l < n; l++) {
                                if (i >= l)
                                    row += '*';
                                else
                                    row += ' ';
                            }
                        }
                        table[i] = row;
                        row = "";
                    }

                } else if (cover.equals("Y")) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            for (int l = 0; l < n; l++) {
                                if (i >= l) {
                                    if (l == 0 && j == 0 || (l == n - 1 && j == n - 1)) {
                                        row += '>';
                                    } else if (i == l && i < n - 1) {
                                        row += "\\";
                                    } else row += '*';
                                } else
                                    row += ' ';
                            }
                        }
                        table[i] = row;
                        row = "";
                    }
                }
                for (int i = n; i < (tableSize); i++) {
                    if (table[0].contains(">")) {
                        table[i] = table[(tableSize - 1) - i].replaceAll("\\\\", "/");
                    } else table[i] = table[(tableSize - 1) - i];
                }
                for (String c : table) {
                    System.out.println(c);
                }
            }
        }
    }
}
