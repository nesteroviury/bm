package ru.training.bm.api.json;

/**
 * Used to filter category fields during serialization
 */
public class View {

    /**
     * Used to change base category data: name, description, parentId
     */
    public static class UI {}

    /**
     * Used to change category bookmark list
     */
    public static class BOOKMARKS {}

    /**
     * Used to change category subcategory list
     */
    public static class SUBCATEGORIES {}

}
