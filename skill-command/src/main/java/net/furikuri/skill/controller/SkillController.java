package net.furikuri.skill.controller;

import net.furikuri.skill.command.AddSkillCommand;
import net.furikuri.skill.command.DeleteSkillCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
class SkillController {

  @Autowired
  CommandGateway commandGateway;

  @RequestMapping(value = "/{employeeId}/skills/{skill}", method = RequestMethod.PUT)
  String addSkill(@PathVariable("employeeId") String id, @PathVariable("skill") String skill) {
    commandGateway.send(new AddSkillCommand(id, skill));
    return "ok";
  }

  @RequestMapping(value = "/{employeeId}/skills/{skill}", method = RequestMethod.DELETE)
  String deleteSkill(@PathVariable("employeeId") String id, @PathVariable("skill") String skill) {
    commandGateway.send(new DeleteSkillCommand(id, skill));
    return "ok";
  }
}
