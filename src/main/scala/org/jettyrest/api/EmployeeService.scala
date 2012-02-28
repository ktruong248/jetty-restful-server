package org.jettyrest.api


trait EmployeeService[T, I] {
  def findById(id: I): T
  def save(objectToBeSave: T): I
  def delete(id: I)
}