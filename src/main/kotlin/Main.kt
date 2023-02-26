import factorymethod.IDBAdapter
import factorymethod.MySqlDBAdapter
import factorymethod.OracleDBAdapter
import factorymethod.PostgreSqlDBAdapter
import properties.PropertiesUtil
import java.util.Properties

fun main(args: Array<String>) {
   /* val property: Properties? = PropertiesUtil
        .loadProperty("properties/DBMySQL")
    println(property)*/



   //conection de mysql
/*
val mySql: IDBAdapter =  MySqlDBAdapter()
println(mySql.getConnection().toString())
//coneccion de oracle
*/
    //Conexion con Oracle
    /*
val oracle: IDBAdapter =  OracleDBAdapter()
println(oracle.getConnection().toString())
 */


    //Conexion con PostgreSQL
    val postgresql: IDBAdapter = PostgreSqlDBAdapter()
    println(postgresql.getConnection().toString())


}