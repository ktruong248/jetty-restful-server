package org.jettyrest.api.employee

import scala.reflect.BeanProperty

class CreatedResponse {
  @BeanProperty
  var id: String = null

  def this(createdId: String) = {
    this()
    id = createdId
  }
}