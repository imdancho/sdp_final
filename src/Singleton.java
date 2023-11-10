class SchoolManager extends Notify{
    private static SchoolManager instance;
    private String complaints = "";

    private SchoolManager() {
    }

    public static SchoolManager getInstance() {
        if (instance == null) {
            instance = new SchoolManager();
        }
        return instance;
    }

    public void setComplaints(String complaints) {
        String complaints_new = complaints.replace(" ", "_");
        this.complaints += complaints_new;
        this.complaints += "\n";
    }

    public String getComplaints() {
        return complaints;
    }

    // Other methods and fields related to managing the school system
}
