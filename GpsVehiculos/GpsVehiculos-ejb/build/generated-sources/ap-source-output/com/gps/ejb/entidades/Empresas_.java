package com.gps.ejb.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Empresas.class)
public abstract class Empresas_ {

	public static volatile SingularAttribute<Empresas, Integer> idempresa;
	public static volatile SingularAttribute<Empresas, String> nombrecontacto;
	public static volatile SingularAttribute<Empresas, String> nombreempresa;
	public static volatile SingularAttribute<Empresas, String> correo;
	public static volatile CollectionAttribute<Empresas, Vehiculos> vehiculosCollection;
	public static volatile SingularAttribute<Empresas, String> telcontacto;

}

