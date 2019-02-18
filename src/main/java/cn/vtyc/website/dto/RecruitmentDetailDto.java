package cn.vtyc.website.dto;

import cn.vtyc.website.entity.BaseEntity;
import lombok.Data;

@Data
public class RecruitmentDetailDto extends BaseEntity {
        private Integer id;
        private Integer recruitmentId;
        private String workTypeDesc;
        private String workType;
        private String workTitleDesc;
        private String workTitle;
        private String recruitNumDesc;
        private String recruitNum;
        private String sexDesc;
        private String sex;
        private String workNatureDesc;
        private String workNature;
        private String salaryDesc;
        private String salary;
        private String educationRequiredDesc;
        private String educationRequired;
        private String workDistinctDesc;
        private String workDistinct;
        private String languageDesc;
        private String language;
        private String departmentDesc;
        private String department;
        private String workLifeDesc;
        private String workLife;
        private String ageRequiredDesc;
        private String ageRequired;
        private String releaseTimeDesc;
        private String releaseTime;
        private String endTimeDesc;
        private String endTime;
        private String positionDesc;
        private String position;
        private String abilityDesc;
        private String ability;
        private String otherDesc;
        private String other;
        private String locales;
        private Integer groupId;

}
