package cn.vtyc.officalWebsite.dto;

import cn.vtyc.officalWebsite.entity.BaseEntity;
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
