package com.TaskManagement.TaskManagementPIC.Repository;

import com.TaskManagement.TaskManagementPIC.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.awt.print.Pageable;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {
    List<Task> findByAssigneeId(Long assigneeId, Pageable pageable);
}
