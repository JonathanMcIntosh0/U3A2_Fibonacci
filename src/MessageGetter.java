class MessageGetter {

    static String getAnswerMsg(int index, long number) {
        return "Le nombre Fibonacci au " + index + "e rang est : " + number;
    }

    static String getInvalidIntMsg() {
        return "SVP entrer un entier positif plus que zero!";
    }

    static String getNumTooBigMsg(int index) {
        return (
                "Le nombre Fibonacci au " + index + "e rang est trops grands!\n" +
                        "SVP entrer un rang plus petit!"
        );
    }
}
