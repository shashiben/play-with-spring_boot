package com.example.playwithsb.models;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "todo_item")
public class TodoItem {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank(message = "Title is required")
  private String title;

  @NotBlank(message = "Description is required")
  private String description;

  private Instant createdAt;
  private Instant updatedAt;
  private boolean complete;

  public TodoItem() {}

  public TodoItem(String title, String description) {
    this.title = title;
    this.description = description;
    this.createdAt = Instant.now();
    this.updatedAt = Instant.now();
    this.complete = false;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isComplete() {
    return complete;
  }

  public void setComplete(boolean complete) {
    this.complete = complete;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return String.format(
      "TodoItem{id=%d,Title='%s' description='%s', complete='%s', createdDate='%s', updatedAt='%s'}",
      id,
      title,
      description,
      complete,
      createdAt,
      updatedAt
    );
  }
}
