package org.jettyrest.api.employee.entities

import javax.persistence._
import java.util.Date
import scala.reflect.BeanProperty

@Entity
class Employee() {

  @BeanProperty
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  var id: String = null

  @BeanProperty
  var name: String = null

  @BeanProperty
  var dept: String = null

  @Temporal(value = TemporalType.DATE)
  @BeanProperty
  var created: Date = null

  @Temporal(value = TemporalType.DATE)
  @BeanProperty
  var modified: Date = null

  def this(n: String, d: String) {
    this ()
    name = n
    dept = d
    val now = new Date()
    created = now
    modified = now
  }
}

