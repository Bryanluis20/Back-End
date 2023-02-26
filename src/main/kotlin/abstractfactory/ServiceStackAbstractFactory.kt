package abstractfactory

import properties.PropertiesUtil.loadProperty
import java.lang.Exception
import kotlin.reflect.full.createInstance

class ServiceStackAbstractFactory {
    fun createServiceFactory(): IServiceStackAbstractFactory? {
        val property = loadProperty(
           "property/abstractfactory"

        )
        val factoryClass = property!!.getProperty("ServiceProductImplClass")
        return try {
            Class.forName(factoryClass).kotlin.createInstance()
                    as IServiceStackAbstractFactory
        } catch (e: Exception){
            e.printStackTrace()
            null
        }
    }

}