package cn.vtyc.website.dto;


import cn.vtyc.website.core.jqGrid.JqGridParam;
import lombok.Data;

/**
 * @author fonlin
 * @date 2018/4/24
 */
@Data
public class CompanyDynamicsJqGridParam extends JqGridParam {

    private String title;
    private String locales;
}
