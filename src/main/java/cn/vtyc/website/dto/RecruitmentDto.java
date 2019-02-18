package cn.vtyc.website.dto;

import cn.vtyc.website.entity.BaseEntity;
import lombok.Data;

@Data
public class RecruitmentDto extends BaseEntity {
        private Integer id;
        private String jobTitle;
        private String workLife;
        private Integer recruitNum;
        private String workDistinct;
        private String releaseTime;
        private String workNature;
        private String locales;
        private Integer groupId;

}
