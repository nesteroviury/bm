package ru.training.bm.dto;

import java.util.List;

public class IdWrapper {

    private List<Long> ids;
    private Boolean truncate;

    public IdWrapper() {
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public Boolean getTruncate() {
        return truncate;
    }

    public void setTruncate(Boolean truncate) {
        this.truncate = truncate;
    }

    @Override
    public String toString() {
        return "IdWrapper{" +
                "ids=" + ids +
                ", truncate=" + truncate +
                '}';
    }

}
