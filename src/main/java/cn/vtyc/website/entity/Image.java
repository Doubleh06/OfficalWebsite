package cn.vtyc.website.entity;

import lombok.Data;

@Data
public class Image extends BaseEntity {
    private String imgName;
    private String imgSourceName;
    private String uuid;
}
