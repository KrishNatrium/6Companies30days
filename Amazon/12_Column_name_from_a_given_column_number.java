package Amazon;

class Solution {
    private String letter(int number) {
        if (number >= 1 && number <= 25) {
            char letter = (char) ('A' + number - 1);
            return String.valueOf(letter);
        } else {
            return "Z";
        }
    }

    public String convertToTitle(int c) {
        StringBuilder ans = new StringBuilder();
        while (c > 0) {
            c--;
            ans.insert(0, letter(c % 26 + 1));
            c = c / 26;
        }
        return ans.toString();
    }
}