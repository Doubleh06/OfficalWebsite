package cn.vtyc.officalWebsite.dto;


import cn.vtyc.officalWebsite.core.jqGrid.JqGridParam;
import lombok.Data;

/**
 * @author fonlin
 * @date 2018/4/24
 */
@Data
public class RecruitmentJqGridParam extends JqGridParam {

    private String jobTitle;
    private String locales;
}
