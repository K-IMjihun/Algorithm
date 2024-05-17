import java.util.*;
class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1); 
        String[] sets = s.split("\\},\\{");
        
        sets[0] = sets[0].substring(1);
        sets[sets.length - 1] = sets[sets.length - 1].substring(0, sets[sets.length - 1].length() - 1);
        
        Arrays.sort(sets, (a, b) -> Integer.compare(a.length(), b.length()));
        
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        
        for (String set : sets) {
            String[] numbers = set.split(",");
            for (String number : numbers) {
                int num = Integer.parseInt(number);
                if (seen.add(num)) result.add(num);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}