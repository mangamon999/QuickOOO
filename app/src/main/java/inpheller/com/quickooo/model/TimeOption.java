package inpheller.com.quickooo.model;

import java.util.ArrayList;

/**
 * Created by brunopinheiro on 5/24/15.
 */
public class TimeOption {
    private String title;
    private String description;
    private String message;
    private ArrayList<TimeOption> subOptions;

    public TimeOption() {

    }

    public TimeOption(String title, String description, String message) {
        setTitle(title);
        setDescription(description);
        setMessage(message);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public ArrayList<TimeOption> getSubOptions() {
         if (this.subOptions == null) {
            this.subOptions = new ArrayList<>();
        }
        return subOptions;
    }

    public void setSubOptions(ArrayList<TimeOption> subOptions) {
        this.subOptions = subOptions;
    }

    public void addSubOption(TimeOption option) {
        getSubOptions().add(option);
    }

    public void removeSubOption(TimeOption timeOption) {
        getSubOptions().remove(timeOption);
    }

    public boolean isFinal() {
        return getSubOptions().isEmpty();
    }
}
