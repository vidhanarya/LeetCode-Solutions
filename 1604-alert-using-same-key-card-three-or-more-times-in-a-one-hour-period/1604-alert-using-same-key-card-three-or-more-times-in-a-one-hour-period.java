class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> accessTimes = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            int time = timeToMinutes(keyTime[i]);
            accessTimes.computeIfAbsent(name, _ -> new ArrayList<>()).add(time);
        }

        List<String> alertedNames = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> nameToTimes : accessTimes.entrySet()) {
            String name = nameToTimes.getKey();
            List<Integer> entryTimes = nameToTimes.getValue();
            entryTimes.sort(Comparator.comparingInt(a -> a));

            for (int i = 2; i < entryTimes.size(); i++) {
                if (entryTimes.get(i) - entryTimes.get(i-2) <= 60) {
                    alertedNames.add(name);
                    break;
                }
            }
        }
        
        alertedNames.sort((a, b) -> {
            return a.compareTo(b);
        });
        return alertedNames;
    }

    public int timeToMinutes(String time) {
        int minutes = Integer.parseInt(time.substring(0, 2)) * 60;
        minutes += Integer.parseInt(time.substring(3, 5));
        return minutes;
    }
}