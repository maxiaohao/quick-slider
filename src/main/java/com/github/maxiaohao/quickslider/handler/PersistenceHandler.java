package com.github.maxiaohao.quickslider.handler;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.github.maxiaohao.quickslider.model.Container;
import com.github.maxiaohao.quickslider.util.JsonUtils;

public class PersistenceHandler {

    private static PersistenceHandler singleton = null;

    private static Map<Integer, Container> containers = new TreeMap<Integer, Container>();

    private static final String storeDirectory = System.getProperty("user.home") + "/.quick-slider";

    static {
        File dir = new File(storeDirectory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }


    public static PersistenceHandler getInstance() {
        if (null == singleton) {
            // "double lock lazy loading" for singleton instance loading on first time usage
            synchronized (PersistenceHandler.class) {
                if (null == singleton) {
                    singleton = new PersistenceHandler();
                }
            }
        }
        return singleton;
    }


    public void loadAll() {
        File dir = new File(storeDirectory);
        File jsonFiles[] = dir.listFiles(new FileFilter() {

            @Override
            public boolean accept(File f) {
                if (null != f && f.isFile() && f.exists() && f.getName().toLowerCase().endsWith(".json")) {
                    return true;
                } else {
                    return false;
                }
            }
        });

        if (jsonFiles != null && jsonFiles.length > 0) {

            containers.clear();

            for (File f : jsonFiles) {

                Container container = null;
                try {
                    container = JsonUtils.readObject(f, Container.class);
                } catch (JsonParseException e) {
                    // TODO
                    e.printStackTrace();
                } catch (JsonMappingException e) {
                    // TODO
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO
                    e.printStackTrace();
                }

                if (null != container) {
                    containers.put(container.getContainerId(), container);
                }

            }
        }
    }


    public void saveAll() {
        for (int containerId : containers.keySet()) {
            save(containerId);
        }
    }


    /**
     * Save container object as json file.
     *
     * @param object
     */
    public void save(int containerId) {
        Container container = containers.get(containerId);
        if (null != container) {
            File newFile = new File(new File(storeDirectory), "container-" + containerId + ".json");
            try {
                FileWriter fileWriter = new FileWriter(newFile, false);
                JsonUtils.writeAsJson(fileWriter, container, true);
                fileWriter.close();
            } catch (JsonGenerationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (JsonMappingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    public void addContainer(Container container) {
        if (null != container) {
            containers.put(container.getContainerId(), container);
        }
    }


    public Container getContainer(int containerId) {
        return containers.get(containerId);
    }
}
