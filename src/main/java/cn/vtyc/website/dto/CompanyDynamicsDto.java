package cn.vtyc.website.dto;

import cn.vtyc.website.entity.BaseEntity;
import lombok.Data;

@Data
public class CompanyDynamicsDto extends BaseEntity {
        private Integer id;
        private String title;
        private String content;
        private String contentDetail;
        private String locales;

}
