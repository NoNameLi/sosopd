package cn.sosopd.task.service.impl;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.common.util.ObjectConverter;
import cn.sosopd.common.validator.BeanValidator;
import cn.sosopd.common.validator.ParamValidator;
import cn.sosopd.task.dto.TaskCreateDto;
import cn.sosopd.task.dto.TaskDto;
import cn.sosopd.task.entity.SosopdTask;
import cn.sosopd.task.entity.SosopdTaskExample;
import cn.sosopd.task.mapper.SosopdTaskMapper;
import cn.sosopd.task.service.TaskService;
import cn.sosopd.task.type.TaskStatusEnum;
import cn.sosopd.task.type.TaskUpdateValidatorGroup;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private SosopdTaskMapper mapper;

	@Override
	public Integer createInitTask(TaskCreateDto taskDto) throws ServiceException {

		ParamValidator.assertNotNull(taskDto, "更新数据不能为空");
		BeanValidator.validate(taskDto);

		SosopdTask record = ObjectConverter.convert(taskDto, SosopdTask.class);
		// 补全其他必要数据
		record.setCreateDatetime(DateTime.now().toDate()).setTaskStatus(TaskStatusEnum.executing.name());
		return mapper.insertUpdate(record);
	}

	@Override
	public Integer upateTask(TaskDto taskDto) throws ServiceException {

		ParamValidator.assertNotNull(taskDto, "更新数据不能为空");
		BeanValidator.validate(taskDto, TaskUpdateValidatorGroup.class);
		SosopdTask record = ObjectConverter.convert(taskDto, SosopdTask.class);
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<TaskDto> queryTaskByStatus(TaskStatusEnum taskStatus) {

		SosopdTaskExample example = new SosopdTaskExample();
		example.createCriteria().andTaskStatusEqualTo(taskStatus.name());
		List<SosopdTask> list = mapper.selectByExample(example);
		return ObjectConverter.convert(list, TaskDto.class);
	}

}
