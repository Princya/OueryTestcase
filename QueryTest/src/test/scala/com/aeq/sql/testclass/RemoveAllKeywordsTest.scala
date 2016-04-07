package com.aeq.sql.testclass

/**
  * Created by princya on 30/3/16.
  */
import com.aeq.sql.main.RemoveAllKeywords
import org.scalatest.{FunSuite, Matchers, FunSpec}

class RemoveAllKeywordsTest extends FunSuite with Matchers{
  val removeAllKeywords = new RemoveAllKeywords

  test("handle null properly") {
    intercept[NullPointerException] {
      removeAllKeywords.removeKeywords(null)
    }
  }

  test("should remove keywords from query except ") {
  val keyWords=List("from","left join","on","where")
    val query="SELECT ID, NAME, AMOUNT, DATE FROM CUSTOMERS INNER JOIN ORDERS ON CUSTOMERS.ID = ORDERS.CUSTOMER_ID".toLowerCase()
    removeAllKeywords.removeKeywords(query) shouldBe("select id, name, amount, date  customers  orders  customers.id = orders.customer_id")

  }
}
