public class LiveStep {
    private int id;
    private String description;

    private LiveChoice[] choices;

    public LiveStep(int id, String description, LiveChoice[] choices) {
        this.id = id;
        this.description = description;
        this.choices = choices;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LiveChoice[] getChoices() {
        return choices;
    }

    public void setChoices(LiveChoice[] choices) {
        this.choices = choices;
    }


}