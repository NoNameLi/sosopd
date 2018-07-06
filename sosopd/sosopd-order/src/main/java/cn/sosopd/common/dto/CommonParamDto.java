package cn.sosopd.common.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共数据组织对象
 * 
 * @author remote
 *
 */
@Data
@NoArgsConstructor
public class CommonParamDto implements Serializable {
    private static final long serialVersionUID = -4504332533411101992L;

    private String id;

    private String text;

}
