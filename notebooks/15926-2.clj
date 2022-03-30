;; # ISO 15926-2 Analysis 👋 
^{:nextjournal.clerk/visibility #{:hide-ns}}
(ns iso2
  (:require [nextjournal.clerk       :as clerk]
            [pdenno.logtools.parse   :as par]
            [pdenno.logtools.rewrite :as rew]))

;;; This notebook assesses whether Part 2 "templates" describe patterns of data use in a logically consistent way.

;;; We split the Part 2 axioms into two parts: `data/proto-templates.fol` and `data/base-templates.fol`.
;;; The file of `data/proto-templates.fol` equates (bi-conditional) what I'll call "triple literals" to types and relations.
;;; (What I mean by "triple literals" are 3-role literals that end in "Triple".)
;;; Potentially, these types and relation mean something in the domain.

;;; `ApprovalTriple(x,y,z) <-> Approval(x) & hasApproved(x,y) & hasApprover(x,z).`

;;; For each such "triple literal"

;;; `ApprovalTemplate(x,y) <-> exists z(ApprovalTriple(z,x,y)).`

;;; Here we read the file `data/proto-templates.fol`
(def protos (rew/rewrite* :fol/axioms "data/15926/proto-templates.fol" :rewrite? true :file? true))

;;; [ToDo: I'm not sure why it decides to provide the value of protos in the above.]

(def axioms (rew/rewrite* :fol/axioms "data/15926/axioms-from-web.fol" :rewrite? true :file? true))

(count protos)
(count axioms)
