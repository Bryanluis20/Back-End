package visitor

import jakarta.xml.bind.annotation.*

@XmlRootElement(name = "Activitie")
@XmlAccessorType(XmlAccessType.FIELD)
class Activitie : IVisitable {

    @XmlAttribute(name = "name")
    private var name: String? = null

    @XmlAttribute(name = "price")
    private var price: Double = 0.0

    @XmlElement(name = "responsible")
    private var responsible: Employee? = null

    @XmlElement(name = "Activities")
    private var activities: MutableList<Activitie>? = null

    constructor() // Constructor por defecto para JAXB

    constructor(name: String, price: Double, responsible: Employee) {
        this.name = name
        this.price = price
        this.responsible = responsible
    }

    fun getActivities(): MutableList<Activitie> {
        if (activities == null) {
            activities = ArrayList()
        }
        return activities as MutableList<Activitie>
    }

    fun setActivities(activities: MutableList<Activitie>) {
        this.activities = activities
    }

    fun addActivitie(activitie: Activitie) {
        if (activities == null) {
            activities = ArrayList()
        }
        activities!!.add(activitie)
    }

    fun removeActivitie(activitie: Activitie) {
        activities!!.remove(activitie)
    }

    override fun accept(visitor: IVisitor<*>) {
        visitor.activitie(this)
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getPrice(): Double {
        return price
    }

    fun setPrice(price: Double) {
        this.price = price
    }

    fun getResponsible(): Employee? {
        return responsible
    }

    fun setResponsible(responsible: Employee) {
        this.responsible = responsible
    }
}
