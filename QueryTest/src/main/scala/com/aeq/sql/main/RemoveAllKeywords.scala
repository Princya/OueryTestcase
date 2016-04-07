package com.aeq.sql.main

/**
  * Created by princya on 29/3/16.
  */
class RemoveAllKeywords {
  val keywords = List("from", "inner join", "outer join", "left join", "right join", "on", "and", "where")
  def removeKeywords(query:String):String={
    if(query==null) throw new NullPointerException("removeKeywords cannot be null")
    val withoutKeywords = keywords.foldLeft(query) { (res, cur) =>
      res.replaceAll(cur, "")
    }
    return withoutKeywords
  }
}
