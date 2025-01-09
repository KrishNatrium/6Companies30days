package Amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Solution {
    public static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            ArrayList<String> list = new ArrayList<>();

            // Check each contact if it starts with the current prefix
            for (int j = 0; j < n; j++) {
                if (contact[j].startsWith(prefix)) {
                    list.add(contact[j]);
                }
            }
            HashSet<String> uniqueContacts = new HashSet<>(list);
            list = new ArrayList<>(uniqueContacts);

            // Sort the matching contacts in lexicographical order
            Collections.sort(list);

            // If no matches, add "0"
            if (list.isEmpty()) {
                list.add("0");
            }

            result.add(list);
        }

        return result;
    }
}