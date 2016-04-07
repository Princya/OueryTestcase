package com.aeq.sql.testclass

/**
  * Created by princya on 30/3/16.
  */
import org.scalatest.{FunSuite,Matchers,FunSpec}
import com.aeq.sql.main.TableColumnMapping
class TableColumnMappingTest extends FunSuite with Matchers{
  val tableColumnMapping=new TableColumnMapping
  test("handle null"){
    intercept[NullPointerException]{
      tableColumnMapping.getTableAndColumn(null,null)
    }
  }
  test("get table and column"){
  val allColumns=Set("orders.orderdate", "customers.customerid", "orders.customerid", "customers.customername", "orders.orderid")
    val allTables=Set("orders", "customers")
    tableColumnMapping.getTableAndColumn(allColumns,allTables) shouldBe(Map("customers" -> List("customerid", "customername"), "orders" -> List("orderdate", "customerid", "orderid")))
  }
}
