import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            public int compare(String file1, String file2) {
                String[] part1 = splitFile(file1);
                String[] part2 = splitFile(file2);
                
                int headCompare = part1[0].compareToIgnoreCase(part2[0]);
                if (headCompare == 0) {
                    int num1 = Integer.parseInt(part1[1]);
                    int num2 = Integer.parseInt(part2[1]);
                    return Integer.compare(num1, num2);
                }
                return headCompare;
            }
            
            private String[] splitFile(String file) {
                String head = "";
                String number = "";
                int i = 0;
                
                while (i < file.length() && !Character.isDigit(file.charAt(i))) {
                    head += file.charAt(i);
                    i++;
                }
                
                while (i < file.length() && Character.isDigit(file.charAt(i))) {
                    number += file.charAt(i);
                    i++;
                }
                
                return new String[] { head, number };
            }
        });
        
        return files;
    }
}