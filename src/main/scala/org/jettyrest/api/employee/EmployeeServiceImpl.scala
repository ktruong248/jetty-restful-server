package org.jettyrest.api.employee

import entities.Employee
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import org.jettyrest.api.SEmployeeService
import org.slf4j.{LoggerFactory, Logger}
import repositories.EmployeeRepository
import sun.reflect.generics.reflectiveObjects.NotImplementedException
import org.springframework.beans.factory.annotation.Autowired

@Component
@Transactional
class EmployeeServiceImpl {
  private val log: Logger = LoggerFactory.getLogger(classOf[JEmployeeServiceImpl])
  private var repository: EmployeeRepository = null

  @Autowired def setRepository(repository: EmployeeRepository): Unit = {
    this.repository = repository
  }

  def update(uuid: String, attributeName: String, attributeValue: String): Unit = {
    throw new NotImplementedException
  }

  def save(entity: Employee): String = {
    return repository.save(entity).id
  }

  def findByUUID(uuid: String): Employee = {
    return repository.findOne(uuid)
  }

  def deleteByUUID(uuid: String): Unit = {
    repository.delete(uuid)
    log.info("deleted {}", uuid)
  }
}