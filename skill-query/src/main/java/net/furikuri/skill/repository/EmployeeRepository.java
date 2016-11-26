package net.furikuri.skill.repository;


import net.furikuri.skill.domain.Employee;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {
}
