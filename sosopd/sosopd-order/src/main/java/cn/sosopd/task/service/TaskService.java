package cn.sosopd.task.service;

import java.util.List;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.task.dto.TaskCreateDto;
import cn.sosopd.task.dto.TaskDto;
import cn.sosopd.task.type.TaskStatusEnum;

public interface TaskService {

    /**
     * 创建初始任务
     * 
     * @throws ServiceException
     */
    Integer saveOrInitTask(TaskCreateDto taskDto) throws ServiceException;

    Integer upateTask(TaskDto taskDto) throws ServiceException;

    List<TaskDto> listTaskByStatus(TaskStatusEnum taskStatus);

}
