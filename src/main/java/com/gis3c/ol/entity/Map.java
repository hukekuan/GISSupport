package com.gis3c.ol.entity;

/**
 * Created by hukekuan on 2017/12/14.
 */
public class Map {
    private String mapId;
    private String mapName;
    private java.util.Map<String,Object> view;
    private String[][] controls;
    private Integer pixelRatio;
    private String[][] interactions;
    private String[][] layers;
    private Boolean logo = Boolean.FALSE;
    private String[][] overlays;
    private String description;

    public String getMapId() {
        return mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public java.util.Map<String,Object> getView() {
        return view;
    }

    public void setView(java.util.Map<String,Object> view) {
        this.view = view;
    }

    public String[][] getControls() {
        return controls;
    }

    public void setControls(String[][] controls) {
        this.controls = controls;
    }

    public Integer getPixelRatio() {
        return pixelRatio;
    }

    public void setPixelRatio(Integer pixelRatio) {
        this.pixelRatio = pixelRatio;
    }

    public String[][] getInteractions() {
        return interactions;
    }

    public void setInteractions(String[][] interactions) {
        this.interactions = interactions;
    }

    public String[][] getLayers() {
        return layers;
    }

    public void setLayers(String[][] layers) {
        this.layers = layers;
    }

    public Boolean getLogo() {
        return logo;
    }

    public void setLogo(Boolean logo) {
        this.logo = logo;
    }

    public String[][] getOverlays() {
        return overlays;
    }

    public void setOverlays(String[][] overlays) {
        this.overlays = overlays;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
