package net.furikuri.skill;

import net.furikuri.skill.command.AddEmployeeCommand;
import net.furikuri.skill.command.AddSkillCommand;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillController {

  @Autowired
  CommandGateway commandGateway;

  @RequestMapping(value = "/")
  public String addSkill() {
    commandGateway.sendAndWait(new AddSkillCommand("id", "skill"));
    return "ok";
  }

  @RequestMapping(value = "/add")
  public String addEmployee() {
    commandGateway.sendAndWait(new AddEmployeeCommand("id", "name"));
    return "ok";
  }
}
