package cn.vtyc.officalWebsite.dto;

import cn.vtyc.officalWebsite.entity.BaseEntity;
import lombok.Data;

@Data
public class CompanyDynamicsDto extends BaseEntity {
        private Integer id;
        private String title;
        private String content;
        private String contentDetail;
        private String locales;

}
