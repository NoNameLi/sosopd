package cn.sosopd.test;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.task.dto.TaskCreateDto;
import cn.sosopd.task.service.TaskService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext-all.xml" })
public class TaskServiceTest {

	@Autowired
	private TaskService taskService;

	@Test
	public void insertTask() {

		TaskCreateDto taskDto = TaskCreateDto.builder().orderId(1).taskExecDatetime(DateTime.now().toDate()).build();
		try {
			System.out.println(taskService.createInitTask(taskDto));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
}
