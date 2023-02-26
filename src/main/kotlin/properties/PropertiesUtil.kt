package properties

import java.lang.Exception
import java.util.*

object PropertiesUtil {
    fun loadProperty(propertiesUrl: String?): Properties?{
        return try {
            val properties = Properties()
            val inputStream = PropertiesUtil::class.java
                .classLoader.getResourceAsStream(propertiesUrl)
            properties.load(inputStream)
            properties
        } catch (e: Exception){
            //e.printStackTrace()
            null
        }
    }
}