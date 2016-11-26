package net.furikuri.skill.controller;

import net.furikuri.skill.domain.Employee;
import net.furikuri.skill.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;

@RestController
public class EmployeeController {

  @Autowired
  private EmployeeRepository repository;

  @RequestMapping("/{id}")
  public Employee get(@PathVariable(name = "id") String id) {
    return repository.findOne(id);
  }

  @RequestMapping("/search")
  public Page<Employee> search(@RequestParam("q") String query) {
    return repository.search(new NativeSearchQueryBuilder()
      .withQuery(multiMatchQuery(query, "_id", "*Name", "skills"))
      .build());
  }
}
