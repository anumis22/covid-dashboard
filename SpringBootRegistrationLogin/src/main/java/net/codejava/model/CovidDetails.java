package net.codejava.model;

public class CovidDetails {
    private String country;
    private String total_cases;
    private String new_cases;
    private String total_deaths;
    private String new_deaths;
    private String total_recovered;
    private String active_cases;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTotal_cases() {
        return total_cases;
    }

    public void setTotal_cases(String total_cases) {
        this.total_cases = total_cases;
    }

    public String getNew_cases() {
        return new_cases;
    }

    public void setNew_cases(String new_cases) {
        this.new_cases = new_cases;
    }

    public String getTotal_deaths() {
        return total_deaths;
    }

    public void setTotal_deaths(String total_deaths) {
        this.total_deaths = total_deaths;
    }

    public String getNew_deaths() {
        return new_deaths;
    }

    public void setNew_deaths(String new_deaths) {
        this.new_deaths = new_deaths;
    }

    public String getTotal_recovered() {
        return total_recovered;
    }

    public void setTotal_recovered(String total_recovered) {
        this.total_recovered = total_recovered;
    }

    public String getActive_cases() {
        return active_cases;
    }

    public void setActive_cases(String active_cases) {
        this.active_cases = active_cases;
    }

    @Override public String toString() {
        return "CovidDetails{" + "country='" + country + '\'' + ", total_cases='" + total_cases
            + '\'' + ", new_cases='" + new_cases + '\'' + ", total_deaths='" + total_deaths + '\''
            + ", new_deaths='" + new_deaths + '\'' + ", total_recovered='" + total_recovered + '\''
            + ", active_cases='" + active_cases + '\'' + '}';
    }
}
