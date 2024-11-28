class Time {
    int plant;
    int grow;
    
    Time(int plant, int grow) {
        this.plant = plant;
        this.grow = grow;
    }
}

class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        PriorityQueue<Time> pq = new PriorityQueue<>((a, b) -> {
            if (a.grow == b.grow) return a.plant - b.plant;
            return b.grow - a.grow;
        });

        for (int i = 0; i < plantTime.length; i++) {
            pq.add(new Time(plantTime[i], growTime[i]));
        }

        int minDays = 0;
        int plantDays = 0;
        while (!pq.isEmpty()) {
            Time t = pq.remove();
            plantDays += t.plant;
            minDays = Math.max(minDays, plantDays + t.grow);
        }

        return minDays;
    }
}