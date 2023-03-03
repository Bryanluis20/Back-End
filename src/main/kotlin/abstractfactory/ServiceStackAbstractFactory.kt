package abstractfactory

import properties.PropertiesUtil.loadProperty
import java.lang.Exception
import kotlin.reflect.full.createInstance

class ServiceStackAbstractFactory {
    companion object {
        fun createServiceFactory(): IServiceStackAbstractFactory? {
            val property = loadProperty(
                "properties/abstractfactory"
            )
            val factoryClass = property!!.getProperty("serviceProductImplClass")
            return try {
                Class.forName(factoryClass).kotlin.createInstance() as IServiceStackAbstractFactory
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }

    }
}