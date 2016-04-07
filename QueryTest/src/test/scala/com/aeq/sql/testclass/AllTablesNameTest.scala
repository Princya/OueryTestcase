package com.aeq.sql.testclass

/**
  * Created by princya on 30/3/16.
  */
import com.aeq.sql.main.AllTablesName
import org.scalatest.{FunSuite, Matchers, FunSpec}

class AllTablesNameTest extends FunSuite with Matchers {
  val allTablesName = new AllTablesName()

  test("handle null properly") {
    intercept[NullPointerException] {
      val alaise=Set("orders","customers")
      allTablesName.getAllTables(alaise, null)
    }
  }
  test("Should return table names after from") {
    val columnsAfterFrom = List("orders.customerid=customers.customerid")
    val withoutKeywords = "orders customers orders.customerid=customers.customerid"
    allTablesName.tablesAsString(columnsAfterFrom, withoutKeywords) shouldBe("orders customers")
  }
  test("should return all table names") {
    val alaise = Set("orders", "customers")
    val tableString = "orders  customers"
    allTablesName.getAllTables(alaise, tableString) shouldBe(List("orders", "customers"))
  }
}