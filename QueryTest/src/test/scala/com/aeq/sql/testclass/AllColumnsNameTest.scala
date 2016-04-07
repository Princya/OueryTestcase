package com.aeq.sql.testclass

/**
  * Created by princya on 30/3/16.
  */
import com.aeq.sql.main.AllColumnsName
import org.scalatest.{FunSuite, Matchers, FunSpec}
class AllColumnsNameTest extends FunSuite with Matchers{

val allColumnsName=new AllColumnsName()
 
  test(" to handle null properly"){
    intercept[NullPointerException]{
      allColumnsName.getAllColumns(null,null)
    }
  }
  test(" should give Columns AfterFrom"){
	val query=" orders  customers  orders.customerid=customers.customerid"
	allColumnsName.getColumnsAfterFrom(query) shouldBe(List("orders.customerid=customers.customerid"))
}
 test("should give columns before from"){
   val query="orders.orderid, customers.customername, orders.orderdate"
   allColumnsName.getColumnsBeforeFrom(query) shouldBe(List("orders.orderid", "customers.customername", "orders.orderdate"))

 }
  test("should give all columns name"){
    val columnsAfterFrom:List[String]=List("orders.customerid=customers.customerid")
    val columnsBeforeFrom:List[String]=List("orders.orderid", "customers.customername", "orders.orderdate")
    allColumnsName.getAllColumns(columnsAfterFrom,columnsBeforeFrom) shouldBe(Set("orders.orderdate", "customers.customerid", "orders.customerid", "customers.customername", "orders.orderid"))

  }
}
