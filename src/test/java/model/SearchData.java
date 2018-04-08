package model;

public class SearchData {
    private String query;

    //Getters
    public String getQuery() {
        return query;
    }

    //Setters
    public SearchData setQuery(String query) {
        this.query = query;
        return this;
    }

    @Override
    public String toString() {
        return "SearchData{" +
                "query='" + query + '\'' +
                '}';
    }
}
