package inpheller.com.quickooo.model;

/**
 * Created by brunopinheiro on 6/21/15.
 */
public class Subject {
    private String text;

    public Subject() {
        text = "";
    }

    public Subject(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
