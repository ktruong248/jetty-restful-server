package org.jettyrest.api


trait EmployeeService[I, T] {
  def findById(id: I): T
  def save(objectToBeSave: T): I
  def delete(id: I)
}