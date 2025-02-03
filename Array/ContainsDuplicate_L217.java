package AkashChoudhary_22BCS13892.Array;

import java.util.HashSet;
public class ContainsDuplicate_L217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }
}
