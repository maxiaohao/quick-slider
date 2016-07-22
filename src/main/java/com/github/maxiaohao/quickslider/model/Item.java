package com.github.maxiaohao.quickslider.model;

import java.util.Map;
import java.util.TreeMap;

public class Item {

    int itemId;
    String itemName;
    String toolTip;

    /**
     * The html text as the child of the &lt;div&gt; as item content.
     */
    String html;

    /**
     * Attributes of the &lt;div&gt; for the item itself.
     */
    Map<String, String> attributes = new TreeMap<String, String>();

    /**
     * Styles of the &lt;div&gt; for the item itself.
     */
    Map<String, String> styles = new TreeMap<String, String>();


    public int getItemId() {
        return itemId;
    }


    public void setItemId(int itemId) {
        this.itemId = itemId;
    }


    public String getItemName() {
        return itemName;
    }


    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    public String getToolTip() {
        return toolTip;
    }


    public void setToolTip(String toolTip) {
        this.toolTip = toolTip;
    }


    public String getHtml() {
        return html;
    }


    public void setHtml(String html) {
        this.html = html;
    }


    public void addAttribute(String name, String value) {
        if (null != name && name.length() > 0 && null != value && value.length() > 0) {
            attributes.put(name, value);
        }
    }


    public void removeAttribute(String name) {
        if (null != name) {
            attributes.remove(name);
        }
    }


    public void clearAttributes() {
        attributes.clear();
    }


    public Map<String, String> getAttributes() {
        return attributes;
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


    public Map<String, String> getStyles() {
        return styles;
    }

}
