package com.trendy.mifi.service;

import java.util.Properties;

/**
 * Created by admin on 17/11/14.
 */
public interface PropertiesService {

    /**
     * @param pdemo    propertiesTemplate
     * @param sfield   source field
     * @param tfields  target fields, split by ','
     * @param filePath
     * @param prefix
     * @param suffix
     */
    void makePropertiesFile(Properties pdemo, String sfield, String tfields,
                            String filePath, String prefix, String suffix);
}
