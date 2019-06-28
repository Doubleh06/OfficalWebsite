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
public class Recruitment extends BaseEntity {
    private String jobTitle;
    private String workLife;
    private Integer recruitNum;
    private String workDistinct;
    private String releaseTime;
    private String workNature;
    private String locales;
    private Integer groupId;

}
