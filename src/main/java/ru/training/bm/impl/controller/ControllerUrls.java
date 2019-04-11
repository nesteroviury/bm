package ru.training.bm.impl.controller;

public class ControllerUrls {

    public static final String ROOT = "api";

    public static final String BOOKMARK_CREATE = "/management/bookmark";
    public static final String BOOKMARK_GET = "/management/bookmark/{id}";
    public static final String BOOKMARK_GET_ALL = "/management/bookmarks/{page}/{size}";
    public static final String BOOKMARK_UPDATE = "/management/bookmark/{id}";
    public static final String BOOKMARK_DELETE = "/management/bookmark/{id}";
    public static final String BOOKMARK_DELETE_ALL = "/management/bookmarks/{categoryId}";
    public static final String BOOKMARK_DELETE_SELECTED = "/management/bookmarks";

    public static final String CATEGORY_CREATE = "/management/category";
    public static final String CATEGORY_GET = "/management/category{id}";
    public static final String CATEGORY_GET_ALL = "/management/categories/{page}/{size}";
    public static final String CATEGORY_UPDATE = "/management/category/{id}";
    public static final String CATEGORY_DELETE = "/management/category/{id}";
    public static final String CATEGORIES_DELETE_ALL = "/management/categories/{categoryId}";

}
