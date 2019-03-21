package ru.training.bm.api.domain;

public interface IHierarchyElement {
    IHierarchyElement getParent();

    Short getLevel();

    void setLevel(Short level);

    IHierarchyElement getTop();

    void setTop(IHierarchyElement top);

    Long getParentId();

    void setParentId(Long parentId);
}
