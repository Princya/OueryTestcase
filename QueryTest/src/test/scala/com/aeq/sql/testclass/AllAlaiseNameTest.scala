package com.aeq.sql.testclass

/**
  * Created by princya on 30/3/16.
  */
import org.scalatest.{FunSuite,Matchers,FunSpec}
import com.aeq.sql.main.AllAlaiseName
class AllAlaiseNameTest extends FunSuite with Matchers{
  val allAlaiseName=new AllAlaiseName

    test("handle null pointer exception"){
    intercept[NullPointerException]{
      allAlaiseName.tableAndAlaiseMap(null)
    }
  }
  test("get alaise name"){
    val columns=Set("orders.orderdate", "customers.customerid", "orders.customerid", "customers.customername", "orders.orderid")
    allAlaiseName.getAlaise(columns) shouldBe(Set("orders","customers"))
  }
  test("should remove alaise name from table"){
    val string="orders customers"
    allAlaiseName.removeAsAlaiseFromTable(string) shouldBe("orders customers")
  }
  test("check alaise name and table names are equal"){
    val alaise=Set("orders","customers")
    val tables=Set("orders","customers")
    allAlaiseName.checkAlaiseNameAndTableName(tables,alaise) shouldBe(true)
  }
}

