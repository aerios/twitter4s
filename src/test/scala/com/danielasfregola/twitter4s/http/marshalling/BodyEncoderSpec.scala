package com.danielasfregola.twitter4s.http.marshalling

import org.specs2.mutable.Specification

class BodyEncoderSpec extends Specification with BodyEncoder {

  "BodyEncoder" should {

    "encode a case class to a body with encoded params" in {
      case class TestData(d: Seq[Long], c: String, b: Option[Boolean], a: Int)

      val test = TestData(Seq(1,2,3),"Hello Ladies + Gentlemen, a signed OAuth request!", None, 5)
      val result = toBodyAsEncodedParams(test)
      result === "a=5&c=Hello+Ladies+%2B+Gentlemen%2C+a+signed+OAuth+request%21&d=1%2C2%2C3"
    }

    "encode a case class to a body with params" in {
      case class TestData(d: Seq[Long], c: String, b: Option[Boolean], a: Int)

      val test = TestData(Seq(1,2,3),"Hello Ladies + Gentlemen, a signed OAuth request!", None, 5)
      val result = toBodyAsParams(test)
      result === "a=5&c=Hello Ladies + Gentlemen, a signed OAuth request!&d=1,2,3"
    }

  }

}

