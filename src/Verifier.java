class Verifier {

    static boolean validInt(String txt) {
        int n;
        try {
            n = Integer.parseInt(txt);
        } catch (NumberFormatException e) {
            return false;
        }
        if (n <= 0) {
            return false;
        }
        return true;
    }
}
