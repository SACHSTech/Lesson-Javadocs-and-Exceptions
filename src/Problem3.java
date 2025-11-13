private boolean hasVowel(String word) {
    for (int i = 0; i < word.length(); i++) {
        char c = Character.toUpperCase(word.charAt(i));
        if ("AEIOU".indexOf(c) != -1) {
            return true;
        }
    }
    return false;
}