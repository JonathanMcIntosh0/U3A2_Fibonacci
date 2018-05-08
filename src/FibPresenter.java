class FibPresenter {

    private final FibModel fibModel;
    private final FibView fibView;

    FibPresenter(FibModel fibModel, FibView fibView) {
        this.fibModel = fibModel;
        this.fibView = fibView;
    }

    // SETUP

    private FibModel getModel() {
        return fibModel;
    }

    private FibView getView() {
        return fibView;
    }

    //INTERACTIONS

    private void updateView(String strIndex){
        String msg;

        if (Verifier.validInt(strIndex)) {
            int index = Integer.parseInt(strIndex);
            long num;

            try {
                num = getModel().getFibonacciNum(index);
                msg = MessageGetter.getAnswerMsg(index, num);
            } catch (ArithmeticException e) {
                msg = MessageGetter.getNumTooBigMsg(index);
            }

        } else {
            msg = MessageGetter.getInvalidIntMsg();
        }

        getView().getText().setText(msg);
    }

    void run() {
        getView().getTextField().textProperty().addListener(
                (observable, oldValue, newValue) ->
                        updateView(newValue)
        );
    }
}
