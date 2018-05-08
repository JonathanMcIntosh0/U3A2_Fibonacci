class Verifier {
    static boolean validInt(String txt) {
        int n;
        try {
            n = Integer.parseInt(txt);
        } catch (NumberFormatException e) {
            return false;
        }
        return n > 0;
    }
}
