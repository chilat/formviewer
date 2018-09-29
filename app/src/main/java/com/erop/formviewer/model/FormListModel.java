package com.erop.formviewer.model;

/**
 * Created by Emmanuel Rop on 28/09/2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FormListModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("id_string")
    @Expose
    private String idString;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("url")
    @Expose
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdString() {
        return idString;
    }

    public void setIdString(String idString) {
        this.idString = idString;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
