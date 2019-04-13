package ru.training.bm.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Version;
import javax.persistence.Transient;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(schema = "bookmark_manager", name = "CATEGORIES")
public class Category implements Serializable, IHierarchyElement {
    private static final long serialVersionUID = -4759397049790260072L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "CATEGORIES_SEQ"
    )
    @SequenceGenerator(
            name = "CATEGORIES_SEQ"
            , sequenceName = "CATEGORIES_SEQ"
            , allocationSize = 1
            , schema = "BOOKMARK_MANAGER"
    )
    private Long id;

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "DESCRIPTION", length = 300)
    private String description;

    @CreationTimestamp
    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "LEVEL", nullable = false)
    private Short level;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TOP_ID")
    private Category top;

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private Set<Bookmark> bookmarks;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @Transient
    private Long parentId;

    @Transient
    private Long topId;

    @Transient
    private List<Long> subCategoryIds;

    @JsonIgnore
    @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Category> subCategories;

    public Category() {
        this.bookmarks = new HashSet<>();
        this.level = 0;
        this.subCategories = new HashSet<>();
    }

    public Category(String name) {
        this();
        this.name = name;
    }

    public Category(String name, String description, Set<Bookmark> bookmarks) {
        this(name);
        this.description = description;
        this.bookmarks = bookmarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Set<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(Set<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }

    @Override
    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    @Override
    public Short getLevel() {
        return level;
    }

    @Override
    public void setLevel(Short level) {
        this.level = level;
    }

    @Override
    public Category getTop() {
        return top;
    }

    @Override
    public void setTop(IHierarchyElement top) {
        this.top = (Category) top;
    }

    @Override
    public Long getParentId() {
        return parentId;
    }

    @Override
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Set<Category> getSubCategories() {
        return subCategories;
    }

    public void addSubcategory(Category subCategory){
        if(!subCategories.contains(subCategory)){
            subCategories.add(subCategory);
        }
    }

    public void removeSubCategory(Category subCategory){
        subCategories.remove(subCategory);
    }

    public void setSubCategories(Set<Category> subCategories) {
        this.subCategories = subCategories;
    }

    public void clearSubCategories(){
        this.subCategories.clear();
    }

    public Long getTopId() {
        return topId;
    }

    public void setTopId(Long topId) {
        this.topId = topId;
    }

    public List<Long> getSubCategoryIds() {
        return subCategoryIds;
    }

    public void setSubCategoryIds(List<Long> subCategoryIds) {
        this.subCategoryIds = subCategoryIds;
    }

}
