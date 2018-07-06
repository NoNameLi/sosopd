package cn.sosopd.common.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageParams implements Serializable {
    private static final long serialVersionUID = -3612735054166960475L;

    private Integer currentPage;

    private Integer pageSize;
}
