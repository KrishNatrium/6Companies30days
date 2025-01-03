import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs, new HashMap<>());
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs,
            Map<List<Integer>, Integer> memo) {
        // dynamic programming, memo for reduced recursion tree branches
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }

        int n = price.size();
        int minCost = 0;

        // cost without any special offer
        for (int i = 0; i < n; i++) {
            minCost += needs.get(i) * price.get(i);
        }

        for (List<Integer> offer : special) {
            List<Integer> newNeeds = new ArrayList<>(needs);
            boolean valid = true;

            // is offer valid ?
            for (int i = 0; i < n; i++) {
                int remaining = newNeeds.get(i) - offer.get(i);
                if (remaining < 0) {
                    valid = false;
                    break;
                }
                newNeeds.set(i, remaining);
            }
            if (valid) {
                minCost = Math.min(minCost, offer.get(n) + dfs(price, special, newNeeds, memo));
            }
        }

        // dynamic programming, memo for reduced recursion tree branches
        memo.put(needs, minCost);
        return minCost;
    }
}
