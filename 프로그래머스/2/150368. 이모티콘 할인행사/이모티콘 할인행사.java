import java.util.*;

public class Solution {
    static int[] discountRates = {10, 20, 30, 40}; // 가능한 할인율
    static int maxSubscribers = 0; // 최대 가입자 수
    static int maxSales = 0; // 최대 매출액
    
    public int[] solution(int[][] users, int[] emoticons) {
        int n = users.length;
        int m = emoticons.length;
        
        dfs(0, new int[m], users, emoticons);
        
        return new int[]{maxSubscribers, maxSales};
    }
    
    private void dfs(int depth, int[] discounts, int[][] users, int[] emoticons) {
        if (depth == emoticons.length) {
            calculate(users, emoticons, discounts);
            return;
        }
        
        // 각 이모티콘에 할인율 적용
        for (int discount : discountRates) {
            discounts[depth] = discount;
            dfs(depth + 1, discounts, users, emoticons);
        }
    }
    
    private void calculate(int[][] users, int[] emoticons, int[] discounts) {
        int subscribers = 0;
        int sales = 0;
        
        for (int[] user : users) {
            int userRate = user[0]; // 할인 기준
            int userLimit = user[1]; // 구매 제한 금액
            int totalCost = 0;
            
            // 구매 여부 판단
            for (int i = 0; i < emoticons.length; i++) {
                if (discounts[i] >= userRate) {
                    totalCost += emoticons[i] * (100 - discounts[i]) / 100;
                }
            }
            
            // 구매 금액이 제한 금액을 넘으면 가입
            if (totalCost >= userLimit) {
                subscribers++;
            } else {
                sales += totalCost;
            }
        }
        
        // 최적의 값 비교후 갱신
        if (subscribers > maxSubscribers) {
            maxSubscribers = subscribers;
            maxSales = sales;
        } else if (subscribers == maxSubscribers) {
            maxSales = Math.max(maxSales, sales);
        }
    }
}
