package com.aeq.sql.main

/**
  * Created by princya on 29/3/16.
  */
class AllTablesName {
  def tablesAsString(columnsAfterFrom:List[String],withoutKeywords:String):String={

     val multipleTablesAsString = columnsAfterFrom.foldLeft(withoutKeywords) { (res, cur) =>
     res.replaceAll(cur, "")
    }
    return multipleTablesAsString.trim
  }

  def getAllTables(alaise:Set[String],tableString:String):List[String]={

    if(alaise==null|tableString==null)throw new NullPointerException("ColumnsAfterFrom cannot be null")
    val string = tableString.split(" ").mkString(" ").trim()

    val removeAsAlaise = new AllAlaiseName()
    val splitTables = removeAsAlaise.removeAsAlaiseFromTable(string).trim().replaceAll(" +", " ").split(" ").toList
    return splitTables.toList

  }
}
