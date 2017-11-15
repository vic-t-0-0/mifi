package com.trendy.mifi;

import com.trendy.mifi.service.JsonService;
import com.trendy.mifi.service.PropertiesService;
import com.trendy.mifi.utils.PropertiesUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MifiApplicationTests {

    @Autowired
    JsonService jsonService;

    @Autowired
    PropertiesService propertiesService;

    @Test
    public void contextLoads() {
        String jsonDemo = "{\n" +
                "  \"prestoServer\": {\n" +
                "    \"host\": \"fp-bd3\",\n" +
                "    \"port\": 10300 ,\n" +
                "    \"user\": \"dev\"\n" +
                "  },\n" +
                "  \"from\": {\n" +
                "    \"catalog\" \"dev_psql_sap\",\n" +
                "    \"schema\": \"stg\",\n" +
                "    \"table\": \"stg_afs_kna1\"\n" +
                "  },\n" +
                "  \"to\": {\n" +
                "    \"catalog\": \"dev_hive\",\n" +
                "    \"schema\": \"ods_stg\",\n" +
                "    \"table\": \"stg_afs_kna1\"\n" +
                "  }\n" +
                "}";
        String sfield = "to.table";
        String tfield = "abc,abd,bcd,bcc,bdd";
        String filePath = "/Users/admin/Documents/tmpFiles";
        jsonService.makeJsonFiles(jsonDemo, sfield, tfield, filePath, null, null);
    }

    @Test
    public void testProperties() throws IOException {
        String filePath = "/Users/admin/Documents/tmpFiles";
        propertiesService.makePropertiesFile(
                PropertiesUtil.loadProperties("/Users/admin/Documents/git-bd-file/file-repo/azkaban/job/" +
                        "rawdata/sap/AFS/porder-ss-export/extract/extract-stg_ret_ekbz.job"),
                filePath,
                "json.name",
                "stg_ret_eine.json," +
                        "stg_ret_ekbe.json," +
                        "stg_ret_ekbz.json," +
                        "stg_ret_ekko.json," +
                        "stg_ret_ekpo.json," +
                        "stg_ret_knov.json",
                "extract-", ".job"
        );
    }


}

