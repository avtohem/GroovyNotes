/*
Standard code for update DB
.. populate a SQLite database with large amounts of data 
pertaining to a number of classes requiring more than 5000 inserts and updates per class...

*/

Sql sql = Sql.newInstance("jdbc:sqlite:/home/ron/Desktop/test.db", "org.sqlite.JDBC") 
sql.execute("create table dummyTable(number)")
Long startTime = System.currentTimeMillis()
100.times {
     sql.execute("insert into dummyTable(number) values(${it})")
}
Long endTime = System.currentTimeMillis()
 
println "Time taken: " + ((endTime - startTime)/1000)

//The output of the above code comes out to be 14.313 seconds.

//withBatch() closure...
	
Sql sql = Sql.newInstance("jdbc:sqlite:/home/ron/Desktop/test.db", "org.sqlite.JDBC")
sql.execute("create table dummyTable(number)")
Long startTime = System.currentTimeMillis()
sql.withBatch {stmt-> 
    100.times {
      stmt.addBatch("insert into dummyTable(number) values(${it})")
    }
    stmt.executeBatch()
}
Long endTime = System.currentTimeMillis()
println "Time taken: " + ((endTime - startTime)/1000)

The time taken with the above code comes out to be 0.103 seconds! 
