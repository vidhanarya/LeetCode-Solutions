class NumberContainers {
    Map<Integer, Integer> indexToNum;
    Map<Integer, TreeSet<Integer>> numToIndexes;

    public NumberContainers() {
        indexToNum = new HashMap<>();
        numToIndexes = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if (indexToNum.containsKey(index)) {
            int existingNum = indexToNum.get(index);
            remove(index, existingNum);
        }

        indexToNum.put(index, number);
        numToIndexes.computeIfAbsent(number, _ -> new TreeSet<>()).add(index);
    }
    
    public int find(int number) {
        if (!numToIndexes.containsKey(number)) return -1;
        return numToIndexes.get(number).getFirst();
    }

    private void remove(int index, int number) {
        numToIndexes.get(number).remove(index);
        if (numToIndexes.get(number).isEmpty()) {
            numToIndexes.remove(number);
        }
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */