package org.jettyrest.api.employee.entities

import javax.persistence._
import java.util.Date

@Entity
class Employee() {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private var _id: String = null

  private var _name: String = null

  private var _dept: String = null

  @Temporal(value = TemporalType.DATE)
  private var _created: Date = null

  @Temporal(value = TemporalType.DATE)
  private var _modified: Date = null

  def this(n: String, d: String) {
    this ()
    name = n
    dept = d
    val now = new Date()
    created = now
    modified = now
  }

  def id = _id

  def id_=(i: String) = _id = i

  def name = _name

  def name_=(n: String): Unit = _name = n

  def dept = _dept

  def dept_=(d: String): Unit = _dept = d

  def created = _created

  def created_=(c: Date): Unit = _created = c

  def modified = _modified

  def modified_=(m: Date): Unit = _modified = m
}

