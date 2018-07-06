package cn.sosopd.task.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import cn.sosopd.task.type.TaskUpdateValidatorGroup;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
public class TaskDto {
    /**
     * 任务id
     */
    @NotNull(groups = TaskUpdateValidatorGroup.class)
    private Integer taskId;

    /**
     * 任务的工单
     */
    private Integer orderId;

    /**
     * 任务类型（在任务模板中定义）
     */
    private String taskType;

    /**
     * 任务执行时间线
     */
    private Date taskExecDatetime;

    /**
     * 任务的状态
     */
    private String taskStatus;

    /**
     * 执行结果备注
     */
    private String taskResult;

    /**
     * 
     */
    private Date createDatetime;

    /**
     * 
     */
    private Date lastSyncDatetime;

}