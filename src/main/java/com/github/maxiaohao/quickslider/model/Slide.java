package com.github.maxiaohao.quickslider.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Slide implements Comparable<Slide> {

    int slideId;
    String slideName;
    String toolTip;
    boolean disabled;
    int displayOrder;

    Map<String, String> styles = new TreeMap<String, String>();
    List<Item> items = new ArrayList<Item>();


    public int getSlideId() {
        return slideId;
    }


    public void setSlideId(int slideId) {
        this.slideId = slideId;
    }


    public String getSlideName() {
        return slideName;
    }


    public void setSlideName(String slideName) {
        this.slideName = slideName;
    }


    public String getToolTip() {
        return toolTip;
    }


    public void setToolTip(String toolTip) {
        this.toolTip = toolTip;
    }


    public boolean isDisabled() {
        return disabled;
    }


    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }


    public int getDisplayOrder() {
        return displayOrder;
    }


    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }


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


    public void addItem(Item item) {
        if (null != item) {
            items.add(item);
        }
    }


    public Map<String, String> getStyles() {
        return styles;
    }


    public List<Item> getItems() {
        return items;
    }


    public void clearItems() {
        items.clear();
    }


    @Override
    public int compareTo(Slide o) {
        if (null != o) {
            return this.displayOrder < o.displayOrder ? 1 : -1;
        } else {
            return 0;
        }
    }

}
