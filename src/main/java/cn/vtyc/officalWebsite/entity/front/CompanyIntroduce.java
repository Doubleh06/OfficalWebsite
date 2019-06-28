package cn.vtyc.officalWebsite.entity.front;


import cn.vtyc.officalWebsite.entity.BaseEntity;
import lombok.Data;

/**
 * 菜单资源类（菜单及页面上的按钮链接等资源）
 *
 * @author fonlin
 * @date 2018/4/19
 */
@Data
public class CompanyIntroduce extends BaseEntity {
    private String introduce;
    private String czCompany;
    private String cqCompany;
    private String czImg;
    private String cqImg;
    private String locales;
    private String czCompanyLabel;
    private String cqCompanyLabel;
    private String companyLabel;

}
