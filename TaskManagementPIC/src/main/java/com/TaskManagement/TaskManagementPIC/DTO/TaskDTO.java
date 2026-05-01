package com.TaskManagement.TaskManagementPIC.DTO;

import com.TaskManagement.TaskManagementPIC.Entities.Task;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Instant;
import java.util.Set;

public class TaskDTO {
    public record TaskCreateReq(
            @NotBlank
            String title,
            String description,
            @NotNull
            Task.Priority priority,
            @FutureOrPresent
            Instant dueDate,
            @NotNull
            Long assigneeId,
            Set<@Size(max=32) String> tags
    ) {}

    public record TaskRes(
            Long id, String title, String description,
            Task.Status status, Task.Priority priority,
            Instant dueDate, Long assigneeId, Long createdById,
            Set<String> tags, Instant createdAt, Instant updatedAt, Long version
    ) {}
}
