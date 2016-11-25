package net.furikuri.skill.event;

import java.io.Serializable;

public class SkillAddedEvent implements Serializable {
  private String id;
  private String name;

  public SkillAddedEvent() {
  }

  public SkillAddedEvent(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
