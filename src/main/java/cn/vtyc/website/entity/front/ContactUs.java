package cn.vtyc.website.entity.front;


import cn.vtyc.website.entity.BaseEntity;
import lombok.Data;

/**
 * 菜单资源类（菜单及页面上的按钮链接等资源）
 *
 * @author fonlin
 * @date 2018/4/19
 */
@Data
public class ContactUs extends BaseEntity {
    private String title;
    private String hotLineDesc;
    private String hotLine;
    private String saleEmailDesc;
    private String saleEmail;
    private String purchaseEmailDesc;
    private String purchaseEmail;
    private String hotEmailDesc;
    private String hotEmail;
    private String addressDesc;
    private String address;

}
