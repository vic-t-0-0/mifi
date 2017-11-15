package com.trendy.mifi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MifiApplication {

    /**
     * input args to make files
     * //TODO
     * args:
     * 1. input way -url/-file
     * 2. inputPath or url
     * 3. input fileType (json,properties)
     * 4. source field
     * 5. target fields
     * 6. outputPath
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(MifiApplication.class, args);

    }
}
