class RandomizedSet {
    List<Integer> data = new ArrayList<>();
    Map<Integer, Integer> indexMap = new HashMap<>();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if (indexMap.containsKey(val)) return false;

        data.add(val);
        indexMap.put(val, data.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) return false;

        int idx = indexMap.get(val);
        int size = data.size();
        if (idx != size-1) {
            int temp = data.get(size-1);
            data.set(size-1, val);
            data.set(idx, temp);
            
            indexMap.put(temp, idx);
        }

        data.removeLast();
        indexMap.remove(val);
        return true;
    }

    public int getRandom() {
        int idx = new Random().nextInt(data.size());
        return data.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */