class Solution {
    public int countMatches(
            java.util.List<java.util.List<String>> items,
            String ruleKey,
            String ruleValue) {

        int count = 0;

        for (java.util.List<String> item : items) {
            String value;

            if (ruleKey.equals("type")) {
                value = item.get(0);
            } else if (ruleKey.equals("color")) {
                value = item.get(1);
            } else {
                value = item.get(2);
            }

            if (value.equals(ruleValue)) {
                count++;
            }
        }

        return count;
    }
}