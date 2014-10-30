package com.github.maxiaohao.quickslider.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Container {

    int containerId;
    String containerName;
    boolean disabled;
    String pageTitle;
    Map<String, String> styles = new TreeMap<String, String>();
    List<Slide> slides = new ArrayList<Slide>();


    public int getContainerId() {
        return containerId;
    }


    public void setContainerId(int containerId) {
        this.containerId = containerId;
    }


    public String getContainerName() {
        return containerName;
    }


    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }


    public boolean isDisabled() {
        return disabled;
    }


    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }


    public String getPageTitle() {
        return pageTitle;
    }


    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }


    /**
     * Note existing style with same name will be overwritten.
     *
     * @param name
     * @param value
     */
    public void addStyle(String name, String value) {
        if (null != name && name.length() > 0 && null != value && value.length() > 0) {
            styles.put(name, value);
        }
    }


    public void removeStyle(String name) {
        if (null != name) {
            styles.remove(name);
        }
    }


    public void clearStyles() {
        styles.clear();
    }


    public void addSlide(Slide slide) {
        if (slide != null) {
            slides.add(slide);
            Collections.sort(slides);
        }
    }


    public void clearSlides() {
        slides.clear();
    }


    public void setSlides(List<Slide> slideList) {
        slides.clear();
        slides.addAll(slideList);
        Collections.sort(slides);
    }


    public Map<String, String> getStyles() {
        return styles;
    }


    public List<Slide> getSlides() {
        return slides;
    }

}
