package ru.training.bm.dto;

import java.util.List;

public class IdWrapper {

    private List<Long> ids;

    public IdWrapper() {
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "IdWrapper{" +
                "ids=" + ids +
                '}';
    }

}
