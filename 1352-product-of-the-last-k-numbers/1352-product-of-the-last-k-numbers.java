class ProductOfNumbers {
    int lastZero;
    List<Integer> prefixProduct;

    public ProductOfNumbers() {
        lastZero = -1;
        prefixProduct = new ArrayList<>();
        prefixProduct.add(1);
    }

    public void add(int num) {
        int size = prefixProduct.size();
        if (num == 0) {
            lastZero = size;
            prefixProduct.add(1);
        } else {
            prefixProduct.add(prefixProduct.get(size-1) * num);
        }
    }
    
    public int getProduct(int k) {
        int size = prefixProduct.size();
        if (size - k <= lastZero) return 0;
        if (k == size) return prefixProduct.get(size - 1);
        
        return prefixProduct.get(size - 1) / prefixProduct.get(size - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */