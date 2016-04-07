package com.aeq.sql.main

/**
  * Created by princya on 29/3/16.
  */

import scala.collection.mutable.ListBuffer

class AllColumnsName {
  def getColumnsAfterFrom(query:String):List[String]={

    val columnsAfterFrom = query.split(" ")
    val columns = new ListBuffer[String]()
    for (n <- columnsAfterFrom) {
      if (n.contains("=")) {
        columns += n
      }
    }
    return columns.toList
  }
  def getColumnsBeforeFrom(query:String):List[String]={

    val columnsBeforeFrom = query.replaceAll("select", "").replaceAll(" +", "")
    val splitColumns = columnsBeforeFrom.split(",").toList
    return splitColumns
  }
  def getAllColumns(columnsAfterFrom:List[String],columnsBeforeFrom:List[String]):Set[String]={
    if(columnsAfterFrom==null && columnsBeforeFrom==null) throw new NullPointerException("can't be null")
    val columnString = columnsAfterFrom.mkString(" ")+" "+columnsBeforeFrom.mkString(" ")
    val allTheColumns = columnString.split(Array(' ', '=')).toSet
    return allTheColumns
  }
}
