package com.imooc.web.controller;

import com.imooc.web.vo.FileInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/5
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FilterController {
    private String folder = "D:\\tem\\pratice\\imooc-security\\imooc-security-demo\\src\\main\\resources\\static";

    @PostMapping
    public FileInfoVO upload(MultipartFile file) {
        log.info("【file = {}】", file);

        File localFile = new File(folder, System.currentTimeMillis() + ".txt");

        try {
            file.transferTo(localFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new FileInfoVO(localFile.getAbsolutePath());
    }

    @GetMapping("/download/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        InputStream inputStream = new FileInputStream(new File(folder, id + ",txt"));
        OutputStream outputStream = response.getOutputStream();

        response.setContentType("application/x-download");
        response.addHeader("Content-Type", "attachment;filename=test.txt");
        IOUtils.copy(inputStream, outputStream);

    }

}
