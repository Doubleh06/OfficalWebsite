package cn.vtyc.website.dto;

import cn.vtyc.website.entity.BaseEntity;
import lombok.Data;

@Data
public class HomeIntroduceDto extends BaseEntity {
        private Integer id;
        private String title;
        private String content;

}
