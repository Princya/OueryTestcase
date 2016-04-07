package com.aeq.sql.testclass

/**
  * Created by princya on 29/3/16.
  */
import com.aeq.sql.main.SplitQuery
import org.scalatest.{FunSuite, Matchers, FunSpec}

class SplitQueryTest extends FunSuite with Matchers {
  val splitQ = new SplitQuery

  test("handle null properly") {
    intercept[NullPointerException] {
      splitQ.splitQuery(null)
    }
  }
  test (" split query based on FROM keyword"){
    val query="SELECT Orders.OrderID, Customers.CustomerName, Orders.OrderDate FROM Orders INNER JOIN Customers ON Orders.CustomerID=Customers.CustomerID"
    splitQ.splitQuery(query) shouldBe (List("select orders.orderid, customers.customername, orders.orderdate " ,  " orders inner join customers on orders.customerid=customers.customerid"))
  }

}
