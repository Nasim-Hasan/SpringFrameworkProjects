package com.TaskManagement.TaskManagementPIC.Service;

import com.TaskManagement.TaskManagementPIC.DTO.TaskDTO;
import com.TaskManagement.TaskManagementPIC.Entities.Task;
import com.TaskManagement.TaskManagementPIC.Repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository repo;
    private final AuthContext auth; // wraps SecurityContext for userId/roles

    @Transactional
    public TaskDTO.TaskRes create(TaskDTO.TaskCreateReq req){
        Task t = new Task();
        t.setTitle(req.title());
        t.setDescription(req.description());
        t.setPriority(req.priority());
        t.setDueDate(req.dueDate());
        t.setAssigneeId(req.assigneeId());
        t.setCreatedById(auth.userId());
        t.setTags(Optional.ofNullable(req.tags()).orElse(Set.of()));
        t = repo.save(t);
        return new TaskDTO.TaskRes(t.getId(), t.getTitle(), t.getDescription(), t.getStatus(), t.getPriority(),
                t.getDueDate(), t.getAssigneeId(), t.getCreatedById(),
                t.getTags(), t.getCreatedAt(), t.getUpdatedAt(), t.getVersion());
    }

    @Transactional(readOnly = true)
    public TaskDTO.TaskRes get(Long id) throws ChangeSetPersister.NotFoundException {
        Task t = repo.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        authorizeRead(t);
        return new TaskDTO.TaskRes(t.getId(), t.getTitle(), t.getDescription(), t.getStatus(), t.getPriority(),
                t.getDueDate(), t.getAssigneeId(), t.getCreatedById(),
                t.getTags(), t.getCreatedAt(), t.getUpdatedAt(), t.getVersion());
    }

    @Transactional
    public TaskDTO.TaskRes update(Long id, Long ifMatchVersion, TaskUpdateReq req) throws ChangeSetPersister.NotFoundException {
        Task t = repo.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        authorizeWrite(t);
        if(!Objects.equals(t.getVersion(), ifMatchVersion)){
            throw new ConflictException("Version conflict");
        }
        // apply updates...
        if(req.title()!=null) t.setTitle(req.title());
        if(req.status()!=null) t.setStatus(req.status());
        // etc.
        return toRes(t);
    }
    private void authorizeRead(Task t){
        if(auth.hasRole("ADMIN")) return;
        if(auth.hasRole("MANAGER") && auth.isInTeam(t.getAssigneeId())) return;
        if(t.getAssigneeId().equals(auth.userId()) || t.getCreatedById().equals(auth.userId())) return;
        throw new ForbiddenException("You do not have access to this task.");
    }

    private void authorizeWrite(Task t){ /* similar checks*/ }
    private TaskDTO.TaskRes toRes(Task t){ /* map fields */ }

}
