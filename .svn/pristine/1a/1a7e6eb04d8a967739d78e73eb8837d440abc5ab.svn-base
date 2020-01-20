package 线程.线程池;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import 线程.线程池.Task.State;

public class TaskQueue {
	private List<Task> listTask = new LinkedList<>();
	
	// 添加任务
	public synchronized void addTask(Task task) {
		if (task != null) {
			listTask.add(task);
		}
	}
	
	// 删除任务
	public void deleteTask(Task task) {
		if (task != null) {
			task.setState(State.FINISH);
			listTask.remove(task);
		}
	}
	
	// 取得一项待执行的任务
	public synchronized Task getTask() {
		Iterator<Task> iterator = listTask.iterator();
		Task task;
		while (iterator.hasNext()) {
			task = iterator.next();
			// 寻找一个新建任务
			if (Task.State.NEW.equals(task.getState())) {
				task.setState(Task.State.RUNNING);
				return task;
			}
		}
		return null;
	}
}
