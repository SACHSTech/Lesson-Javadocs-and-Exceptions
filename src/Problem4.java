private int safePercent(int part, int whole) {
    if (whole == 0) {
        throw new IllegalArgumentException("whole must be non-zero");
    }
    return (part * 100) / whole;
}