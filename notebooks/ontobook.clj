;;; # Operations Modeling Ontology 👋
^{:nextjournal.clerk/visibility #{:hide-ns}}
(ns ontobook
  (:require [nextjournal.clerk             :as clerk]
            [nextjournal.clerk.viewer      :as v]
            [pdenno.modeling-ontology.core :as onto]
            [pdenno.owl-db-tools.resolvers :as res]
            [datahike.pull-api             :as dp]
            [datahike.api                  :as dhike]))

;;; This notebook explores the manufacturing operations ontology maintained in the git repository that also contains
;;; this notebook source.
;;; The first time the notebook is used, you'll have to create the DB, pulling DOLCE Lite Plus (DLP) ontologies from
;;; [ontologydesignpatterns.org](http://ontologydesignpatterns.org/wiki/Main_Page) and local ontologies from
;;; the directory `resources/ontology` in this repository. (See the function `onto/make-db!`)

;;; `onto/db-cfg` provides information needed to connect to the database.
onto/db-cfg

(def conn (dhike/connect onto/db-cfg))

^{:nextjournal.clerk/visibility #{:hide}}
#_(clerk/set-viewers!
 (->> v/default-viewers
      #_(mapv #(cond-> % (contains? % :fetch-opts)
                     (assoc-in [:fetch-opts :n] 500)))
      (mapv #(if (= 'v/quoted-string-viewer (:render-fn %))
               (assoc-in % [:fetch-opts :n] 400)
               %))))

#_(clerk/set-viewers! [(some #(when (= string? (:pred %)) (assoc-in % [:fetch-opts :n] 400)) v/default-viewers)])

(clerk/set-viewers! [(some (fn [{:as viewer :keys [pred]}]
                             (when (and pred (pred "abc"))
                               (assoc-in viewer [:fetch-opts :n] 400)))
                           v/default-viewers)])


(defn query-ns
  "Get basic information about a resource in a vector of maps."
  [ns-string]
  (->> (dhike/q '[:find ?iri ?name ?comment
                  :keys iri name description
                  :where
                  [?e :resource/iri  ?iri]
                  ;[?e :rdf/type :owl/Class]
                  [?e :resource/name ?name]
                  [?e :rdfs/comment  ?comment]] @conn)
       (filter #(= ns-string (-> % :iri namespace)))
       (map #(dissoc % :iri))
       (sort-by :name)))

;;; Here are classes from the operations namespace.
(-> "ops" query-ns clerk/table)


;;; Here are classes from the modeling namespace.
(-> "model" query-ns clerk/table)
