import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestSum {
    public static List<Integer> bestSum(int targetSum, int[] numbers) {
        List<List<Integer>> dp = new ArrayList<>(targetSum + 1);

        // Initialize dp list with empty lists.
        for (int i = 0; i <= targetSum; i++) {
            dp.add(null);
        }

        // Base case: the combination to make 0 is an empty list.
        dp.set(0, new ArrayList<>());

        for (int i = 0; i <= targetSum; i++) {
            if (dp.get(i) != null) {
                for (int num : numbers) {
                    if (i + num <= targetSum) {
                        List<Integer> combination = new ArrayList<>(dp.get(i));
                        combination.add(num);

                        // If this combination is shorter than the current best, update dp.
                        if (dp.get(i + num) == null || dp.get(i + num).size() > combination.size()) {
                            dp.set(i + num, combination);
                        }
                    }
                }
            }
        }

        // The element at dp[targetSum] will contain the shortest combination.
        return dp.get(targetSum);
    }

    public static void main(String[] args) {
        int targetSum = 7;
        int[] numbers = {2, 3, 4};
        List<Integer> result = bestSum(targetSum, numbers);
        if (result != null) {
            System.out.println("Shortest combination: " + result);
        } else {
            System.out.println("No combination found.");
        }
    }
}
