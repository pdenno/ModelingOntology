(ns pdenno.modeling-ontology.core
  (:require
   [datahike.api                  :as d]
   [datahike.pull-api             :as dp]
   [pdenno.owl-db-tools.core      :as owldb :refer [*conn*]]))

(def sources
  {"cause"  {:uri "http://www.ontologydesignpatterns.org/ont/dlp/Causality.owl"  :ref-only? true},
   "coll"   {:uri "http://www.ontologydesignpatterns.org/ont/dlp/Collections.owl"},
   "colv"   {:uri "http://www.ontologydesignpatterns.org/ont/dlp/Collectives.owl"},
   "common" {:uri "http://www.ontologydesignpatterns.org/ont/dlp/CommonSenseMapping.owl"},
   "dlp"    {:uri "http://www.ontologydesignpatterns.org/ont/dlp/DLP_397.owl"},
   "dol"    {:uri "http://www.ontologydesignpatterns.org/ont/dlp/DOLCE-Lite.owl"},
   "edns"   {:uri "http://www.ontologydesignpatterns.org/ont/dlp/ExtendedDnS.owl"},
   "fpar"   {:uri "http://www.ontologydesignpatterns.org/ont/dlp/FunctionalParticipation.owl"},
   "info"   {:uri "http://www.ontologydesignpatterns.org/ont/dlp/InformationObjects.owl"},
   "modal"  {:uri "http://www.ontologydesignpatterns.org/ont/dlp/ModalDescriptions.owl"},
   "pla"    {:uri "http://www.ontologydesignpatterns.org/ont/dlp/Plans.owl"},
   "sem"    {:uri "http://www.ontologydesignpatterns.org/ont/dlp/SemioticCommunicationTheory.owl" :ref-only? true},
   "space"  {:uri "http://www.ontologydesignpatterns.org/ont/dlp/SpatialRelations.owl"},
   "soc"    {:uri "http://www.ontologydesignpatterns.org/ont/dlp/SocialUnits.owl"},
   "sys"    {:uri "http://www.ontologydesignpatterns.org/ont/dlp/Systems.owl"},
   "time"   {:uri "http://www.ontologydesignpatterns.org/ont/dlp/TemporalRelations.owl"},

   "model"  {:uri "http://modelmeth.nist.gov/modeling",   :access "resources/ontology/modeling.ttl",   :format :turtle},
   "ops"    {:uri "http://modelmeth.nist.gov/operations", :access "resources/ontology/operations.ttl", :format :turtle}})

(def db-cfg
  {:store {:backend :file :path "/tmp/datahike-ops-onto-db"}
             :keep-history? false
             :schema-flexibility :write})

;;; This establishes the DB and sets *conn*. It takes a minute or two.
(defn make-db!
  "Create the datahike DB from scratch. Takes a minute or two."
  [cfg]
  (when (d/database-exists? cfg) (d/delete-database cfg))
  (owldb/create-db!
   cfg
   sources
   :rebuild? true
   :check-sites ["http://ontologydesignpatterns.org/wiki/Main_Page"]))

(defn update-db!
  "Update the DB with changes from the locally-defined modeling.ttl and operations.ttl"
  [])
