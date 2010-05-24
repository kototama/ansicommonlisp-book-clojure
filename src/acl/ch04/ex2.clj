(ns acl.ch04.ex2)
;; makes not so much sense since values are immutables
(defn copy-list [l]
  (reverse (reduce (fn [acc x] (cons x acc)) '() l)))

(defn my-reverse [l]
  (reduce (fn [acc x] (cons x acc)) () l))

;; or (reduce conj () coll)
;; like in clojure.core !
