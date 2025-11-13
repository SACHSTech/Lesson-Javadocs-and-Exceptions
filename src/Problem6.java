private int difference(int a, int b) {
    if (a < b) {
        throw new IllegalArgumentException("a must be >= b");
    }
    return a - b;
}