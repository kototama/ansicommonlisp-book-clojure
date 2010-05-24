(ns acl.ch03.compress
 (:use clojure.contrib.def))

(declare compr pack)

(defn compress [x]
  (if (list? x)
    (compr (first x) 1 (rest x))
    x))

(defn uncompress [lst]
  (if (empty? lst)
    nil
    (let [elt (first lst)
	  rst (uncompress (rest lst))]
      (if (list? elt)
	(concat (apply #(take %1 (repeat %2)) elt) rst)
	(cons elt rst)))))

(defn- compr [elt n lst]
  (if (empty? lst)
    (list (pack elt n))
    (let [nxt (first lst)]
      (if (= nxt elt)
	(compr elt (inc n) (rest lst))
	(cons (pack elt n)
	      (compr nxt 1 (rest lst)))))))

(defn- pack [elt n]
  (if (> n 1)
    (list n elt)
    elt))
