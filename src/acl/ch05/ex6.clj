(ns acl.ch05.ex6)

(defn myinterpose [sep col]
  (butlast (reduce (fn [acc x] (concat acc [x sep])) [] col)))

(defn myinterpose2 [sep col]
  (loop [[x nxt :as col] col
         res []]
    (if (nil? nxt)
      (concat res [x])
      (recur (rest col) (concat res [x sep])))))

;; or with more elegance:
;;
;; (defn interpose
;; [sep coll] (drop 1 (interleave (repeat sep) coll)))
;; in clojure.core !!
