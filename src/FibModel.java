/**
 *Database
 */
public class FibModel {

    private int index;
    private boolean currentIndexValide = false;

    int getIndex() {
        return index;
    }

    void setIndex(int index) {
        this.index = index;
    }

    boolean isCurrentIndexValide() {
        return currentIndexValide;
    }

    void setCurrentIndexValide(boolean currentIndexValide) {
        this.currentIndexValide = currentIndexValide;
    }
}
