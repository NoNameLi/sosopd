package cn.sosopd.task.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
public class TaskCreateDto {
    /**
     * 任务id
     */
    private Integer taskId;

    /**
     * 任务的工单
     */
    @NotNull
    private Integer orderId;

    /**
     * 任务执行时间线
     */
    @NotNull
    private Date taskExecDatetime;

}