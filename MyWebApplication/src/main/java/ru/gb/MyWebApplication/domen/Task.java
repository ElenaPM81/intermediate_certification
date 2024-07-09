package ru.gb.MyWebApplication.domen;
import java.util.UUID;
import java.time.LocalDateTime;
public class Task {
    public Task(String name, String description) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
    }

    public enum Status {
        TO_DO,
        IN_PROGRESS,
        DONE
    }

    private  UUID id;
    private  String name;
    private  String description;
    private  Status status;
    private LocalDateTime  completionTime;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(LocalDateTime completionTime) {
        this.completionTime = completionTime;
    }
}
