(ns acl.ch05.ex3)

(defn square-floor5 [x]
  (when (not (and (> x 0) (<= x 5)))
    (* x x)))


