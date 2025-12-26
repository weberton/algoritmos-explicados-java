package br.com.aartedeprogramar.problemas;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /*
      T=O(N)
      E=O(N)
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> vistos = new HashSet<>();

        for (int num : nums) {
            if (vistos.contains(num)) {
                return true;
            }

            vistos.add(num);
        }

        return false;
    }
}
