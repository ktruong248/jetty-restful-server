package org.jettyrest.api.employee

import entities.Employee
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import org.slf4j.{LoggerFactory, Logger}
import sun.reflect.generics.reflectiveObjects.NotImplementedException
import org.springframework.beans.factory.annotation.Autowired
import org.jettyrest.api.EmployeeService
import reflect.BeanProperty
import java.util.Date

@Component
@Transactional
class EmployeeServiceImpl extends EmployeeService[Employee, String] {
  private val log: Logger = LoggerFactory.getLogger(classOf[EmployeeServiceImpl])

  @Autowired
  @BeanProperty
  var repository: EmployeeRespository = null

  def update(uuid: String, attributeName: String, attributeValue: String): Unit = {
    throw new NotImplementedException
  }

  def save(entity: Employee): String = {
    if( entity.created == null ) {
      val now = new Date()
      entity.modified = now
      entity.created = now
    }
    return repository.save(entity).id
  }

  def findById(uuid: String): Employee = {
    return repository.findOne(uuid)
  }

  def delete(uuid: String): Unit = {
    repository.delete(uuid)
    log.info("deleted {}", uuid)
  }
}