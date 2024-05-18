import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        List<String> set1 = generateMultiSet(str1);
        List<String> set2 = generateMultiSet(str2);

        // 교집합과 합집합 계산
        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>(set1);

        for (String s : set2) {
            if (set1.contains(s)) {
                intersection.add(s);
                set1.remove(s);
            } else {
                union.add(s);
            }
        }

        double jaccardSimilarity;
        if (union.size() == 0) {
            jaccardSimilarity = 1.0;
        } else {
            jaccardSimilarity = (double) intersection.size() / (double) union.size();
        }

        return (int) (jaccardSimilarity * 65536);
    }

    private static List<String> generateMultiSet(String str) {
        List<String> multiSet = new ArrayList<>();
        String lowerStr = str.toLowerCase(Locale.ROOT);
        
        for (int i = 0; i < lowerStr.length() - 1; i++) {
            char first = lowerStr.charAt(i);
            char second = lowerStr.charAt(i + 1);
            if (Character.isLetter(first) && Character.isLetter(second)) {
                multiSet.add("" + first + second);
            }
        }
        
        return multiSet;
    }
}