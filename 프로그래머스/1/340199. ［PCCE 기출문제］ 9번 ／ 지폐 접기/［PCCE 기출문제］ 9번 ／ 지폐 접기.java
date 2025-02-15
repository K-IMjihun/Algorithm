class Solution {
    public int solution(int[] wallet, int[] bill) {
		int maxWallet = Math.max(wallet[0], wallet[1]);
		int minWallet = Math.min(wallet[0], wallet[1]);
		int maxBill = Math.max(bill[0], bill[1]);
		int minBill = Math.min(bill[0], bill[1]);
        int result = 0;
		while(maxBill > maxWallet || minBill > minWallet) {
			
            maxBill /= 2;
			
			if(maxBill < minBill) {
				int c = maxBill;
				maxBill = minBill;
				minBill = c;
			}
			
			result++;
		}
		return result;
	}

}
