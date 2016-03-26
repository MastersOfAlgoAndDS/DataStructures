package LogicMonitor;

/**
 * @author Milind
 * @Problem: Create a method that maximizes profit from buying and selling.
 *
 *           You are given an array of stock prices. It represents the stock
 *           price for a particular stock on a given day. That is, each index
 *           represents one day and the value represents the price of the stock
 *           during that day. The entire array is a range of days. Your job is
 *           try to buy and sell a stock in such a way that maximizes the amount
 *           of money gained from the transaction. Find the indices of the buy
 *           and sell days. If that is not possible for whatever reason, return
 *           -1 for each index. Remember 0 is not a profit! The profit must be
 *           positive.
 *
 *           Input: Array of stock prices represented as doubles. Size s of
 *           array will be s >= 0
 *
 *           Output: the indices corresponding to the buy and sell date of the
 *           maximum profit possible given the input, or -1 for both indices.
 *           When the difference array[high] - array[low] is computed, the
 *           profit must be > 0!
 *
 *           Consider edge cases!
 * 
 *           Example Input Array: {20,40,52,15,30,50,10,25} Expected Output:
 *           {3,5}
 */
public class MaximizeProfit_Prob3 {

	public static int[] maximumProfit(double[] prices) {
		int[] idx = new int[2];
		idx[0] = -1;
		idx[1] = -1;

		double minElem = prices[0];
		double maxDiff = 0;
		int currStartIndex = -1;
		int currEndIndex = -1;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < minElem) {
				minElem = Math.min(minElem, prices[i]);
				currStartIndex = i;
			}
			if (maxDiff < prices[i] - minElem) {
				maxDiff = Math.max(maxDiff, prices[i] - minElem);
				currEndIndex = i;

				idx[0] = currStartIndex;
				idx[1] = currEndIndex;
			}
		}

		return idx;
	}

	public static void main(String[] args) {
		double[] prices = { 20, 40, 52, 15, 30, 50, 10, 25 };
		for (double d : prices) {
			System.out.print(d + " ");
		}
		System.out.println();
		for (int i : maximumProfit(prices)) {
			System.out.print(i + " ");
		}

	}
}
