package com.example.chat.task.model;

import com.example.chat.task.model.audit.UserDateAudit;
import org.hibernate.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "task")
public class Task  extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max=40)
    String name;

    @NotBlank
    @Size(max=200)
    String content;

    //@NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Instant date;



    //@NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Instant endDate;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;



    @ManyToMany
    @JoinTable(name = "task_status",
                joinColumns = @JoinColumn(name = "task_id"),
                inverseJoinColumns =@JoinColumn(name="status_id"))
    @Fetch(FetchMode.SELECT)
    private List<Status> statuses = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }
    public Instant getDate() {
        return date;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass())return false;
        Task task = (Task) obj;
        return Objects.equals(id, task.id);
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }
    public Instant getEndDate(){
        return  endDate;
    }
}
