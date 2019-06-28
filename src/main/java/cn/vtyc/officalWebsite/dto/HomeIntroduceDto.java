package cn.vtyc.officalWebsite.dto;

import cn.vtyc.officalWebsite.entity.BaseEntity;
import lombok.Data;

@Data
public class HomeIntroduceDto extends BaseEntity {
        private Integer id;
        private String title;
        private String content;

}
