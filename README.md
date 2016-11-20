# ModelingOntology

An OWL ontology to support analytical investigations of manufacturing processes. The ontology is composed of three files:
 * [modeling.ttl](https://github.com/usnistgov/ModelingOntology/blob/master/modeling.ttl) defines the upper-level ontology.
 * [machining.ttl](https://github.com/usnistgov/ModelingOntology/blob/master/machining.ttl) defines concepts for modeling machining processes.
 * [operations.ttl](https://github.com/usnistgov/ModelingOntology/blob/master/operations.ttl) defines concepts for modeling production systems. (It has an operations research focus.)

The ontology imports QUDT, which imports dtypes, vaem. Notice that we currently supply files defining these. None of these were modified from what is available at [qudt.org](http://www.qudt.org/release2/qudt-catalog.html). However, in the past (old version of QUDT), we experienced problems loading these models into Protege, so we kept our own modified versions. The hope is that these new versions won't need to be touched and won't be in our repository much longer.



