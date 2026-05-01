package com.TaskManagement.TaskManagementPIC.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false, length = 160)
    private String title;
    @Column(columnDefinition = "text")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Status status = Status.TODO;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Priority priority = Priority.MEDIUM;
    @FutureOrPresent
    private Instant dueDate;
    @Column(nullable = false)
    private Long assigneeId;
    @Column(nullable = false, updatable = false)
    private Long createdById;
    @ElementCollection
    @CollectionTable(name="task_tags", joinColumns=@JoinColumn(name="task_id"))
    @Column(name="tag", length=32)
    private Set<String> tags = new HashSet<>();
    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();
    @Column(nullable = false)
    private Instant updatedAt = Instant.now();
    @Version
    private Long version;
    @PreUpdate
    public void onUpdate(){ this.updatedAt = Instant.now(); }
    public enum Status { TODO, IN_PROGRESS, BLOCKED, DONE }
    public enum Priority { LOW, MEDIUM, HIGH, CRITICAL }
}
