package cn.vtyc.officalWebsite.dto;

import cn.vtyc.officalWebsite.entity.BaseEntity;
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
