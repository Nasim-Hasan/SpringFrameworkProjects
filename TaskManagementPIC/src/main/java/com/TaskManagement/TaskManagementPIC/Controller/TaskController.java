package com.TaskManagement.TaskManagementPIC.Controller;

import com.TaskManagement.TaskManagementPIC.DTO.TaskDTO;
import com.TaskManagement.TaskManagementPIC.Entities.Task;
import com.TaskManagement.TaskManagementPIC.Service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Page;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.awt.print.Pageable;
import java.time.Instant;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO.TaskRes create(@Valid @RequestBody TaskDTO.TaskCreateReq req){
        return service.create(req);
    }

    @GetMapping("/{id}")
    public TaskDTO.TaskRes get(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return service.get(id); }

    @PutMapping("/{id}")
    public TaskDTO.TaskRes put(@PathVariable Long id,
                               @RequestHeader("If-Match") Long version,
                               @Valid @RequestBody TaskUpdateReq req) throws ChangeSetPersister.NotFoundException {
        return service.update(id, version, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id, @RequestHeader("If-Match") Long version){
        service.delete(id, version);
    }

    @GetMapping
    public Page<TaskDTO.TaskRes> search(
            @RequestParam(required=false) Task.Status status,
            @RequestParam(required=false) Task.Priority priority,
            @RequestParam(required=false) Long assigneeId,
            @RequestParam(required=false) Instant dueBefore,
            @RequestParam(required=false) Instant dueAfter,
            @RequestParam(required=false) String q,
            Pageable pageable){
        return service.search(status, priority, assigneeId, dueBefore, dueAfter, q, pageable);
    }

}
