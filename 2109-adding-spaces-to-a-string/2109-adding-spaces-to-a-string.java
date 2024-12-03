class Solution {
    public String addSpaces(String s, int[] spaces) {
        char[] modifiedString = new char[s.length() + spaces.length];
        int idx = 0, strPtr = 0, spacePtr = 0;
        while (idx < modifiedString.length) {
            if (spacePtr < spaces.length && strPtr == spaces[spacePtr]) {
                modifiedString[idx++] = ' ';
                spacePtr++;
            } else {
                modifiedString[idx++] = s.charAt(strPtr++);
            }
        }
        return new String(modifiedString);
    }
}