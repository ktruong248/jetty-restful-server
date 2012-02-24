package org.jettyrest.api

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{BeforeAndAfter, Spec}

@RunWith(classOf[JUnitRunner])
class BaseResourceSpec extends Spec with ShouldMatchers with BeforeAndAfter {

  describe("BaseResource") {


    before {
      println("before ")
    }

    it("should do a") {
      1 + 1 should be(2)
    }
  }
}