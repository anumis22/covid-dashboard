package covid.dashboard.model;

public class Response {
    private CovidData data;

    public CovidData getData() {
        return data;
    }

    public void setData(CovidData data) {
        this.data = data;
    }

    @Override public String toString() {
        return "Response{" + "data=" + data + '}';
    }
}
