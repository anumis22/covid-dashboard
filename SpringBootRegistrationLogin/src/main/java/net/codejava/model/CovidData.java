package net.codejava.model;

import java.util.ArrayList;
import java.util.List;

public class CovidData {
    private List<CovidDetails> rows = new ArrayList<>();

    public List<CovidDetails> getRows() {
        return rows;
    }

    public void setRows(List<CovidDetails> rows) {
        this.rows = rows;
    }

    @Override public String toString() {
        return "CovidData{" + "rows=" + rows + '}';
    }
}
