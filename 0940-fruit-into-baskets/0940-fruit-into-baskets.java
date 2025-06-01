class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> fruitCount = new HashMap<>();
        int maxFruits = 0;
        int left = 0;

        for (int right = 0; right < fruits.length; right++) {
            // Add current fruit to the map
            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);

            // Shrink window if more than 2 types of fruits
            while (fruitCount.size() > 2) {
                fruitCount.put(fruits[left], fruitCount.get(fruits[left]) - 1);
                if (fruitCount.get(fruits[left]) == 0) {
                    fruitCount.remove(fruits[left]);
                }
                left++;
            }

            // Update maximum fruits in a valid window
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}
