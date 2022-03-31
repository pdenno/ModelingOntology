# ModelingOntology

An ontology of manufacturing operations and Clojure-based tools to explore the ontology.

The ontology is currenlty composed of two namespaces/files and is DOLCE-based (using DOLCE Lite Plus).
 * [modeling.ttl](https://github.com/usnistgov/ModelingOntology/blob/master/resources/ontology/modeling.ttl) 
 defines concepts useful to mathematical modeling generally.

 * [operations.ttl](https://github.com/usnistgov/ModelingOntology/blob/master/resources/ontology/operations.ttl) 
 defines concepts for modeling production systems in an operations research context.

## Clerk Notebook Usage

In a Clojure REPL, (typically in the namespace of a notebook):
  *  `(require '[nextjournal.clerk :as clerk])`
  *  `(clerk/serve! {:browse? true})` -- this will start the notebook viewer in your web browser on port 7777.
  *  `(require '[pdenno.owl-db-tools.core      :as owldb :refer [*conn*]])` -- if you intend to manipulate the DB directly.

If you are using Emacs and its hooks for [Clerk](https://github.com/nextjournal/clerk#-using-clerk), 
`M-Ret` can be set up to update the notebook, otherwise use `(clerk/show! "notebooks/intro.clj")` in the REPL.

## ToDo

 * Link in logic-tools and develop a first-order logic definition of the ontology.
 * Class/subclass graph in the notebook. 
 * Update the ontology from a notebook.
