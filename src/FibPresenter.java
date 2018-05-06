import javafx.application.Application;

class FibPresenter {

    private FibModel fibModel;
    private FibView fibView;

    // SETUP

    FibModel getModel() {
        return fibModel;
    }

    void setModel(FibModel fibModel) {
        this.fibModel = fibModel;
    }

    FibView getView() {
        return fibView;
    }

    void setView(FibView fibView) {
        this.fibView = fibView;
    }

    //INTERACTIONS

    void updateModelFromView(String strIndex) {
        if (!Verifier.validInt(strIndex)) {
            getModel().setCurrentIndexValide(false);
            getView().setMsg(MessageGetter.getInvalidIntMsg());
        } else {
            getModel().setCurrentIndexValide(true);
            getModel().setIndex(Integer.parseInt(strIndex));
            getView().setMsg(MessageGetter.clearMsg());
        }
    }

    void updateMsgFromModel() {
        if (getModel().isCurrentIndexValide()) {
            int index = getModel().getIndex();
            long num;
            String msg;
            try {
                num = FibonacciGetter.getFibonacciNum(index);
                msg = MessageGetter.getAnswerMsg(index, num);
            } catch (ArithmeticException e) {
                msg = MessageGetter.getNumTooBigMsg(index);
            }
            getView().setMsg(msg);

        }
    }

    //RUN PROGRAM

    void run(String[] args) {
        fibView.setPresenter(this);
        Application.launch(FibView.class, args);
    }
}
