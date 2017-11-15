package com.trendy.mifi.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by admin on 17/11/14.
 */
public class PropertiesUtil {

    public static Properties loadProps(String propPath) throws IOException {
        try (InputStream is = PropertiesUtil.class.getResourceAsStream(propPath);) {
            Properties prop = new Properties();
            prop.load(is);
            return prop;
        }
    }

    public static Properties loadProperties(String propPath) throws IOException {
        try (FileInputStream fis = new FileInputStream(new File(propPath));) {
            Properties prop = new Properties();
            prop.load(fis);
            return prop;
        }
    }

    public static void main(String[] args) throws IOException {
        Properties p = PropertiesUtil.loadProperties("/Users/admin/Documents/git-bd-file/file-repo/azkaban/job/rawdata/sap/AFS/oorder-ss-export/extract/extract-stg_afs_tvakt.job");
        System.out.println(p);
    }
}
