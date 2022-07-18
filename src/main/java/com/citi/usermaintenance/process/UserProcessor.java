package com.citi.usermaintenance.process;

import com.citi.usermaintenance.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;


@Slf4j
public class UserProcessor {

    public void process() throws Exception{
        List<String> users = FileUtils.readLines(new File(AppConfig.INPUT_FILE), Charset.defaultCharset()
            .displayName());

        log.info("Processing user records size={}", users);

        users.stream().forEach(u -> new XXXUserAction().process(u));


    }
}
