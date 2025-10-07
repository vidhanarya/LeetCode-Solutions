class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> fullLakes = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        int[] result = new int[rains.length];
        Arrays.fill(result, 1);

        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) dryDays.add(i);
            else if (!fullLakes.containsKey(rains[i])) fullLakes.put(rains[i], i);
            else {
                Integer dryDay = dryDays.higher(fullLakes.get(rains[i]));
                if (dryDay == null) {
                    return new int[0];
                }
                dryDays.remove(dryDay);
                result[dryDay] = rains[i];
                fullLakes.put(rains[i], i);
            }
            if (rains[i] > 0) {
                result[i] = -1;
            }
        }
        return result;
    }
}