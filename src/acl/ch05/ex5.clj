(ns acl.ch05.ex5
  (:use clojure.contrib.def))

(defn- precedes-helper [col x pre preds]
  (if (empty? col)
    preds
    (let [el (first col)]
      (if (= el x)
        (recur (rest col) x el (conj preds pre))
        (recur (rest col) x el preds)))))

(defn precedes [col x]
  (precedes-helper  (rest col) x (first col) #{}))
