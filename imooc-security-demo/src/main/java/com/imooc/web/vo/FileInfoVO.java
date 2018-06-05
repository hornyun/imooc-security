package com.imooc.web.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/5
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@Data
public class FileInfoVO implements Serializable {

    private static final long serialVersionUID = -4960244552256905074L;

    private String path;

    public FileInfoVO() {
    }

    public FileInfoVO(String path) {
        this.path = path;
    }
}
