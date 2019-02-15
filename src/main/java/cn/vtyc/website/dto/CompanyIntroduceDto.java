package cn.vtyc.website.dto;

import cn.vtyc.website.entity.BaseEntity;
import lombok.Data;

@Data
public class CompanyIntroduceDto extends BaseEntity {
        private Integer id;
        private String introduce;
        private String czCompany;
        private String cqCompany;
        private String czCompanyLabel;
        private String cqCompanyLabel;
        private String companyLabel;
}
