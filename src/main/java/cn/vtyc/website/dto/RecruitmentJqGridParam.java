package cn.vtyc.website.dto;


import cn.vtyc.website.core.jqGrid.JqGridParam;
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
