class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int charactersInLine = 0;
        
        for (int i = 0; i < words.length; i++) {
            if (charactersInLine + line.size() + words[i].length() <= maxWidth) {
                line.add(words[i]);
                charactersInLine += words[i].length();
            } else {
                if (line.size() > 1) {
                    result.add(fullJustify(line, maxWidth, charactersInLine));                    
                } else {
                    result.add(leftJustify(line, maxWidth, charactersInLine));
                }

                line.clear();
                line.add(words[i]);
                charactersInLine = words[i].length();
            }
        }

        result.add(leftJustify(line, maxWidth, charactersInLine));
        return result;
    }

    public String fullJustify(List<String> line, int maxWidth, int totalCharacters) {
        int totalSpaces = maxWidth - totalCharacters;
        int spaceBetweenWords = totalSpaces / (line.size() - 1);
        int leftOverSpaces = totalSpaces % (line.size() - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.size(); i++) {
            if (i > 0) {
                for (int j = 0; j < spaceBetweenWords; j++) {
                    sb.append(" ");
                }
            }

            if (i > 0 && leftOverSpaces > 0) {
                sb.append(" ");
                leftOverSpaces--;
            }

            sb.append(line.get(i));
        }

        return sb.toString();
    }

    public String leftJustify(List<String> line, int maxWidth, int totalCharacters) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.size(); i++) {
            if (i > 0) sb.append(" ");
            sb.append(line.get(i));
        }

        while (sb.length() < maxWidth) {
            sb.append(" ");
        }

        return sb.toString();
    }
}