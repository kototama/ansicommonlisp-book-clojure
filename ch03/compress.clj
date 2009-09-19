(use 'clojure.contrib.def)

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
	(into rst (apply #(take %1 (iterate identity %2)) elt))
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

(compress '(1 1 1 0 1 0 0 0 0 1)) ;; ((3 1) 0 1 (4 0) 1)
(uncompress '((3 1) 0 1 (4 0) 1)) ;; (1 1 1 0 1 0 0 0 0 1)
