package com.aeq.sql.main

/**
  * Created by princya on 29/3/16.
  */
class SplitQuery {

  def splitQuery(query: String) :List[String]={
    if(query==null) throw new NullPointerException("splitQuery cannot be null")

    val lower = query.toLowerCase();
    val tables = lower.split("from").toList
    println(tables)
    return tables
  }
}
