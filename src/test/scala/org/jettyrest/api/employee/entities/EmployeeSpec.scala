package org.jettyrest.api.employee.entities

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{BeforeAndAfter, Spec}

@RunWith(classOf[JUnitRunner])
class EmployeeSpec extends Spec with ShouldMatchers with BeforeAndAfter {
  var employee: Employee = _

  before {
    employee = new Employee("name", "dept")
  }

  describe("Employee spec") {

    it("should create new employee with created date the same as modified date") {
      employee.created should not be (null)
      employee.created should be(employee.modified)
    }

    it("should correct set name and dept") {
      employee.name should be("name")
      employee.dept should be("dept")
    }

    it("should be default not create populate created or modified") {
      employee = new Employee()

      employee.created should be(null)
      employee.modified should be(null)
    }
  }
}
