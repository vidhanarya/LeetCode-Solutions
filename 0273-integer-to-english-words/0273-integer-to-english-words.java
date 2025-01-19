class Solution {
    int HUNDRED = 100;
    int THOUSAND = 1_000;
    int MILLION = 1_000_000;
    int BILLION = 1_000_000_000;
    Map<Integer, String> wordMap;

    public String numberToWords(int num) {
        initializeWordMap();

        if (num == 0) return wordMap.get(0);
        return getWordForNumber(num);
    }

    public String getWordForNumber(int num) {
        if (num <= 0) return "";
        if (num <= 19) return wordMap.get(num);
        if (num < HUNDRED && num % 10 == 0) return wordMap.get((num / 10) * 10);
        if (num < HUNDRED) {
            return wordMap.get((num / 10) * 10) + " " + wordMap.get(num % 10);
        }

        StringBuilder wordBuilder = new StringBuilder();        
        int divisor = BILLION;
        if (num < THOUSAND && num >= HUNDRED) divisor = HUNDRED;
        if (num < MILLION && num >= THOUSAND) divisor = THOUSAND;
        if (num < BILLION && num >= MILLION) divisor = MILLION;

        wordBuilder.append(getWordForNumber(num / divisor));
        wordBuilder.append(" ");
        wordBuilder.append(wordMap.get(divisor));
        if (num % divisor > 0) {
            wordBuilder.append(" ");
            wordBuilder.append(getWordForNumber(num % divisor));
        }
        return wordBuilder.toString();
    }

    public void initializeWordMap() {
        wordMap = new HashMap<>();
        wordMap.put(0, "Zero");
        wordMap.put(1, "One");
        wordMap.put(2, "Two");
        wordMap.put(3, "Three");
        wordMap.put(4, "Four");
        wordMap.put(5, "Five");
        wordMap.put(6, "Six");
        wordMap.put(7, "Seven");
        wordMap.put(8, "Eight");
        wordMap.put(9, "Nine");
        wordMap.put(10, "Ten");
        wordMap.put(11, "Eleven");
        wordMap.put(12, "Twelve");
        wordMap.put(13, "Thirteen");
        wordMap.put(14, "Fourteen");
        wordMap.put(15, "Fifteen");
        wordMap.put(16, "Sixteen");
        wordMap.put(17, "Seventeen");
        wordMap.put(18, "Eighteen");
        wordMap.put(19, "Nineteen");
        wordMap.put(20, "Twenty");
        wordMap.put(30, "Thirty");
        wordMap.put(40, "Forty");
        wordMap.put(50, "Fifty");
        wordMap.put(60, "Sixty");
        wordMap.put(70, "Seventy");
        wordMap.put(80, "Eighty");
        wordMap.put(90, "Ninety");
        wordMap.put(HUNDRED, "Hundred");
        wordMap.put(THOUSAND, "Thousand");
        wordMap.put(MILLION, "Million");
        wordMap.put(BILLION, "Billion");
    }
}